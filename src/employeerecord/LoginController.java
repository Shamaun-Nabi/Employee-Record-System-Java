/*
 * Md Shamaun Nabi
 * Ashik * 
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author snash
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginPane;
    @FXML
    private VBox WelcomePage;
    @FXML
    private Button designButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginName;
    @FXML
    private PasswordField loginPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAccess(ActionEvent event) {
        if(loginName.getText().equalsIgnoreCase("ashik")&&loginPassword.getText().equalsIgnoreCase("1234"))
        {
            try {
                Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
                loginPane.getChildren().setAll(root);
                
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(loginName.getText().equals("")&&loginPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Name And Password");
        }
        else{
            JOptionPane.showMessageDialog(null, "Login Failed");
        }
    }

    @FXML
    private void SignUpAction(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Go Our Website To Sign In");
        
    }

  
    
}
