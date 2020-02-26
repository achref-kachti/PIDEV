/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;
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

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class User_acceuilController implements Initializable {

    @FXML
    private JFXButton btn_user_event;
    @FXML
    private JFXButton btn_user_logemet;
    @FXML
    private JFXButton btn_user_espece;
    @FXML
    private JFXButton btn_panier_user;
    @FXML
    private JFXButton btn_transport_user;
    
    users u=new users(66 ,"yousef" ,"zghal" ,"youssef@gmail.com" ,"youssef2010" ,new java.sql.Date(97, 11, 20),99377068  );
  public void setUser(users user)
    {
        this.u=user;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void go_to_user_event(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
          
          Parent root = loader.load();
           
             FXMLController apc = loader.getController();
             apc.setUser(u);
             apc.rafraichir();
                 btn_user_event.getScene().setRoot(root);
           //iuser_c.setUser(u);
              //iuser_c.rafraichir();
    }

    @FXML
    private void go_to_user_logement(ActionEvent event) {
    }

    @FXML
    private void go_to_user_espece(ActionEvent event) {
    }

    @FXML
    private void go_to_panier_user(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
          
          Parent root = loader.load();
           
             UserController apc1 = loader.getController();
             apc1.setUser(u);
        try {
            apc1.buildData();
        } catch (SQLException ex) {
            Logger.getLogger(User_acceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 btn_user_event.getScene().setRoot(root);
    }

    @FXML
    private void go_to_transport_user(ActionEvent event) {
    }
    
}
