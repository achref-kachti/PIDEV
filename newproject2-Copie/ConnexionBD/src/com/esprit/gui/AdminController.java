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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author House
 */
public class AdminController implements Initializable {

  
    @FXML
    private Button btn_LogementAdmin;
    @FXML
    private Button btn_ResLogementAdmin;
    @FXML
    private Button btn_RestaurantAdmin;
    @FXML
    private Button btn_ResRestaurantAdmin;
    @FXML
    private Button btn_RetourAdmin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void LogementAdmin(ActionEvent event) throws IOException{
            
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
        Parent root=fxml.load();
        btn_LogementAdmin.getScene().setRoot(root);
        AdminLogementController ac = fxml.getController();

    }
    
    
    @FXML
    private void ResLogementAdmin(ActionEvent event) throws IOException{
            
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminResLogement.fxml"));
        Parent root=fxml.load();
        btn_ResLogementAdmin.getScene().setRoot(root);
        AdminResLogementController ac = fxml.getController();
        
    }
    
    
    @FXML
    private void RestaurantAdmin(ActionEvent event) throws IOException{
            
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminRestaurant.fxml"));
        Parent root=fxml.load();
        btn_RestaurantAdmin.getScene().setRoot(root);
        AdminLogementController ac = fxml.getController();
        
    }
    
    @FXML
    private void ResRestaurantAdmin(ActionEvent event) throws IOException{
            
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminResRestaurant.fxml"));
        Parent root=fxml.load();
        btn_ResRestaurantAdmin.getScene().setRoot(root);
        AdminLogementController ac = fxml.getController();
        
    }

    @FXML
    private void RetourAdmin(ActionEvent event) throws IOException {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminUser.fxml"));
        Parent root=fxml.load();
        btn_RetourAdmin.getScene().setRoot(root);
        AdminUserController ac = fxml.getController();
        
    }
  
    
}
