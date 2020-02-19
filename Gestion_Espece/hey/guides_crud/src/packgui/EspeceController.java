/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import Service.ServiceEspece;
import entites.Espece;
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

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author moetez
 */
public class EspeceController implements Initializable {


    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_saison;
    @FXML
    private TextField tf_description;
    @FXML
    private TextField tf_type;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField tf_nom_modif;
    @FXML
    private TextField tf_saison_modif;
    @FXML
    private TextField tf_description_modif;
    @FXML
    private TextField tf_type_modif;
    @FXML
    private Button btn_modifier;
    @FXML
    private TextField tf_espece_supprimer;
    @FXML
    private Button btn_supprimer;
      @FXML
    private TableView<Espece> tab_afficher_especes;
    @FXML
    private TableColumn<Espece, String> col_id;
    @FXML
    private TableColumn<Espece, String> col_nom;
    @FXML
    private TableColumn<Espece, String> col_type;
    @FXML
    private TableColumn<Espece, String> col_saison;
    @FXML
    private TableColumn<Espece, String> col_description;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
        try {
            list = sl.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
         /*       col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_description.setCellValueFactory(new PropertyValueFactory<>("description"));*/
             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));*/
               
               tab_afficher_especes.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(EspeceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void ajouter_espece(ActionEvent event) {
        
        
    }

    @FXML
    private void modifier_espece(ActionEvent event) {
    }

    @FXML
    private void supprimer_espece(ActionEvent event) {
    }

}
      /*  catch (SQLException ex) {*/
           /* Logger.getLogger(EspeceController.class.getName()).log(Level.SEVERE, null, ex);       
         /*       col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_description.setCellValueFactory(new PropertyValueFactory<>("description"));*/
             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
         /*      tab_afficher_guides.setItems(obs);*/
     /*   } catch (SQLException ex) {
            Logger.getLogger(Admin_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    @FXML
    private void ajouter_espece(ActionEvent event) {
        
        
    }

    @FXML
    private void modifier_espece(ActionEvent event) {
    }

    @FXML
    private void supprimer_espece(ActionEvent event) {
    }
*/

