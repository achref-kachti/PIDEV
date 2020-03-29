/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class Admin_acceuilController implements Initializable {

    @FXML
    private JFXButton btn_event;
    @FXML
    private JFXButton btn_guides;
    @FXML
    private JFXButton btn_logement;
    @FXML
    private JFXButton btn_transport;
    @FXML
    private JFXButton btn_panier;
    @FXML
    private JFXButton btn_espece;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void go_to_event(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           
             Parent root = loader.load();
           
             FXMLDocumentController apc = loader.getController();
                 btn_event.getScene().setRoot(root);
    }

    @FXML
    private void go_to_guides(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
           
             Parent root = loader.load();
           
             Admin_1Controller apc = loader.getController();
                 btn_guides.getScene().setRoot(root);
    }

    @FXML
    private void go_to_logement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           
             Parent root = loader.load();
           
             FXMLDocumentController apc = loader.getController();
                 btn_event.getScene().setRoot(root);

    }

    @FXML
    private void go_to_transport(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           
             Parent root = loader.load();
           
             FXMLDocumentController apc = loader.getController();
                 btn_event.getScene().setRoot(root);

    }

    @FXML
    private void go_to_panier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
           
             Parent root = loader.load();
           
             AdminController apc = loader.getController();
                 btn_event.getScene().setRoot(root);

    }

    @FXML
    private void go_to_espece(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           
             Parent root = loader.load();
           
             FXMLDocumentController apc = loader.getController();
                 btn_event.getScene().setRoot(root);

    }
    
}
