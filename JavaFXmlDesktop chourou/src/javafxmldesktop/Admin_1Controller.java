/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import mailaziz.MailApp;

/**
 * FXML Controller class
 *
 * @author nature
 */
public class Admin_1Controller implements Initializable {

    @FXML
    private TextField tf_nom;
    private Button go_to_button;
    @FXML
    private Button go_to_button1;
    @FXML
    private Button retour_acceuil;

    public void setTf_nom(TextField tf_nom) {
        this.tf_nom = tf_nom;
    }

    public void setTf_prenom(TextField tf_prenom) {
        this.tf_prenom = tf_prenom;
    }

    public void setTf_telephone(TextField tf_telephone) {
        this.tf_telephone = tf_telephone;
    }

    public void setTf_mail(TextField tf_mail) {
        this.tf_mail = tf_mail;
    }

    public void setTf_password(TextField tf_password) {
        this.tf_password = tf_password;
    }
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
    private RadioButton RB_chasse;
    private RadioButton RB_peche;
    private TextField tf_nom_supprimer;
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
    @FXML
    private CheckBox chassebox;
    @FXML
    private CheckBox pechebox;
    @FXML
    private Button btn_supprimer_guides;
    @FXML
    private Button btn_mod;
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
             String toogleGroupValue = "peche";
             String toogleGroupValue1 = "chasse";
             String specialite = null ;
             if(pechebox.isSelected()) {
           specialite = toogleGroupValue;
             
             }
             else if(chassebox.isSelected()) {specialite = toogleGroupValue1;}
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
              //  RB_peche.setText("");
                // RB_chasse.setText("");
                 
                
                
            
            
        
    }

  /*  @FXML
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
           /*  col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
                col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
                  col_specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));*/
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
               /* tab_afficher_guides.setItems(obs);*/
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
               /*tf_nom.setText("");
                tf_prenom.setText("");
                tf_mail.setText("");
                tf_telephone.setText("");
                 tf_password.setText(""); 
                RB_peche.setText("");
                 RB_chasse.setText("");
                 
          
        
    }*/
    /* @FXML
    private void update_guide(ActionEvent event)  throws IOException,SQLException {
           
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifier.fxml"));
            
                Parent root = loader.load();
                AffichePersonneController apc = loader.getController();
                
                btn_modifier_guides.getScene().setRoot(root);
          
        
    }*/
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

    @FXML
    private void supprimer_un_guide(ActionEvent event) {
        ServiceGuide sp = new ServiceGuide();
        if(! tab_afficher_guides.getSelectionModel().isEmpty())
        {     
           Guide r = tab_afficher_guides.getSelectionModel().getSelectedItem();
           sp.supprimer_id(r.getId());
       
          
                    
                    
        }
        else
        {
               Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("aucune selection");
                 alert.setHeaderText("aucune selection");
                alert.setContentText("svp selectionnez un element");
                 alert.showAndWait();
        }
    }


    @FXML
    private void handlechasseBox() {
        if(chassebox.isSelected()) {
           pechebox.setSelected(false);
             
             }
        
    }

    @FXML
    private void handlepecheBox() {
        if(pechebox.isSelected()) {
            chassebox.setSelected(false);
         
             
             }
        
    }

    @FXML
    private void mod_guide(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modif.fxml"));
        Parent root = loader.load();
               ModifController apc = loader.getController();
          Guide r = tab_afficher_guides.getSelectionModel().getSelectedItem();
          String nom=  r.getNom();
          String prenom=  r.getPrenom();
          String adresse=  r.getAdresse();
          String password=  r.getPassword();
          int telephone =r.getTelephone();
          String t=Integer.toString(telephone);
          
          String specialite =r.getSpecialite();
          if(specialite =="chasse") {    chassebox.isSelected(); }
          if(specialite =="peche") {    pechebox.isSelected();   }
          
          
         System.out.println(nom);
          
          
        
          tf_nom.setText(nom);
          tf_prenom.setText(prenom);
          tf_telephone.setText(t);
          tf_mail.setText(adresse);
          tf_password.setText(password);
           
          
          
          apc.setTf_nom_modif(tf_nom);
          apc.setTf_prenom_modif(tf_prenom);
          apc.setTf_adresse_modif(tf_mail);
          apc.setTf_password_modif(tf_password);
          apc.setTf_telephone_modif(tf_telephone);
                  btn_mod.getScene().setRoot(root);
              

      
          
           
               
              
            
                
                
            
    }

    @FXML
    private void go_to_res_guide_ofc(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("res_guide_ofc.fxml"));
            
                Parent root = loader.load();
              Res_guide_ofcController apc = loader.getController();
               
               go_to_button1.getScene().setRoot(root);
    }

    @FXML
    private void retour_acceuil(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_acceuil.fxml"));
           
             Parent root = loader.load();
           
             Admin_acceuilController apc = loader.getController();
                 retour_acceuil.getScene().setRoot(root);
    }
 
  
    
}
