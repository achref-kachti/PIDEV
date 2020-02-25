/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.ChauffeurVehicule;
import entites.chauffeurs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entites.vehicules;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.chauffeurService;
import service.vehiculeService;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */






public class AdminVehiculeController implements Initializable {

    @FXML
    private TextField tf_matriculeAjouter;
    @FXML
    private TextField tf_date_departAjouter;
    @FXML
    private TextField tf_capaciteAjouter;
    @FXML
    private TextField tf_id_chauffeurAjouter;
    @FXML
    private TableView<vehicules> tab_AfficherVehiculesAd1;
    @FXML
    private TableColumn<vehicules,String> col_matricule1;
    @FXML
    private TableColumn<vehicules,String> col_date_depart1;
    @FXML
    private TableColumn<vehicules,String> col_capacite1;
    @FXML
    private TableColumn<vehicules,String> col_id_chauffeur1;
    @FXML
    private Button btn_ajoutVehicule;
    @FXML
    private Button btn_triVehicule;
    @FXML
    private TextField tf_rechercheVehicule;
    @FXML
    private Button btn_rechercheVehicule;
    
        vehiculeService sl = new vehiculeService();  
    @FXML
    private TableView<ChauffeurVehicule> tbl_ChauffeurVehicule;
    @FXML
    private TableColumn<ChauffeurVehicule,String> col_cinx;
    @FXML
    private TableColumn<ChauffeurVehicule,String> col_nomx;
    @FXML
    private TableColumn<ChauffeurVehicule,String> col_matriculex;
    @FXML
    private TableColumn<ChauffeurVehicule, String> col_capacitex;
    @FXML
    private TextField tf_search;
    @FXML
    private TextField tf_matriculeModifier;
    @FXML
    private TextField tf_date_departModifier;
    @FXML
    private TextField tf_capaciteModifier;
    @FXML
    private TextField tf_id_chauffeurModifier;
    @FXML
    private TableView<vehicules> tab_AfficherVehiculesAd2;
    @FXML
    private Button btn_selectVehiculeMod;
    @FXML
    private Button btn_Jointure2;
    @FXML
    private TableColumn<vehicules,String> col_matricule2;
    @FXML
    private TableColumn<vehicules,String> col_date_depart2;
    @FXML
    private TableColumn<vehicules,String> col_capacite2;
    @FXML
    private TableColumn<vehicules,String> col_id_chauffeur2;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Jointure();
        afficher();
        // TODO
    }    
    
    
        public void afficher()
    {
                       List<vehicules> list ; 
        try {
            list = sl.readAll(); // TODO
            
        
        ObservableList<vehicules> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        col_date_depart1.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_capacite1.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        col_id_chauffeur1.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
      tab_AfficherVehiculesAd1.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
    

    @FXML
    private void ajoutVehicule(ActionEvent event)  throws IOException,SQLException {
         
             
           FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("AdminVehicule.fxml")); 
            String m = tf_matriculeAjouter.getText();
                        int matricule =Integer.parseInt(m);

                        String date_depart= tf_date_departAjouter.getText();

            String idc = tf_id_chauffeurAjouter.getText();
            int id_chauffeur = Integer.parseInt(idc);
            
            String cap = tf_capaciteAjouter.getText();
                        int capacite =Integer.parseInt(idc);

            
         //   if ((tf_matriculeAjouter.getText().length() == 6) &&(tf_id_chauffeurAjouter.getText().length() == 8)) {
// rempli


            
             
            vehiculeService sp = new vehiculeService();
           vehicules p = new vehicules(matricule,date_depart,capacite,id_chauffeur);
            sp.ajoutervehicules(p);
            
            List<vehicules>list = sp.readAll();
            ObservableList<vehicules> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
             col_matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        col_date_depart1.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_capacite1.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        col_id_chauffeur1.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
        
      tab_AfficherVehiculesAd1.setItems(obs);  
      
              JOptionPane.showMessageDialog(null, "Vehicule ajouté avec succes !");

               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
                                tf_matriculeAjouter.setText(""); 

               tf_date_departAjouter.setText("");
                tf_capaciteAjouter.setText("");
                tf_id_chauffeurAjouter.setText(""); 
          //  }
          //  else  {
                           

                //System.out.println("Veuillez remplir les champs correctement");
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("Popup.fxml")); 
       try {
        Parent root=fxml.load();
       btn_ajoutVehicule.getScene().setRoot(root);
       } catch (IOException ex){
           System.out.println(ex.getMessage());
       }
      
         //   }
            afficher();
                  this.Jointure();


            
    }{
    }

    @FXML
    private void triVehicule(ActionEvent event) {
         List<vehicules> list ; 
        try {
            list = sl.readAllCapacite(); // TODO
        
        ObservableList<vehicules> obs = FXCollections.observableArrayList(list); 
           
          
        
        col_matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        col_date_depart1.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_capacite1.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        col_id_chauffeur1.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
      tab_AfficherVehiculesAd1.setItems(obs);   
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }

    @FXML
    private void rechercheVehicule(ActionEvent event) {
        
          List<vehicules> list ; 
      String  rech=tf_rechercheVehicule.getText();

        try {
            list = sl.rechercheAvanceeV(rech); // TODO
        
        ObservableList<vehicules> obs = FXCollections.observableArrayList(list); 
           
          
        
            col_matricule1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        col_date_depart1.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        col_capacite1.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        col_id_chauffeur1.setCellValueFactory(new PropertyValueFactory<>("id_chauffeur"));
      tab_AfficherVehiculesAd1.setItems(obs);    
     } catch (SQLException ex) {
            Logger.getLogger(AdminChauffeursController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        
        
        
    
    
    
    
    
    @FXML
 public void Jointure(){
        vehiculeService s= new vehiculeService();
            List <ChauffeurVehicule> list;
      try{ list= s.afficherJointure();
            ObservableList<ChauffeurVehicule> obsr =FXCollections.observableArrayList(list);
            col_cinx.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("cinc"));
            col_nomx.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("nomc"));
                        col_matriculex.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("matricule"));
            col_capacitex.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("capacite"));

            tbl_ChauffeurVehicule.setItems(obsr);
      }catch(SQLException ex ) {
      Logger.getLogger(AdminVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
      }
     }   
 
 
 
    @FXML
  public void Jointure2(){
        vehiculeService s= new vehiculeService();
            List <ChauffeurVehicule> list;
            String champ =tf_search.getText();
                        int idc =Integer.parseInt(champ);

      try{ list= s.afficherJointure2(idc);
            ObservableList<ChauffeurVehicule> obsr =FXCollections.observableArrayList(list);
            col_cinx.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("cinc"));
            col_nomx.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("nomc"));
                        col_matriculex.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("matricule"));
            col_capacitex.setCellValueFactory(new PropertyValueFactory<ChauffeurVehicule,String>("capacite"));

            tbl_ChauffeurVehicule.setItems(obsr);
      }catch(SQLException ex ) {
      Logger.getLogger(AdminVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
      }
     }   

    @FXML
    private void selectionnerVehicule(MouseEvent event) {
         vehicules p1=tab_AfficherVehiculesAd1.getSelectionModel().getSelectedItem();
tf_matriculeAjouter.setText(String.valueOf(p1.getMatricule()));
tf_date_departAjouter.setText(String.valueOf(p1.getDate_depart()));
tf_capaciteAjouter.setText(String.valueOf(p1.getCapacite()));
tf_id_chauffeurAjouter.setText(String.valueOf(p1.getId_chauffeur()));
    }

    @FXML
    private void selectionnerVehicule2(MouseEvent event) {
    }

    @FXML
    private void selectVehiculeMod(ActionEvent event) {
    }
}
