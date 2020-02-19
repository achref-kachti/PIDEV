/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Logement;
import com.esprit.Service.ServiceLogement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author House
 */
public class AdminUserController implements Initializable {

  
    @FXML
    private Button btn_Admin;
    @FXML
    private Button btn_User;
    @FXML
    private ImageView img_BackgroundAdminUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  /*  @FXML
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminUser.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
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
