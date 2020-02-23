/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Logement;
import com.esprit.Service.ServiceLogement;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UserLogementController implements Initializable {

    @FXML
    private TableView<Logement> tab_AfficherLogUser;
    @FXML
    private TableColumn<Logement, String> col_Nom;
    @FXML
    private TableColumn<Logement, String> col_Lieu;
    @FXML
    private TableColumn<Logement, String> col_Descr;
    @FXML
    private TableColumn<Logement, String> col_Prix;
    @FXML
    private TextField tf_RechecherLogement;
    @FXML
    private Button btn_RechercherLogUser;
    @FXML
    private Button btn_TrierLieuUser;
    @FXML
    private ImageView Img_imggBackgUser;

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
     
       
                col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Descr.setCellValueFactory(new PropertyValueFactory<>("description"));
                col_Prix.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                tab_AfficherLogUser.setItems(obs);
                
                
                
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    

    @FXML
    private void RechercherLogUser(ActionEvent event) throws SQLException {
        
            String nomL = tf_RechecherLogement.getText();
            String LieuL = tf_RechecherLogement.getText();
            String DescriptionL = tf_RechecherLogement.getText();
            
            ServiceLogement sl = new ServiceLogement();
            List<Logement> list = sl.rechercherLieu(nomL, LieuL, DescriptionL);
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
            col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            col_Descr.setCellValueFactory(new PropertyValueFactory<>("description"));
            //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
            tab_AfficherLogUser.setItems(obs);
        
    }

    @FXML
    private void TrierLieuUser(ActionEvent event) throws SQLException {
        
            ServiceLogement sl = new ServiceLogement();
            
            List<Logement> list = sl.trierLieu();
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
                col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Descr.setCellValueFactory(new PropertyValueFactory<>("description"));
                
                tab_AfficherLogUser.setItems(obs);
        
    }
    
}
