/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UserController implements Initializable {

    @FXML
    private Button btn_LogementUser;
    @FXML
    private Button btn_RestaurantUser;
   
    @FXML
    private ImageView Img_imgBackgUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogementUser(ActionEvent event) throws IOException {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("UserLogement.fxml"));
        Parent root=fxml.load();
        btn_LogementUser.getScene().setRoot(root);
        UserLogementController ac = fxml.getController();
        
    }

    

    @FXML
    private void RestaurantUser(ActionEvent event) {
    }

    
    
}
