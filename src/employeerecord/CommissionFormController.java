/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author snash
 */
public class CommissionFormController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button homeButton;
    @FXML
    private TextField commisionName;
    @FXML
    private TextField commisionId;
    @FXML
    private TextField commsionDes;
    @FXML
    private Button commsionSubmit;
    @FXML
    private TextField commisonRate;
    @FXML
    private TextField commisionSale;
    
       public void showStopAlert()
    {
       Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
    
    
     public void showErrorAlert()
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Sorry");
      alert.setHeaderText("You Have To fill Up All Information Properly");
      alert.showAndWait();
    }
    
    public void showSuccesAlert()
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Information Added");
      alert.setHeaderText("Congratulation!!Infromation SuccesFully Submitted ");
      alert.showAndWait();
    }
     public void showWarningAlert()
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Wrong Information");
      alert.setHeaderText("Salary Must Be Number Format");
      alert.setContentText(" Salary = 100");
      alert.show();
    }

    @FXML
    void goHome(ActionEvent event)  {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene= new  Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(CommissionFormController.class.getName()).log(Level.SEVERE, null, ex);
            showStopAlert();
        }
    }

    @FXML
    void goToBack(ActionEvent event)  {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
            Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene= new  Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(CommissionFormController.class.getName()).log(Level.SEVERE, null, ex);
            showStopAlert();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void commsionSubmitButton(ActionEvent event) {
        
        
    if(commisionName.getText().equals("") || commisionId.getText().equals("") || commsionDes.getText().equals("") || commisonRate.getText().equals("")|| commisionSale.getText().equals(""))
    {
        
        showErrorAlert();
    }
    else
   {
    try {
       String name=commisionName.getText();
       String id= commisionId.getText();
       String des= commsionDes.getText();
       String comsionRate=commisonRate.getText();
       String comisionSale=commisionSale.getText();
       double comrateToDouble=Double.parseDouble(comsionRate);
       double comSaleToDouble=Double.parseDouble(comsionRate);
       showSuccesAlert();
       Connect c= new  Connect();
       c.commission(name, id, des, comSaleToDouble, comSaleToDouble);
       commisionName.setText("");
       commisionId.setText("");
       commsionDes.setText("");
       commisonRate.setText("");
       commisionSale.setText("");
       
       
       }
       catch (NumberFormatException e) {
             showWarningAlert();
       }   
   }
        
        
    }
    
}
