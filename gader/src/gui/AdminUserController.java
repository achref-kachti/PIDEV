/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AdminUserController implements Initializable {

    @FXML
    private Button btn_Admin;
    @FXML
    private Button btn_User;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

      @FXML
     private void Admin(ActionEvent event) throws IOException {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Admin.fxml"));
        Parent root=fxml.load();
        btn_Admin.getScene().setRoot(root);
        AdminController ac = fxml.getController();
        
        //Scene scene = new Scene(root);
        //event.setScene(scene);
        //event.show(); 
    }
    
    
    @FXML
    private void User(ActionEvent event) throws IOException {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("User.fxml"));
        Parent root=fxml.load();
        btn_User.getScene().setRoot(root);
        UserController ac = fxml.getController();
    } 
    
}
