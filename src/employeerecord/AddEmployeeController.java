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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author snash
 */
public class AddEmployeeController implements Initializable {
    
   @FXML
    private Button goHome;
      @FXML
    private Button salariedEmployee;

    @FXML
    private Button hourlyEmployee;

    @FXML
    private Button commisionEmployee;

     public void showWarningAlert()
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
    
     ///Event For Hourly Employee Button
    @FXML
    void HourlyTextField(ActionEvent event){
        
        try {
           Parent root=FXMLLoader.load(getClass().getResource("HourlyForm.fxml"));
           Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene= new  Scene(root);           
           window.setScene(scene);
           window.show();
            
        } catch (IOException e) {
           showWarningAlert();
        }
        
    
    }
    
    //end
    
    ///Event For Salaried Employee Button
    @FXML
    void SalariedTextField(ActionEvent event)  {
        
       try {
           Parent root=FXMLLoader.load(getClass().getResource("SalariedForm.fxml"));
           Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene= new  Scene(root);
           window.setScene(scene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(AddEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
           showWarningAlert();
       }

    }
    
    ///End
    
    
     ///Event For Commssion Employee Button

    @FXML
    void commissionTextField(ActionEvent event){
       try {
           Parent root=FXMLLoader.load(getClass().getResource("CommissionForm.fxml"));
           Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene= new  Scene(root);           
           window.setScene(scene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(AddEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
           showWarningAlert();
       }
    }
    
    ///End
    
      @FXML
    void GoHome(ActionEvent event) {
       try {
           Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
           Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
           Scene scene= new  Scene(root);           
           window.setScene(scene);
           window.show();
       } catch (IOException ex) {
           Logger.getLogger(AddEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
           showWarningAlert();
       }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
