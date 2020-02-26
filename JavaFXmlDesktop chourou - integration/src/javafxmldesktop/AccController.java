/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

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
 * @author nature
 */
public class AccController implements Initializable {

    @FXML
    private Button btn_admin;
    @FXML
    private ImageView img_admin;
    @FXML
    private Button btn_user;
    @FXML
    private ImageView img_user;

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
    private void Admin(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
            
                Parent root = loader.load();
              Admin_1Controller apc = loader.getController();
               
                btn_admin.getScene().setRoot(root);
    }

    @FXML
    private void User(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User_informations.fxml"));
            
                Parent root = loader.load();
                User_informationsController apc = loader.getController();
                
                btn_user.getScene().setRoot(root);
    }
    
}
