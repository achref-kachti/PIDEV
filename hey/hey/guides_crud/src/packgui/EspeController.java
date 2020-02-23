/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import Service.ServiceEspece;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javax.swing.JOptionPane;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*; 

/**
 * FXML Controller class
 *
 * @author moetez
 */
public class EspeController implements Initializable {

   String modeListe[] = {"a","b","c","d","e"};
  
  
        // Create a combo box 
                   
  
        // Create a tile pane 
    
  

    @FXML
    private TableView<Espece> tab_especes;
    @FXML
    private TableColumn<Espece, String> col_id;
    @FXML
    private TableColumn<Espece, String> col_nom;
    @FXML
    private TableColumn<Espece, String> col_desc;
    @FXML
    private TableColumn<Espece, String> col_saison;
    @FXML
    private TableColumn<Espece, String> col_type;
    
    @FXML
    private TableColumn<Espece, String> col_mode;
    @FXML
    private TableColumn<Espece, String> col_lieu;
    @FXML
    private JFXCheckBox t_chasse;
    @FXML
    private JFXCheckBox t_peche;
    @FXML
    private JFXTextField t_nom;
 

   
     ObservableList<String> data = FXCollections.observableArrayList("text1", "text2", "text3");
     @FXML
 private JFXComboBox<String> t_mode = new JFXComboBox<>(data);
        @FXML
    private JFXTextField t_lieu;
    @FXML
    private JFXTextArea t_desc;
    @FXML
    private JFXTextField t_saison;
    @FXML
    private JFXButton btn_Supprimer;
    @FXML
    private JFXButton btn_ajouterEs;
    private TextField t_nom_modi;
    private TextField t_type_modi;
    private TextField t_desc_modi;
    private TextField t_sainson_modi;
    
    @FXML
    private JFXButton btn_modifier;
    @FXML
    private JFXButton rechercher_espece;
    @FXML
    private JFXTextField nom_recherche;
   
    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
        t_mode.setItems(data);

        try {
            list = sl.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
                 col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));


                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));

                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_especes.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(EspeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

 

    @FXML
    private void modifier_espece(ActionEvent event) throws IOException,SQLException{
          FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("update.fxml"));
              Parent root = loader.load();
             UpdateController apc = loader.getController();
               
                btn_modifier.getScene().setRoot(root);
       
                 
    }

    @FXML
    private void ajout_espece(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                        .getResource("Espe.fxml"));
           String nom = t_nom.getText();
           String saison = t_saison.getText();
           String description = t_desc.getText();
           String lieu = t_lieu.getText();
           String type=null;
           if(t_chasse.isSelected())
           {
               type="chasse" ;
           }
           if(t_peche.isSelected())
           {
               type="peche";
           }
           
           String mode=    t_mode.getSelectionModel().getSelectedItem();

     

            
           
            ServiceEspece sp = new ServiceEspece();
            Espece p = new Espece(nom,type,mode,lieu, saison, description);
            sp.ajouter(p);
            
            List<Espece >list = sp.readAll();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));*/
               
                Parent root = loader.load();
                EspeController alc = loader.getController();
               col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_especes.setItems(obs);
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
             
                
                 
        
    }

    @FXML
    private void supprimer_espece(ActionEvent event) {
        
        
 ServiceEspece sp = new ServiceEspece();
           
           Espece e = tab_especes.getSelectionModel().getSelectedItem();
           sp.supprimer(e.getNom());
         //  this.rafraichir();

    }

    @FXML
    private void rechercher_espece(ActionEvent event) {
        ServiceEspece se = new ServiceEspece();  
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                        .getResource("Espe.fxml"));
        String nom=nom_recherche.getText();
   
   //        List<Espece >list = se.RECHERCHER();
     //       ObservableList<Espece> obs = FXCollections.observableArrayList(list);
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                  col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
               
      //          tab_especes.setItems(obs);
        
    }
    
}
