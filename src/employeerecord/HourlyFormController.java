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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HourlyFormController implements Initializable {

        @FXML
    private Button backButton;

    @FXML
    private Button homeButton;
    @FXML
    private TextField hourlyName;
    @FXML
    private TextField hourlyId;
    @FXML
    private TextField hourlyDesignation;
    @FXML
    private Button HourlySubmit;
    @FXML
    private TextField hourlyRate;
    @FXML
    private TextField HourWorked;
    
    
         public void showStopAlert()
    {
       Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
    
    
    public void showSuccesAlert()
    {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Added");
      alert.setHeaderText("Congratulation!!Infromation SuccesFully Submitted ");
      alert.showAndWait();
    }
     public void showWarningAlert()
    {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Wrong Information!!");
      alert.setHeaderText("Salary Must Be Number Format");
      alert.setContentText(" Example: Salary = 100");
      alert.show();
    }

    @FXML
    void goHome(ActionEvent event) {

            try {
                Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene= new  Scene(root);
                window.setScene(scene);
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(HourlyFormController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(HourlyFormController.class.getName()).log(Level.SEVERE, null, ex);
                showStopAlert();
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HourlySubmitButton(ActionEvent event) {
        
        if(hourlyName.getText().equals("") || hourlyId.getText().equals("") || hourlyDesignation.getText().equals("") ||HourWorked.getText().equals("")||hourlyRate.getText().equals(""))
    {
        
        showWarningAlert();
    }
    else
   {
    try {
       String name=hourlyName.getText();
       String id= hourlyId.getText();
       String des= hourlyDesignation.getText();
       String hourwork=HourWorked.getText();
       String hourRate=hourlyRate.getText();
     int hw=Integer.parseInt(hourwork);
     double hr =Double.parseDouble(hourRate);
     hourlyName.setText("");
     hourlyId.setText("");
     hourlyDesignation.setText("");
     HourWorked.setText("");
     hourlyRate.setText("");
     
       
       showSuccesAlert();
       Connect c= new  Connect();
       c.hourly(name, id, des, hr, hw);
       
       }
       catch (NumberFormatException e) {
             showWarningAlert();
       }   
   } 
   
    }
        
    }
    

