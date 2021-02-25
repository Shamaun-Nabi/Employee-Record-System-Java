
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


public class UpdateSalaryFormController implements Initializable {
   @FXML
    private Button backButton;

    @FXML
    private Button homeButton;
    @FXML
    private TextField employeId;
    @FXML
    private Button update;
    @FXML
    private TextField amount;
    
         public void showStopAlert()
    {
       Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
    
    
       public void showWarningAlert()
    {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Updated Failed");
      alert.setHeaderText("Update Failed");
      alert.setContentText("Please Give The Correct Id Number and Amount fill Up");
      alert.show();
    }
       
          public void showSuccesAlert()
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Updated");
      alert.setHeaderText("Updated Succesfully");
      alert.setContentText("Infromation Submitted!!");
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
           Logger.getLogger(UpdateSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(UpdateSalaryFormController.class.getName()).log(Level.SEVERE, null, ex);
           showStopAlert();
           
       }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void getUpdate(ActionEvent event) {
        try {
          String id= employeId.getText();
        String am= amount.getText();
        double amt= Double.parseDouble(am);
        Connect c= new  Connect();
        c.searchId=id;
        c.amt=amt;
        String s=c.updateSalary();
        
           if("Yes".equals(s))
        {
            
            showSuccesAlert();
        }
        else{
            
            showWarningAlert();
        }
        employeId.setText("");
        amount.setText("");
      
        
        
       
        } 
        catch (NumberFormatException e) 
        {
            showWarningAlert();
        }
   
            
    }
    
}
