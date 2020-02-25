/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.AfficherMatrielPanier;
import com.esprit.Entite.Panier;
import com.esprit.Entite.Materiel;
import com.esprit.Entite.users;
import com.esprit.Service.ServicePanier;
import com.esprit.Service.ServiceMateriel;
import com.esprit.Service.userService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import java.sql.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;



/**
 * FXML Controller class
 *
 * @author sarah
 */
public class UserController implements Initializable {
     users u=new users(200 ,"gmiha" ,"sarah" ,"sarah_gmiha@hotmail.fr" ,"1234" ,new java.sql.Date(15, 07, 19),25147895  );
     userService usercu=new userService();
      
      List<Panier> liste_panier;
      ServicePanier sp= new ServicePanier();
     
      List<Materiel> liste_mat;
      ServiceMateriel sm= new ServiceMateriel();
    @FXML
    private Tab cataloguetab;
    @FXML
    private JFXListView<String> listecatalogue;
    @FXML
    private JFXButton baddtocart;
    @FXML
    private JFXButton bsupprimer;
    @FXML
    private ImageView image_mat;
    @FXML
    private JFXTextField nommat;
    @FXML
    private JFXTextField descmat;
    @FXML
    private JFXTextField prixmat;
    @FXML
    private JFXTextField champtot;
    @FXML
    private Tab cataloguetab1;
    @FXML
    private ImageView image_mat1;
    @FXML
    private JFXButton btripan;
    @FXML
    private TableView<AfficherMatrielPanier> tblpanier;
    @FXML
    private TableColumn<AfficherMatrielPanier, String> refmatcol;
    @FXML
    private TableColumn<AfficherMatrielPanier, String> idusercol;
    @FXML
    private TableColumn<AfficherMatrielPanier, Integer> qtacheteecol;
    @FXML
    private Label tot;
    @FXML
    private JFXButton bpdf;
    @FXML
    private ImageView back;
    @FXML
    private TableColumn<AfficherMatrielPanier,Integer> prixcol;
    @FXML
    private JFXButton brecherche;
    @FXML
    private TextField txtrech;
    @FXML
    private JFXTextField typematt;

    /**
     * Initializes the controller class.
     */
     public void setUser(users user)
    {
        this.u=user;
    }
     public void rafraichir(){
             //nommat.setText("");
             //descmat.setText("");
             //prixmat.setText("");
             image_mat.setImage(null);
             this.afficherlistepanier();
             this.buildData();
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.rafraichir();
       this.afficherlistepanier();
       this.buildData();
       this.total();
    }    

    @FXML
    private void ajouteraupanier(ActionEvent event) {
         if(! listecatalogue.getSelectionModel().isEmpty())  
      {
        
          String titre=listecatalogue.getSelectionModel().getSelectedItem();
      
        try {
            Materiel e=sm.recuperermattitre(titre);
            
            Panier p= new Panier(e.getRef(),u.getId());
            
           sp.ajouterach(p);
           
           this.buildData();
            
            
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
      } 
        
    }

    /*affichage listeview*/
    private void afficherlistepanier(){
         
         try {
             
            listecatalogue.getItems().clear();
            listecatalogue.getItems().addAll(sm.afficherlistemat().stream().map(e->e.getNom()).collect(Collectors.toList()));
           
     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void listviewclicked(MouseEvent event) throws SQLException, FileNotFoundException {
        //String message="";
        if(! listecatalogue.getSelectionModel().isEmpty())  
      {
         String title=listecatalogue.getSelectionModel().getSelectedItem();
         Materiel e;
         e = sm.recuperermattitre(title);
             nommat.setText(e.getNom());
             descmat.setText(e.getDesc());
             prixmat.setText(String.valueOf(e.getPrix()+"dt"));
             image_mat.setImage(new Image(new FileInputStream("resources/"+e.getImage()+".jpg")));
              typematt.setText(e.getType());
            
             
        
          }
      } 

    @FXML
   private void tripanier(ActionEvent event) throws SQLException {
        ServicePanier sm= new ServicePanier(); 
        List<AfficherMatrielPanier> listetri=sm.trierach();
        ObservableList<AfficherMatrielPanier> obsr =FXCollections.observableArrayList(listetri);
           refmatcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("nommat"));
            idusercol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("prenom"));
            qtacheteecol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("qtach"));
            prixcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("prixmat"));
            tblpanier.setItems(obsr);
    }
    
     public void buildData(){
        ServicePanier s= new ServicePanier();
            List <AfficherMatrielPanier> list;
      try{ list= s.afficherlisteachjoint(u.getId());
                  
            ObservableList<AfficherMatrielPanier> obsr =FXCollections.observableArrayList(list);
            
           
            refmatcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("nommat"));
            idusercol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("prenom"));
            qtacheteecol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("qtach"));
            prixcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("prixmat"));
         
            tblpanier.setItems(obsr);
      }catch(SQLException ex ) {
      Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
      
      }
            
     }

    @FXML
   private void supprimerdupanier(ActionEvent event) throws IOException,SQLException{
       ServicePanier sp= new ServicePanier();
        if(! tblpanier.getSelectionModel().isEmpty())
        {
             AfficherMatrielPanier r = tblpanier.getSelectionModel().getSelectedItem();
           
             
             
                 
                 sp.annuler_achat(r.getIdach());
          this.buildData();
            

       
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

    
    public void total() {
        double p=0;
        try{
        p=sp.calcultotal(u.getId());
        champtot.setText(String.valueOf(p+"dt"));
        }catch(SQLException ex ) {
      Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
      
      }
        
    }

    @FXML
    private void afficherphoto(MouseEvent event) throws SQLException, FileNotFoundException {
        ServicePanier s= new ServicePanier();
          if(! tblpanier.getSelectionModel().isEmpty())  
      {
         AfficherMatrielPanier p=tblpanier.getSelectionModel().getSelectedItem();
         
        
            image_mat1.setImage(new Image(new FileInputStream("resources/"+p.getImagemat()+".jpg")));
            
             
        
          }
    }

    @FXML
    private void genererpdf(ActionEvent event)throws IOException,SQLException, FileNotFoundException, DocumentException {
        ServicePanier sp= new ServicePanier();
        sp.pdf(u.getId());
    }

    @FXML
    private void cherchepanier(ActionEvent event) throws IOException,SQLException {
      ServicePanier sp= new ServicePanier();
      if(txtrech.getText().trim().isEmpty()){
          this.buildData();;
      }
      else{
        String rech = txtrech.getText();  
        List<AfficherMatrielPanier> listerech=sp.rechercheach(rech,u.getId());
           
        ObservableList<AfficherMatrielPanier> obsr =FXCollections.observableArrayList(listerech);
           refmatcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("nommat"));
            idusercol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,String>("prenom"));
            qtacheteecol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("qtach"));
            prixcol.setCellValueFactory(new PropertyValueFactory<AfficherMatrielPanier,Integer>("prixmat"));
            txtrech.clear();
            tblpanier.getItems().clear();
            tblpanier.setItems(obsr); 
      }  
    }
}

   

    
   

   
    
