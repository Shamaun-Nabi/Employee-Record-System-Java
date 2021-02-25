/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeerecord;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Devloped By Shamaun Nabi
 * 
 */

public class EmployeeRecord extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage= new Stage();
            Scene scene= new  Scene(root);
            scene.getStylesheets().add(getClass().getResource("CssFile.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Devloped By Shamaun Nabi");
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Connect.savaData();
                }
            });
            
   
        } 
        
        
        catch (IOException ex) {
            System.out.println(ex);
        }
    
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connect.loadData();
        launch(args);
    }
    
}
