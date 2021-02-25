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
public class JustSalaryController implements Initializable {

   @FXML
    private Button backButton;

    @FXML
    private Button homeButton;
    @FXML
    private TextField justSalaryId;
    @FXML
    private Button justCheck;
    @FXML
    private TextField outputSal;
    
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
      alert.setTitle("Employee Not Found");
      alert.setHeaderText("Sorry!! No Employee Found At This ID!!");
      alert.setContentText("Enter Correct Id Number");
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
           Logger.getLogger(JustSalaryController.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(JustSalaryController.class.getName()).log(Level.SEVERE, null, ex);
           showStopAlert();
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void justCheckButton(ActionEvent event) {
        try {
        Connect c= new Connect();
        c.searchId=justSalaryId.getText();
        String res=c.Salary();
        outputSal.setText(res);
        } 
        catch (Exception e) 
        {
           showWarningAlert();
        }
        
        
    }
    
}
