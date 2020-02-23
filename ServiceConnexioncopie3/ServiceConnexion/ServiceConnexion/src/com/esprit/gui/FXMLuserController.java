/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.esprit.Entite.users;
import com.esprit.Service.userService;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FXMLuserController implements Initializable {
    userService userc=new userService();
    @FXML
    private JFXPasswordField password_user;
    @FXML
    private JFXTextField email_user;
    @FXML
    private JFXButton acceder_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acceder_clicked(ActionEvent event) throws IOException  {
        
        String email=email_user.getText();
        String password=password_user.getText();
        users u=new users();
        boolean exist=false;
        try {
            exist=userc.user_exit(password, email);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        if((email.equals("admin@gmail.com")) && password.equals("admin"))
        {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
             Parent root = loader.load();
             //FXMLDocumentController apc = loader.getController();
               AdminController apc = loader.getController();
               
             
                 email_user.getScene().setRoot(root);
             
        
        }
        else if(exist==true)
        {
            System.out.println("user normal existant");
            try {
                u=userc.recuperer_user_email(email);
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
             Parent root = loader.load();
             /*thez les infos lel controller lekher*/
           //  FXMLController iuser_c = loader.getController();
            //iuser_c.setUser(u);
             
                 email_user.getScene().setRoot(root);
             
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("Utilisateur");
                 alert.setHeaderText("utilisateur inexistant");
                alert.setContentText("svp verifierz vos données");
                 alert.showAndWait();
        
        }
         
        
          
        }
    
    
    
}
