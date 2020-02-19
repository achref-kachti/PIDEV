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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moetez
 */
public class EspeController implements Initializable {

    @FXML
    private TextField t_no;
    @FXML
    private TextField t_saison;
    @FXML
    private TextField t_type;
    @FXML
    private TextField t_desc;
    @FXML
    private Button btn_Ajouter;
    @FXML
    private TextField t_nom_modi;
    @FXML
    private TextField t_type_modi;
    @FXML
    private TextField t_desc_modi;
    @FXML
    private TextField t_sainson_modi;
    @FXML
    private Button btn_modif;
    @FXML
    private TextField tf_nom_supp;
    @FXML
    private Button btn_supprimer;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
        try {
            list = sl.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_especes.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(EspeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void ajouter_espece(ActionEvent event) throws IOException,SQLException {
         
             
           FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("Espe.fxml"));
            String nom = t_no.getText();
            String saison = t_saison.getText();
            String description = t_desc.getText();
            String type = t_type.getText();
           
            
           
            ServiceEspece sp = new ServiceEspece();
            Espece p = new Espece(nom, saison, type, description);
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
               t_no.setText("");
                t_type.setText("");
                t_saison.setText("");
                t_desc.setText("");
                
                 
                
                
            
            
        
    }

    @FXML
    private void modifier_espece(ActionEvent event) throws IOException,SQLException{
          FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("Espe.fxml"));
        String nom = t_nom_modi.getText();
            String saison = t_sainson_modi.getText();
            String description = t_desc_modi.getText();
            String type = t_type_modi.getText();
        
        
        
         ServiceEspece sp = new ServiceEspece();
        sp.update(nom, saison, description, type);
        JOptionPane.showMessageDialog(null, "Espece modifié avec succes !");
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
               t_no.setText("");
                t_type.setText("");
                t_saison.setText("");
                t_desc.setText("");
          
    }

    @FXML
    private void supprimer_espece(ActionEvent event)throws IOException,SQLException {
        FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("Espe.fxml"));
         ServiceEspece sp = new ServiceEspece();
             String nom=tf_nom_supp.getText();
            sp.supprimer(nom);
            JOptionPane.showMessageDialog(null, "Espéce supprimé avec succes !");
                List<Espece >list = sp.readAll();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
           
      
               
               Parent root = loader.load();
                EspeController alc = loader.getController();
             col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                
             
               
                tab_especes.setItems(obs);
               
               
                   t_no.setText("");
                t_type.setText("");
                t_saison.setText("");
                t_desc.setText("");
                 
    }
    
}
