/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

//import com.esprit.Entite.Logement;
import com.esprit.Entite.ResLogement;
//import com.esprit.Service.ServiceLogement;
import com.esprit.Service.ServiceResLogement;
import com.itextpdf.text.DocumentException;

import static com.itextpdf.text.pdf.PdfName.C;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminResLogementController implements Initializable {

    @FXML
    private TableView<ResLogement> tab_AfficherReservationLogAdmin1;
    @FXML
    private TableColumn<ResLogement, String> col_idReservationLog1;
    @FXML
    private TableColumn<ResLogement, String> col_idLog1;
    @FXML
    private TableColumn<ResLogement, String> col_DateA1;
    @FXML
    private TableColumn<ResLogement, String> col_DateD1;
    @FXML
    private TableColumn<ResLogement, String> col_NbrChamb1;
    @FXML
    private TextField tf_RechecherResLogementDateA;
    @FXML
    private Button btn_RechercherReservationLogDateA;
    @FXML
    private Button btn_TrierReservationLogDateA;
    @FXML
    private TableView<ResLogement> tab_AfficherReservationLogAdmin2;
    @FXML
    private TableColumn<ResLogement, String> col_idReservationLog2;
    @FXML
    private TableColumn<ResLogement, String> col_idLog2;
    @FXML
    private TableColumn<ResLogement, String> col_DateA2;
    @FXML
    private TableColumn<ResLogement, String> col_DateD2;
    @FXML
    private TableColumn<ResLogement, String> col_NbrChamb2;
    @FXML
    private TableColumn<ResLogement, String> col_Nom2;
    @FXML
    private TableColumn<ResLogement, String> col_Lieu2;
    @FXML
    private TableColumn<ResLogement, String> col_Prix2;
    @FXML
    private Button btn_PdfReservationLog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceResLogement sr = new ServiceResLogement();
        List<ResLogement> list;
        
        //ServiceResLogement sr2 = new ServiceResLogement();
        List<ResLogement> list2;
        
        try {
            list = sr.readAllResLog();
            //list2 = sr.readAllAllResLog(); 
            
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list);
            //ObservableList<ResLogement> obs2 = FXCollections.observableArrayList(list2);
     
       
                col_idReservationLog1.setCellValueFactory(new PropertyValueFactory<>("idReservationLog"));
                col_idLog1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_DateA1.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_DateD1.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_NbrChamb1.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                
                tab_AfficherReservationLogAdmin1.setItems(obs);
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminResLogementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       try {
            list2 = sr.readAllAllResLog(); 
            
            ObservableList<ResLogement> obs2 = FXCollections.observableArrayList(list2);
                
                
                col_idReservationLog2.setCellValueFactory(new PropertyValueFactory<>("idReservationLog"));
                col_idLog2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_DateA2.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_DateD2.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_NbrChamb2.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                tab_AfficherReservationLogAdmin2.setItems(obs2);
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminResLogementController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    


    @FXML
    private void RechercherReservationLogDateA(ActionEvent event) throws SQLException {
        
            String DateAL = tf_RechecherResLogementDateA.getText();
            
            ServiceResLogement sl = new ServiceResLogement();
            List<ResLogement> list = sl.rechercherResLogDateA(DateAL);
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list);
            
            col_idReservationLog1.setCellValueFactory(new PropertyValueFactory<>("idReservationLog"));
            col_idLog1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
            col_DateA1.setCellValueFactory(new PropertyValueFactory<>("dateA"));
            col_DateD1.setCellValueFactory(new PropertyValueFactory<>("dateD"));
            col_NbrChamb1.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                
            tab_AfficherReservationLogAdmin1.setItems(obs);
        
    }

    @FXML
    private void TrierReservationLogDateA(ActionEvent event) throws SQLException {
        
            ServiceResLogement sl = new ServiceResLogement();
            
            List<ResLogement> list = sl.trierResLog();
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list);
            
                col_idReservationLog1.setCellValueFactory(new PropertyValueFactory<>("idReservationLog"));
                col_idLog1.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_DateA1.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_DateD1.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_NbrChamb1.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                
                tab_AfficherReservationLogAdmin1.setItems(obs);
        
    }

    @FXML
    private void PdfReservationLog(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {
        
            ServiceResLogement sl = new ServiceResLogement();
            
            List<ResLogement> list = sl.PdfResLog();
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list);
            
            /*    col_idReservationLog2.setCellValueFactory(new PropertyValueFactory<>("idReservationLog"));
                col_idLog2.setCellValueFactory(new PropertyValueFactory<>("idLog"));
                col_DateA2.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_DateD2.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_NbrChamb2.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                col_Nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_Lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_Prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                tab_AfficherReservationLogAdmin1.setItems(obs);*/
        
    }

    
}
