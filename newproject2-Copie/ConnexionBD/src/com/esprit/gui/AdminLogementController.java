/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Logement;
import com.esprit.Service.ServiceLogement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminLogementController implements Initializable {

    @FXML
    private TextField tf_NomAjouter;
    @FXML
    private TextField tf_LieuAjouter;
    @FXML
    private TextField tf_DescAjouter;
    @FXML
    private TextField tf_NbrTTchambAjouter;
    @FXML
    private TextField tf_PrixAjouter;
    @FXML
    private TextField tf_ImgAjouter;
    @FXML
    private Button btn_AjouterLogAdmin;
    @FXML
    private TableView<Logement> tab_AfficherLogAdmin1;
    @FXML
    private TableColumn<Logement, String> col_id1;
    @FXML
    private TableColumn<Logement, String> col_Nom1;
    @FXML
    private TableColumn<Logement, String> col_Lieu1;
    @FXML
    private TableColumn<Logement, String> col_Desc1;
    @FXML
    private TableColumn<Logement, String> col_NbrTTchamb1;
    @FXML
    private TableColumn<Logement, String> col_Prix1;
    @FXML
    private TextField tf_RechercherLogAdmin;
    @FXML
    private Button btn_RechercherLogAdmin;
    @FXML
    private TableView<Logement> tab_AfficherLogAdmin2;
    @FXML
    private TableColumn<Logement, String> col_id2;
    @FXML
    private TableColumn<Logement, String> col_Nom2;
    @FXML
    private TableColumn<Logement, String> col_Lieu2;
    @FXML
    private TableColumn<Logement, String> col_Desc2;
    @FXML
    private TableColumn<Logement, String> col_NbrTTchamb2;
    @FXML
    private TableColumn<Logement, String> col_Prix2;
    @FXML
    private Button btn_TrierNbrTTAdmin;
    @FXML
    private Button btn_SupprimerLogAdmin;
    @FXML
    private TextField tf_idSupprimer;
    @FXML
    private TextField tf_idModifier;
    @FXML
    private TextField tf_NomModifier;
    @FXML
    private TextField tf_LieuModifier;
    @FXML
    private TextField tf_DescModifier;
    @FXML
    private TextField tf_NbrTTchambModifier;
    @FXML
    private TextField tf_PrixModifier;
    @FXML
    private TextField tf_ImgModifier;
    @FXML
    private Button btn_ModifierLogAdmin;
    @FXML
    private ImageView Img_AjouterLogAdmin;
    @FXML
    private ImageView Img_RechercherLogAdmin;
    @FXML
    private ImageView Img_TrierLogementAdminNbrChamb;
    @FXML
    private ImageView Img_SupprimerLogementAdmin;
    @FXML
    private ImageView Img_ModifierLogementAdmin;
    @FXML
    private ImageView Img_imageBackgLog;
    @FXML
    private ImageView Img_imageBackgLog2;
    @FXML
    private ImageView Img_imageJauneLog2;
    @FXML
    private ImageView Img_imageJauneLog21;
    @FXML
    private ImageView Img_imagBackgBackg;
    @FXML
    private Button btn_RetourAdmin1;
    @FXML
    private ImageView Img_imgRetour;
    
   

    
    //ObservableList<Logement> liste = FXCollections.observableArrayList();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceLogement sl = new ServiceLogement();
        List<Logement> list;
        try {
            //System.out.println("entrer");
            list = sl.readAll();
            //System.out.println(list);
        
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
            //System.out.println(obs.toString());
     
       
                col_id1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_Nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_NbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_Prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                tab_AfficherLogAdmin1.setItems(obs);
                
                
                col_id2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Desc2.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_NbrTTchamb2.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                tab_AfficherLogAdmin2.setItems(obs);
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void AjouterLogAdmin(ActionEvent event) throws SQLException, IOException {
        
         
            String nomL = tf_NomAjouter.getText();
            String LieuL = tf_LieuAjouter.getText();
            String DescriptionL = tf_DescAjouter.getText();
            String nbrTTchamb = tf_NbrTTchambAjouter.getText();
            int nbrTTchambL = Integer.parseInt(nbrTTchamb);
            String prixNuite = tf_PrixAjouter.getText();
            int prixNuiteL=Integer.parseInt(prixNuite);
            String imgL = tf_ImgAjouter.getText();
            ServiceLogement sl = new ServiceLogement();
            Logement L = new Logement(nomL, LieuL, DescriptionL, nbrTTchambL, prixNuiteL, imgL);
            sl.ajouter(L);
            List<Logement> list = sl.readAll();
            
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
                
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
              
                
                col_id1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_Nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_NbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_Prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                tab_AfficherLogAdmin1.setItems(obs);
                
                tf_NomAjouter.setText("");
                tf_LieuAjouter.setText("");
                tf_DescAjouter.setText("");
                tf_NbrTTchambAjouter.setText("");
                tf_PrixAjouter.setText("");
                tf_ImgAjouter.setText("");
                
                col_id2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Desc2.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_NbrTTchamb2.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                tab_AfficherLogAdmin2.setItems(obs);
                
    }
    
   

    

    @FXML
    private void RechercherLogAdmin(ActionEvent event) throws SQLException {
        
            String nomL = tf_RechercherLogAdmin.getText();
            String LieuL = tf_RechercherLogAdmin.getText();
            String DescriptionL = tf_RechercherLogAdmin.getText();
//            String nbrTTchamb = tf_RechercherLogAdmin.getText();
//            int nbrTTchambL = Integer.parseInt(nbrTTchamb);
//            String prixNuite = tf_RechercherLogAdmin.getText();
//            int prixNuiteL=Integer.parseInt(prixNuite);
            
            ServiceLogement sl = new ServiceLogement();
            List<Logement> list = sl.rechercherLieu(nomL, LieuL, DescriptionL);
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
            col_id1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_Nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_NbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
            col_Prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
            //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
            tab_AfficherLogAdmin1.setItems(obs);
            
    }

    

    @FXML
    private void TrierNbrTTAdmin(ActionEvent event) throws SQLException {
            ServiceLogement sl = new ServiceLogement();
            
            List<Logement> list = sl.trier();
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
                col_id2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Desc2.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_NbrTTchamb2.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                tab_AfficherLogAdmin2.setItems(obs);
    }

    
    @FXML
    private void SupprimerLogAdmin(ActionEvent event) throws SQLException, IOException {
            String id = tf_idSupprimer.getText();
            int idL = Integer.parseInt(id);
            
            ServiceLogement sl = new ServiceLogement();
            Logement L = new Logement(idL);
            sl.delete(L);
            List<Logement> list = sl.readAll();
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
            col_id2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Desc2.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_NbrTTchamb2.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
            col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
            tab_AfficherLogAdmin2.setItems(obs);
            
            col_id1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_Nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_NbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
            col_Prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
            tab_AfficherLogAdmin1.setItems(obs);
            
    }

    
    
    @FXML
    private void ModifierLogAdmin(ActionEvent event) throws SQLException, IOException {
            String id = tf_idModifier.getText();
            int idL = Integer.parseInt(id);
            String nomL = tf_NomModifier.getText();
            String LieuL = tf_LieuModifier.getText();
            String DescriptionL = tf_DescModifier.getText();
            String nbrTTchamb = tf_NbrTTchambModifier.getText();
            int nbrTTchambL = Integer.parseInt(nbrTTchamb);
            String prixNuite = tf_PrixModifier.getText();
            int prixNuiteL=Integer.parseInt(prixNuite);
            String imgL = tf_ImgModifier.getText();
            ServiceLogement sl = new ServiceLogement();
            Logement L = new Logement(idL, nomL, LieuL, DescriptionL, nbrTTchambL, prixNuiteL, imgL);
            sl.update(L);
            
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
                
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
            List<Logement> list = sl.readAll();
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
               
            col_id2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Desc2.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_NbrTTchamb2.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
            col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
            tab_AfficherLogAdmin2.setItems(obs);
            
            
            col_id1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_Nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Desc1.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_NbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
            col_Prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
            //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
            tab_AfficherLogAdmin1.setItems(obs);
                
                
                
    }

    @FXML
    private void RetourAdmin1(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Admin.fxml"));
        Parent root=fxml.load();
        btn_RetourAdmin1.getScene().setRoot(root);
        AdminController ac = fxml.getController();
        
    }

    

    
    

    
    
}
