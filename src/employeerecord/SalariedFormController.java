
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

public class SalariedFormController implements Initializable {
      @FXML
    private TextField salariedName;
      
    @FXML
    private TextField salariedID;
    
    @FXML
    private TextField salariedDesignation;

    @FXML
    private Button submitSalariedInfo;

    @FXML
    private TextField salariedMonthSalary;

     @FXML
    private Button backButton;

    @FXML
    private Button homeButton;

    //AlertBox Showing start
    public void showErrorAlert()
    {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Sorry");
      alert.setHeaderText("You Have To fill Up All Information Properly");
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
      alert.setTitle("Wrong Information");
      alert.setHeaderText("Salary Must Be Number Format");
      alert.setContentText(" Salary = 100");
      alert.show();
    }
     
          public void showStopAlert()
    {
       Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
    
    
    
    //AlertBox Showimg End
    
      @FXML
    void submitSalariedInfoHandel(ActionEvent event) {
   if(salariedName.getText().equals("") || salariedID.getText().equals("") || salariedDesignation.getText().equals("") || salariedMonthSalary.getText().equals(""))
    {
        
        showErrorAlert();
    }
    else
   {
    try {
       String name=salariedName.getText();
       String id= salariedID.getText();
       String des= salariedDesignation.getText();
       String salary=salariedMonthSalary.getText();
       
       double salaryToDouble=Double.parseDouble(salary);
       showSuccesAlert();
       Connect c= new  Connect();
       c.salaried(name, id, des, salaryToDouble);
       
        salariedName.setText("");
        salariedID.setText("");
        salariedDesignation.setText("");
        salariedMonthSalary.setText("");
       
      
       
       }
       catch (NumberFormatException e) {
            showWarningAlert();
       }   
   } 
   
    }
    
      

    @FXML
    void goHome(ActionEvent event)  {
          try {
              Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
              Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
              Scene scene= new  Scene(root);
              window.setScene(scene);
              window.show();
          } 
          catch (IOException ex)
          {
              Logger.getLogger(SalariedFormController.class.getName()).log(Level.SEVERE, null, ex);
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
          } 
          catch (IOException ex)
          {
              Logger.getLogger(SalariedFormController.class.getName()).log(Level.SEVERE, null, ex);
              showStopAlert();
          }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
    
}
