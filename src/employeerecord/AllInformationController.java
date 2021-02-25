
package employeerecord;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
 
public class AllInformationController implements Initializable {
     @FXML
    private ListView<String> informationTable;
    @FXML
    private Button backButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button showAll;
    
    
     public void showWarningAlert()
    {
       Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Application Run Failed");
      alert.setHeaderText("Close And Run again");
      alert.showAndWait();
    }
        public void showWarningAlert2()
    {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Add Employees To Show Result ");
      alert.setHeaderText("Employee List Is Empty");
      alert.showAndWait();
    }

    @FXML
    void clickToShow(ActionEvent event) {
        
      
         
      Connect b= new  Connect(); 
      ArrayList<Employee> em= b.showres();
      informationTable.getItems().clear();
      for(int i=0; i<em.size();i++)
      {
          
          Employee e= em.get(i);
          String ob= e.display();
          informationTable.getItems().add(ob);
          
         
      }
      if(informationTable.getItems().isEmpty())
      {
          showWarningAlert2();
         
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
         } catch (IOException ex) {
             Logger.getLogger(AllInformationController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    @FXML
    void goToBack(ActionEvent event)  {
        
         try {
             Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
             Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
             Scene scene= new  Scene(root);
             window.setScene(scene);
             window.show();
         } catch (IOException ex) {
             Logger.getLogger(AllInformationController.class.getName()).log(Level.SEVERE, null, ex);
             showWarningAlert();
         }

    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
              
    }    
    
}
