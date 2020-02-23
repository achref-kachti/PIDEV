/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Service.ServiceGuide;
import entites.Guide;
import static java.awt.PageAttributes.MediaType.C;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mail.MailApp;

/**
 * FXML Controller class
 *
 * @author nature
 */
public class Admin_1Controller implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_telephone;
    @FXML
    private TextField tf_mail;
    @FXML
    private TextField tf_password;
    @FXML
    private Button btn_ajouter_guide_admin;
    @FXML
    private RadioButton RB_chasse;
    @FXML
    private RadioButton RB_peche;
    @FXML
    private TextField tf_nom_modif;
    @FXML
    private TextField tf_prenom_modif;
    @FXML
    private TextField tf_telephone_modif;
    @FXML
    private TextField tf_mail_modif;
    @FXML
    private TextField tf_password_modif;
    @FXML
    private RadioButton RB_specialite_chasse;
    @FXML
    private RadioButton RB_specialite_peche;
    @FXML
    private Button btn_modifier;
    @FXML
    private TextField tf_nom_supprimer;
    @FXML
    private Button btn_supprimer_guide;
    @FXML
    private Button btn_trier_guide;
    @FXML
    private TableView<Guide> tab_afficher_guides;
    @FXML
    private TableColumn<Guide, String> col_id;
    @FXML
    private TableColumn<Guide, String> col_nom;
    @FXML
    private TableColumn<Guide, String> col_prenom;
    @FXML
    private TableColumn<Guide, String> col_telephone;
    @FXML
    private TableColumn<Guide, String> col_adresse;
    @FXML
    private TableColumn<Guide, String> col_password;
    @FXML
    private TableColumn<Guide, String> col_specialite;
    @FXML
    private Button btn_chercher_guide;
    @FXML
    private TextField tf_nom_chcercher;
    @FXML
    private Button btn_mail;
    
    

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
       
               col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_afficher_guides.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void AjouterGuide(ActionEvent event) throws IOException,SQLException {
         
             
           FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("admin_1.fxml"));
            String nomG = tf_nom.getText();
            String prenomG = tf_prenom.getText();
            String adresseG = tf_mail.getText();
            String telephoneG = tf_telephone.getText();
            int tlf =Integer.parseInt(telephoneG);
            
             String passwordG = tf_password.getText();
             String toogleGroupValue = RB_chasse.getText();
             String toogleGroupValue1 = RB_peche.getText();
             String specialite = toogleGroupValue+toogleGroupValue1;
            ServiceGuide sp = new ServiceGuide();
            Guide p = new Guide(nomG, prenomG, tlf,adresseG, passwordG,  specialite);
            sp.ajouter(p);
            
            List<Guide >list = sp.readAll();
            ObservableList<Guide> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
             col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_afficher_guides.setItems(obs);
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
               tf_nom.setText("");
                tf_prenom.setText("");
                tf_mail.setText("");
                tf_telephone.setText("");
                 tf_password.setText(""); 
                RB_peche.setText("");
                 RB_chasse.setText("");
                 
                
                
            
            
        
    }

    @FXML
    private void ModifierGuides(ActionEvent event)  throws IOException,SQLException {
           
        
        
        String nomG = tf_nom_modif.getText();
            String prenomG = tf_prenom_modif.getText();
            String adresseG = tf_mail_modif.getText();
            String telephoneG = tf_telephone_modif.getText();
            int tlf =Integer.parseInt(telephoneG);
             String passwordG = tf_password_modif.getText();
             String toogleGroupValue = RB_specialite_chasse.getText();
             String toogleGroupValue1 = RB_specialite_peche.getText();
             String specialite = toogleGroupValue+toogleGroupValue1;
        
        
        
         ServiceGuide sp = new ServiceGuide();
        sp.update(nomG,prenomG,tlf,adresseG,passwordG,specialite);
        JOptionPane.showMessageDialog(null, "Guide modifié avec succes !");
            List<Guide >list = sp.readAll();
            ObservableList<Guide> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
             col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_afficher_guides.setItems(obs);
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
               tf_nom.setText("");
                tf_prenom.setText("");
                tf_mail.setText("");
                tf_telephone.setText("");
                 tf_password.setText(""); 
                RB_peche.setText("");
                 RB_chasse.setText("");
                 
          
        
    }

    @FXML
    private void SupprimerGuides(ActionEvent event) throws IOException,SQLException {
         ServiceGuide sp = new ServiceGuide();
             String nom=tf_nom_supprimer.getText();
            sp.supprimer(nom);
            JOptionPane.showMessageDialog(null, "Guide supprimé avec succes !");
                List<Guide >list = sp.readAll();
            ObservableList<Guide> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root =  loader.load();
                AdminLogementController alc = loader.getController();*/
             col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_afficher_guides.setItems(obs);
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
               tf_nom.setText("");
                tf_prenom.setText("");
                tf_mail.setText("");
                tf_telephone.setText("");
                 tf_password.setText(""); 
                RB_peche.setText("");
                 RB_chasse.setText("");
                 
    }

    @FXML
    private void trierGuides(ActionEvent event)  throws IOException,SQLException{
         ServiceGuide sp = new ServiceGuide();
           List<Guide >list = sp.trier();
            ObservableList<Guide> obs = FXCollections.observableArrayList(list);
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
               
                tab_afficher_guides.setItems(obs);
        
        
    }

    @FXML
    private void chercherGuides(ActionEvent event) throws IOException,SQLException {
        ServiceGuide sp = new ServiceGuide();
        String nom=tf_nom_chcercher.getText();
           List<Guide >list = sp.RECHERCHER(nom);
            ObservableList<Guide> obs = FXCollections.observableArrayList(list);
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
               
                tab_afficher_guides.setItems(obs);
        
    }

    @FXML
    private void envoyer_mail(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("admin_1.fxml"));
        MailApp app = new MailApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       app.setSize(800,400);
      app.setVisible(true);
        
    }

  
    
}
