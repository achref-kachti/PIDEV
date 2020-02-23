/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafxapplication1.AffichePersonneController;

/**
 * FXML Controller class
 *
 * @author nature
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btn_user;
    @FXML
    private Button btn_admin;

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
    private void User(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
            
                Parent root = loader.load();
                AffichePersonneController apc = loader.getController();
                
                btn_user.getScene().setRoot(root);
    }

    @FXML
    private void Admin(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("espe.fxml"));
            
                Parent root = loader.load();
             EspeController apc = loader.getController();
               
                btn_admin.getScene().setRoot(root);
    }
    
}
