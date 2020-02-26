/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXTextField;


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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;



import java.io.FileNotFoundException;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AdminChauffeursController implements Initializable {

    @FXML
    private TableView<chauffeurs> tab_AfficherChauffeursAd1;
    @FXML
    private TableColumn<chauffeurs,String> col_cin1;
    @FXML
    private TableColumn<chauffeurs,String> col_nom1;
    @FXML
    private TableColumn<chauffeurs,String> col_prenom1;
    @FXML
    private Button btn_ajoutChauffeur;
    @FXML
    private TextField tf_cinAjouter;
    @FXML
    private TextField tf_nomAjouter;
    @FXML
    private TextField tf_prenomAjouter;
    @FXML
    private TextField tf_telAjouter;
    @FXML
    private TableColumn<chauffeurs,String> col_telephone1;
    private TextField tf_cinSupprimer;
    chauffeurService sl = new chauffeurService();  
    @FXML
    private Button btn_supprimerAdminSlct;
    @FXML
    private ImageView img_fondChauffeur;
    @FXML
    private ImageView img_fondChauffeur1;
    @FXML
    private TextField tf_cinModif;
    @FXML
    private TextField tf_nomModif;
    @FXML
    private TextField tf_prenomModif;
    @FXML
    private TextField tf_telModif;
    @FXML
    private ImageView img_fondChauffeur11;
    @FXML
    private Button btn_modifChauffeurslct;
    @FXML
    private TableView<chauffeurs> tab_AfficherChauffeursAd2;
    @FXML
    private TableColumn<chauffeurs,String> col_cin2;
    @FXML
    private TableColumn<chauffeurs,String> col_nom2;
    @FXML
    private TableColumn<chauffeurs,String> col_prenom2;
    @FXML
    private TableColumn<chauffeurs,String> col_telephone2;
    @FXML
    private TableView<chauffeurs> tab_AfficherChauffeursAd3;
    @FXML
    private TableColumn<chauffeurs,String> col_cin3;
    @FXML
    private TableColumn<chauffeurs,String> col_nom3;
    @FXML
    private TableColumn<chauffeurs,String> col_prenom3;
    @FXML
    private TableColumn<chauffeurs,String> col_telephone3;
    @FXML
    private Button btn_TriChauffeursNom;
    @FXML
    private TextField tf_rechercheChauffeur;
    @FXML
    private Button btn_rechercheChauffeur;
    @FXML
    private Button btn_pdfChauff;
    @FXML
    private Button retour_acceuil;
    

    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
       afficher2();
afficher3();
      
                tf_cinModif.setDisable(true);
           
              
    }    

    public void afficher()
    {
                       List<chauffeurs> list ; 
        try {
            list = sl.readAll(); // TODO
            
        
        ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_cin1.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone1.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
      tab_AfficherChauffeursAd1.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public void afficher2()
    {
                       List<chauffeurs> list ; 
        try {
            list = sl.readAll(); // TODO
        
        ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_cin2.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom2.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom2.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone2.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
      tab_AfficherChauffeursAd2.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     public void afficher3()
    {
                       List<chauffeurs> list ; 
        try {
            list = sl.readAll(); // TODO
        
        ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_cin3.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom3.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom3.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone3.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
      tab_AfficherChauffeursAd3.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
        

    @FXML
    private void ajoutChauffeur(ActionEvent event)  throws IOException,SQLException {
         
             
           FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("AdminChauffeurs.fxml")); 
            String cina = tf_cinAjouter.getText();
                        int cinc =Integer.parseInt(cina);

                        String nomc= tf_nomAjouter.getText();

            String prenomc = tf_prenomAjouter.getText();
            
            String telephone = tf_telAjouter.getText();
            int telephonec =Integer.parseInt(telephone);
            
            if ((tf_cinAjouter.getText().length() == 8) && (tf_telAjouter.getText().length() == 8)) {
// rempli


            
             
            chauffeurService sp = new chauffeurService();
            chauffeurs p = new chauffeurs(cinc,nomc, prenomc, telephonec);
            sp.ajouterchauffeur(p);
            
            List<chauffeurs>list = sp.readAll();
            ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
             col_cin1.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone1.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
        
      tab_AfficherChauffeursAd1.setItems(obs);  
      
              JOptionPane.showMessageDialog(null, "Chauffeur ajouté avec succes !");

               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
                                tf_cinAjouter.setText(""); 

               tf_nomAjouter.setText("");
                tf_prenomAjouter.setText("");
                tf_telAjouter.setText(""); 
            }
            else  {
                              JOptionPane.showMessageDialog(null, "Veuillez remplir les champs correctement !");

                System.out.println("Veuillez remplir les champs correctement");
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("Popup.fxml")); 
       try {
        Parent root=fxml.load();
       btn_ajoutChauffeur.getScene().setRoot(root);
       } catch (IOException ex){
           System.out.println(ex.getMessage());
       }
      
            }
            afficher2();
            afficher3();

            
    }

    private void supprimerChauffeur(ActionEvent event)throws SQLException, IOException {
            //String id = tf_cinSupprimer.getText();
            
             int id= tab_AfficherChauffeursAd1.getSelectionModel().getSelectedIndex();
            
            chauffeurService sl = new chauffeurService();
            chauffeurs L = new chauffeurs(id);
            sl.supprimerchauffeurs(L);
             tab_AfficherChauffeursAd1.getItems().clear();
                     JOptionPane.showMessageDialog(null, "Chauffeur supprimé avec succes !");
                                    tf_cinSupprimer.setText("");


            afficher();
            afficher2();
           afficher3();

          
        
      
     
     
                
                
            //    btn_ajoutChauffeur.getScene().setRoot(root);
    }

    @FXML
    private void deleteonSelect(ActionEvent event) {
         int id= tab_AfficherChauffeursAd3.getSelectionModel().getSelectedIndex();
             chauffeurs p1=tab_AfficherChauffeursAd3.getSelectionModel().getSelectedItem();
        if (!p1.equals(null)){ 
        sl.supprimerchauffeurs(p1);          
                        tab_AfficherChauffeursAd3.getItems().clear();
                                JOptionPane.showMessageDialog(null, "Chauffeur supprimé avec succes !");

            afficher();
            afficher2();
            afficher3();
    }

    }

    private void modifChauffeur(ActionEvent event)  throws IOException,SQLException {
           
        
        
        String cin = tf_cinModif.getText();
                    int cinc =Integer.parseInt(cin);

            String nomc = tf_nomModif.getText();
            String prenomc = tf_prenomModif.getText();
            String telephone = tf_telModif.getText();
            int telc =Integer.parseInt(telephone);
            
            chauffeurs c = new chauffeurs (cinc,nomc,prenomc,telc);
             
        
        
        
         chauffeurService sp = new chauffeurService();
        sp.modifierchauffeurs(cinc,c);
        JOptionPane.showMessageDialog(null, "Chauffeur modifié avec succes !");
            List<chauffeurs >list = sp.readAll();
            ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
            col_cin1.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone1.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
               
                tab_AfficherChauffeursAd1.setItems(obs);  
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
                                tf_cinModif.setText(""); 

               tf_nomModif.setText("");
                tf_prenomModif.setText("");
                tf_telModif.setText(""); 
                
                 
          
        
    }

    @FXML
    private void modifonSelect(ActionEvent event) {
            int id= tab_AfficherChauffeursAd2.getSelectionModel().getSelectedIndex();
             chauffeurs p1=tab_AfficherChauffeursAd2.getSelectionModel().getSelectedItem();
         
             
             
            
              String cin = tf_cinModif.getText();
                    int cinc =Integer.parseInt(cin);

            String nomc = tf_nomModif.getText();
            String prenomc = tf_prenomModif.getText();
            String telephone = tf_telModif.getText();
            int telc =Integer.parseInt(telephone);
            
            chauffeurs c = new chauffeurs (cinc,nomc,prenomc,telc);
             
             
       // if (!p1.equals(null)){ 
        sl.modifierchauffeurs(cinc,c);          
                        tab_AfficherChauffeursAd2.getItems().clear();
                                JOptionPane.showMessageDialog(null, "Chauffeur modifié avec succes !");

            afficher2();
            afficher();
    //}
        
        
    }

    private void selectionnerChauffeur(ActionEvent event) {
        chauffeurs p1=tab_AfficherChauffeursAd1.getSelectionModel().getSelectedItem();
tf_nomAjouter.setText(String.valueOf(p1.getNomc()));
tf_prenomAjouter.setText(String.valueOf(p1.getPrenomc()));
tf_telAjouter.setText(String.valueOf(p1.getNum_telc()));
tf_cinAjouter.setText(String.valueOf(p1.getCinc()));

    }

    @FXML
    private void selectionnerChauffeur1(MouseEvent event) {
        
        chauffeurs p1=tab_AfficherChauffeursAd1.getSelectionModel().getSelectedItem();
tf_nomAjouter.setText(String.valueOf(p1.getNomc()));
tf_prenomAjouter.setText(String.valueOf(p1.getPrenomc()));
tf_telAjouter.setText(String.valueOf(p1.getNum_telc()));
tf_cinAjouter.setText(String.valueOf(p1.getCinc()));
    }
     
    
     @FXML
    private void selectionnerChauffeur2(MouseEvent event) {
        
        chauffeurs p1=tab_AfficherChauffeursAd2.getSelectionModel().getSelectedItem();
tf_nomModif.setText(String.valueOf(p1.getNomc()));
tf_prenomModif.setText(String.valueOf(p1.getPrenomc()));
tf_telModif.setText(String.valueOf(p1.getNum_telc()));
tf_cinModif.setText(String.valueOf(p1.getCinc()));
    }
    
    
    
    @FXML
      private void selectionnerChauffeur3(MouseEvent event) {
        
        chauffeurs p1=tab_AfficherChauffeursAd3.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void triChauffeursNom(ActionEvent event) {
         List<chauffeurs> list ; 
        try {
            list = sl.readAllNom(); // TODO
        
        ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_cin1.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone1.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
      tab_AfficherChauffeursAd1.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

 

    @FXML
    private void rechercheChauffeur(ActionEvent event) {
        List<chauffeurs> list ; 
      String  rech=tf_rechercheChauffeur.getText();

        try {
            list = sl.rechercheAvancee(rech); // TODO
        
        ObservableList<chauffeurs> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_cin1.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        col_nom1.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        col_prenom1.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        col_telephone1.setCellValueFactory(new PropertyValueFactory<>("num_telc"));
      tab_AfficherChauffeursAd1.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void pdfChauff(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {
chauffeurService s1=new chauffeurService();
        s1.pdf();
                      JOptionPane.showMessageDialog(null, "Fichier PDF crée avec succés !");

    }

    @FXML
    private void retour_acceuil(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_acceuil.fxml"));
           
             Parent root = loader.load();
           
             Admin_acceuilController apc = loader.getController();
                 retour_acceuil.getScene().setRoot(root);
    }
    }
        
   
             

    
    
