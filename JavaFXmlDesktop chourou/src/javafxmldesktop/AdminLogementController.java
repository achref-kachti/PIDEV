/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;


import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminLogementController implements Initializable {

    @FXML
    private JFXTabPane tabpane;
    @FXML
    private Tab tab_gerer;
    @FXML
    private AnchorPane interface_gerer;
    @FXML
    private Label warn_label;
    @FXML
    private ImageView image_viewer;
    @FXML
    private JFXButton btn_ajouterLog;
    @FXML
    private JFXListView<String> liste_nom;
    @FXML
    private JFXTextArea ta_description;
    @FXML
    private JFXTextField tf_lieu;
    @FXML
    private JFXTextField tf_nbTTchamb;
    @FXML
    private JFXTextField tf_prix;
    @FXML
    private JFXButton btn_modifierLog;
    @FXML
    private JFXButton btn_supprimerLog;
    @FXML
    private JFXTextField tf_nom;
    @FXML
    private JFXTextField tf_image;
    @FXML
    private Tab afficher_evenement;
    @FXML
    private AnchorPane interface_afficher;
    @FXML
    private TableView<Logement> tableau;
    @FXML
    private TableColumn<Logement, String> col_nom1;
    @FXML
    private TableColumn<Logement, String> col_lieu1;
    @FXML
    private TableColumn<Logement, String> col_nbrTTchamb1;
    @FXML
    private TableColumn<Logement, String> col_prix1;
    @FXML
    private JFXTextField tf_rechercheNom;
    @FXML
    private JFXTextField tf_rechercheLieu;
    @FXML
    private JFXButton btn_rechercherLog;
    @FXML
    private JFXButton btn_trierLog;
    @FXML
    private TableView<ResLogement> table_reservation;
    @FXML
    private TableColumn col_dateA1;
    @FXML
    private TableColumn col_dateD2;
    @FXML
    private TableColumn col_nbrChamb2;
    @FXML
    private TableColumn col_nom2;
    @FXML
    private TableColumn col_lieu2;
    @FXML
    private TableColumn col_prix2;
    @FXML
    private JFXDatePicker tf_dateA;
    @FXML
    private JFXButton btn_rechercherResDateA;
    @FXML
    private JFXButton btn_PDF;
    
    //ObservableList<Logement> oblist = FXCollections.observableArrayList();
    
                ServiceLogement sl = new ServiceLogement();
                ServiceResLogement sr = new ServiceResLogement();
                List<Logement> list;
                List<ResLogement> list_res;
    private Label prix_details;
    @FXML
    private JFXButton retour_acceuil;

    /**
     * Initializes the controller class.
     */
    
                
                
   public void rafraichir()
   {
        tf_nom.clear();
        tf_image.clear();
        ta_description.clear();
        tf_nbTTchamb.clear();
        tf_prix.clear();
        tf_lieu.clear();
        
        warn_label.setText("");
        
        image_viewer.setImage(null);
        btn_ajouterLog.setDisable(false);
        
        
        
        try {
             list = sl.readAll();;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            list_res = sr.readAllAllResLog();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

       
        try {
            liste_nom.getItems().clear();
            
            // liste_ref.getItems().addAll(evenementc.rechercher("", "", "", "", "", "", true,"").stream().map(e->e.getId()).collect(Collectors.toList()));
            liste_nom.getItems().addAll(sl.readAll().stream().map(e->e.getNom()).collect(Collectors.toList()));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
                col_nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_nbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                ObservableList<Logement> obs=FXCollections.observableArrayList(list);
                tableau.getItems().clear();
                tableau.setItems(obs);

       
       
               
                col_dateA1.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_dateD2.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_nbrChamb2.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                col_nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                ObservableList<ResLogement> obsres = FXCollections.observableArrayList(list_res);
                table_reservation.getItems().clear();
                table_reservation.setItems(obsres);
    

       
    }
                
                
                
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceLogement sl = new ServiceLogement();
        List<Logement> list;
        
        ServiceResLogement sr = new ServiceResLogement();
        List<ResLogement> list_res;
        
        //initTable();
        
        try {
            liste_nom.getItems().clear();
            liste_nom.getItems().addAll(sl.readAll().stream().map(e->e.getNom()).collect(Collectors.toList()));
            
            list = sl.readAll();
            
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
                col_nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_nbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
                tableau.getItems().clear();
                tableau.setItems(obs);
                
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            list_res = sr.readAllAllResLog();
           // System.out.println("test=");
           // System.out.println(list_res);
        
            ObservableList<ResLogement> obsres = FXCollections.observableArrayList(list_res);
            
                col_dateA1.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_dateD2.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_nbrChamb2.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                col_nom2.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu2.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_prix2.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                
               
                table_reservation.setItems(obsres);

                
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    
    
    @FXML
    private void ajouterLog(ActionEvent event) throws SQLException {
        
            ServiceLogement sl = new ServiceLogement();
            
        
            String nomL = tf_nom.getText();
            String lieuL = tf_lieu.getText();
            String descriptionL = ta_description.getText();
            String nbrTTchamb = tf_nbTTchamb.getText();
            int nbrTTchambL = Integer.parseInt(nbrTTchamb);
            String prixNuite = tf_prix.getText();
            int prixNuiteL=Integer.parseInt(prixNuite);
            String imgL = tf_image.getText();
            
            
            
            
   /*         boolean nom_exist=false;
        try {
             nom_exist=sl.nom_exist(nomL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        if((nomL.isEmpty()) || (lieuL.isEmpty()) || (descriptionL.isEmpty()) || (nbrTTchamb.isEmpty()) || (prixNuite.isEmpty()) 
                || (imgL.isEmpty()) )
        {
            warn_label.setText("tous les champs doivents etre remplis");
        }
        
        else if(nom_exist)
        {warn_label.setText("ce nom existe");}*/
            
            
            
            
            //ServiceLogement sl = new ServiceLogement();
            Logement L = new Logement(nomL, lieuL, descriptionL, nbrTTchambL, prixNuiteL, imgL);
            sl.ajouter(L);
           // this.rafraichir();
            List<Logement> list=sl.readAll();
            
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
       
              
                
                col_nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu1.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_nbrTTchamb1.setCellValueFactory(new PropertyValueFactory<>("nbrTTchamb"));
                col_prix1.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
                
                tableau.setItems(obs);
                
                tf_nom.setText("");
                tf_lieu.setText("");
                ta_description.setText("");
                tf_nbTTchamb.setText("");
                tf_prix.setText("");
                tf_image.setText("");
        
    }

    
    
    @FXML
    private void liste_ref_selected(MouseEvent event) throws SQLException, FileNotFoundException  {
        
        if(! liste_nom.getSelectionModel().isEmpty())  
      {     String nomm=liste_nom.getSelectionModel().getSelectedItem();
           // System.out.println(nomm);
            btn_ajouterLog.setDisable(true);
        
           // List<Logement> list;
            
           // Logement L=sl.recuperer_logement(id);
           Logement L = sl.recuperer_logement(nomm);
         
           //System.out.println(L);
             tf_nom.setText(L.getNom());
             tf_image.setText(L.getImg());
             ta_description.setText(L.getDesc());
             tf_lieu.setText(L.getLieu());
             tf_nbTTchamb.setText(String.valueOf(L.getNbrTTchamb()));
             tf_prix.setText(String.valueOf(L.getPrixNuite()));
             
             
             image_viewer.setImage(new Image(new FileInputStream("resources/"+L.getImg()+".jpg")));
            //java.sql.Date d=java.sql.Date.valueOf(date_fin.getValue());
       } 
        
    }

    
    
    @FXML
    private void modifierLog(ActionEvent event) throws SQLException{
        
        if( ! liste_nom.getSelectionModel().isEmpty())
        {
                String nomm =liste_nom.getSelectionModel().getSelectedItem();
                //System.out.println(nomm);
            String nomL = tf_nom.getText();
            String lieuL = tf_lieu.getText();
            String descriptionL = ta_description.getText();
            String nbrTTchamb = tf_nbTTchamb.getText();
            int nbrTTchambL = Integer.parseInt(nbrTTchamb);
            String prixNuite = tf_prix.getText();
            int prixNuiteL=Integer.parseInt(prixNuite);
            String imgL = tf_image.getText();
        
        
     /*   if((nomL.isEmpty()) || (imgL.isEmpty()) || (descriptionL.isEmpty()) || (lieuL.isEmpty()) || (nbrTTchamb.isEmpty()) 
                || (prixNuite.isEmpty()) )
        {
            warn_label.setText("tous les champs doivents etre remplis");
        }
        
        
        
        else
        {*/
         
            
            
          
                sl.updateed(nomm,nomL,lieuL,descriptionL,nbrTTchambL,prixNuiteL,imgL);
                this.rafraichir();
           
           
        }
        
       
                
                 
       /* }
        else
        {
           Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("aucune selection");
                 alert.setHeaderText("aucune selection");
                alert.setContentText("svp selectionnez un element");
                 alert.showAndWait();
        }*/
        
    }

    
    
    
    @FXML
    private void supprimerLog(ActionEvent event) {
        
        if( ! liste_nom.getSelectionModel().isEmpty())
        {
                String nom=liste_nom.getSelectionModel().getSelectedItem();
             try {
                 sl.delete1(nom);
                 this.rafraichir();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
          
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
    private void interface_gerer_clicked(MouseEvent event) {
        this.rafraichir();
    }

    @FXML
    private void interface_afficher_clicked(MouseEvent event) {
        this.rafraichir();
    }
    
    @FXML
    private void rechercherLog(ActionEvent event) throws SQLException {
            String nomL = tf_rechercheNom.getText();
            String LieuL = tf_rechercheLieu.getText();
              list = sl.rechercherLieu(nomL,LieuL);
                ObservableList<Logement> obs=FXCollections.observableArrayList(list);
                tableau.getItems().clear();
                tableau.setItems(obs);
            //ServiceLogement sl = new ServiceLogement();
            
        //    ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
         
        
    }

    @FXML
    private void trierLog(ActionEvent event) throws SQLException {
        //ServiceLogement sl = new ServiceLogement();
            
            list = sl.trier();
            ObservableList<Logement> obs = FXCollections.observableArrayList(list);
            
            tableau.getItems().clear();
            tableau.setItems(obs);
        
    }

    @FXML
    private void rechercherResDateA(ActionEvent event) throws SQLException {
           
            String DateAL=(tf_dateA.getValue()).toString();
            //ServiceResLogement sl = new ServiceResLogement();
            list_res = sr.rechercherResLogDateA(DateAL);
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list_res);
            
            table_reservation.getItems().clear();
                table_reservation.setItems(obs);
    }

    @FXML
    private void PDF(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {

            list_res = sr.PdfResLog();
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list_res);
    }

    @FXML
    private void retour_acceuil(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_acceuil.fxml"));
           
             Parent root = loader.load();
           
             Admin_acceuilController apc = loader.getController();
                 retour_acceuil.getScene().setRoot(root);
    }

    

  
    
}
