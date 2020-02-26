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
public class AdminController implements Initializable {

    @FXML
    private Button btn_Transport;
    @FXML
    private Button btn_Chauffeurs;
    @FXML
    private Button btn_Users;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Transport(ActionEvent event) {
         FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminVehicule.fxml"));
       try {
        Parent root=fxml.load();
        btn_Transport.getScene().setRoot(root);
       } catch (IOException ex){
           System.out.println(ex.getMessage());
       }
       // AdminTransportController atc = fxml.getController();
    }

    @FXML
    private void Chauffeurs(ActionEvent event) {
        
         FXMLLoader fxml = new FXMLLoader(getClass().getResource("AdminChauffeurs.fxml"));
       try {
        Parent root=fxml.load();
        btn_Chauffeurs.getScene().setRoot(root);
       } catch (IOException ex){
           System.out.println(ex.getMessage());
       }
       // AdminTransportController atc = fxml.getController();
        
    }

    @FXML
    private void Users(ActionEvent event) {
    }
    
}
