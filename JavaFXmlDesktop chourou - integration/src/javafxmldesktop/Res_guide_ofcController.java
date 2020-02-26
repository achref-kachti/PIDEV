/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;

import static java.awt.PageAttributes.MediaType.E;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author nature
 */
public class Res_guide_ofcController implements Initializable {
  
   
    @FXML
    private TableView<ReservationGuideEvent> tab_res_guide;
    @FXML
    private TableColumn<ReservationGuideEvent, String> col_nom_guide;
    @FXML
    private TableColumn<ReservationGuideEvent, String> col_titre_event;
       
        
            
    @FXML
    private TableColumn<ReservationGuideEvent, String> col_desc_event;
      ObservableList<String> events = FXCollections.observableArrayList();
    
    ObservableList<String> guides = FXCollections.observableArrayList();
    @FXML
    private Button btn_modif_res_gui;
    @FXML
    private Button btn_annuler_res1;
    @FXML
    private JFXButton btn_affecter;
    @FXML
    private TextField tf_event;
    @FXML
    private TextField tf_guide;
    private TableColumn<Evenement, String> col_liste_events;
    private TableColumn<Guide, String> col_liste_guides;
    @FXML
    private TableView<Guide> tab_gu;
    @FXML
    private TableColumn<Guide, String> col_noun;
    @FXML
    private TableColumn<Guide, String> col_spec;
    @FXML
    private TableView<ReservationGuideEvent> tab_ev;
    @FXML
    private TableColumn<ReservationGuideEvent, String> col_titre;
    
    @FXML
    private TableColumn<ReservationGuideEvent, String> col_titre1;
    @FXML
    private Button btn_return_acceuil;

    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceGuide sa =new ServiceGuide();
        
      
 
      
          ServiceAffectationGuide sl = new ServiceAffectationGuide();
          ServiceAffectationGuide s2 = new ServiceAffectationGuide();
        List<ReservationGuideEvent> liste;
       List<ReservationGuideEvent> liste1;
           List<Guide> listeguide;
           //List<Evenement> liste_event;
    
        try {
            liste = sl.recuperer_titre_desc_nomguide();
           liste1 = s2.recuperer_titre1();
            listeguide =sa.read();
            
                    ObservableList<Guide> gu = FXCollections.observableArrayList(listeguide); 
            ObservableList<ReservationGuideEvent> obs = FXCollections.observableArrayList(liste); 
                ObservableList<ReservationGuideEvent> obsa = FXCollections.observableArrayList(liste1);
              col_noun.setCellValueFactory(new PropertyValueFactory<>("nom"));
              col_spec.setCellValueFactory(new PropertyValueFactory<>("specialite"));
              tab_gu.setItems(gu);
              col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
              
              tab_ev.setItems(obsa);
               col_nom_guide.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_titre_event.setCellValueFactory(new PropertyValueFactory<>("titre"));
              col_desc_event.setCellValueFactory(new PropertyValueFactory<>("description"));
            
               
                tab_res_guide.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void delete_res_event(ActionEvent event) throws SQLException {
          ServiceAffectationGuide sp = new  ServiceAffectationGuide();
       
      String s;
      int id_res=0;
      int id_guide=0,id_event=0;
      
       
            s = sp.recuperer_titre();
            id_res=sp.id_res();
            id_guide=sp.id_guide();
            id_event=sp.id_event();
            System.out.println(s);
              System.out.println(id_res);
               System.out.println(id_guide);
                System.out.println(id_event);
       sp.supprimer(id_res, id_guide,id_event);
               JOptionPane.showMessageDialog(null, "Annulation  faite avec succes");

           
          
                    
                    
      
        
    }

    @FXML
    private void mod_res_event(ActionEvent event) {
    }

    @FXML
    private void affecter_guide_event(ActionEvent event) throws SQLException {
        ServiceAffectationGuide sp = new ServiceAffectationGuide();
        ServiceGuide sp1 = new ServiceGuide();
         FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("res_guide_ofc.fxml"));
            String titre = tf_event.getText();
            String nom = tf_guide.getText();
            
           int id_event= sp.recuperer_t(titre);
            int id_guide= sp1.recuperer_i(nom);
           
            ReservationGuideEvent p = new ReservationGuideEvent(id_guide, id_event);
            
            sp.ajout_reservation(p);
            
        
        
        
        
    }

    @FXML
    private void return_to_admin_1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
            
                Parent root = loader.load();
              Admin_1Controller apc = loader.getController();
               
               btn_return_acceuil.getScene().setRoot(root);
    }

    
}
