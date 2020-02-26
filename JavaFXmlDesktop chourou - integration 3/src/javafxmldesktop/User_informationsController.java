/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author nature
 */
public class User_informationsController implements Initializable {

    @FXML
    private Button btn_weather;
    @FXML
    private ImageView img_weather;
    @FXML
    private TableView<Guide> tab_dispo;
    @FXML
    private TableColumn<Guide, String> col_nom;
    @FXML
    private TableColumn<Guide, String> col_prenom;
    @FXML
    private TableColumn<Guide, String> col_adresse;
    @FXML
    private TableColumn<Guide, String> col_telephone;
    @FXML
    private TableColumn<Guide, String> col_specialite;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceGuide sl = new ServiceGuide();
        List<Guide> list;
        try {
            list = sl.readAll();
       
            ObservableList<Guide> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
               
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_dispo.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void afficher_weather(ActionEvent event) throws IOException{
        Stage primaryStage = null;
			 FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("Window.fxml"));
                         
                         
		
}
}
