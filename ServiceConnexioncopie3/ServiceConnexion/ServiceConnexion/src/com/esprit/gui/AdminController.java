/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Materiel;
import com.esprit.Service.ServiceMateriel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.io.File;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author sarah
 */
public class AdminController implements Initializable {
 ObservableList<String> txtcatmatlist = FXCollections.observableArrayList("chasse","peche");
 ObservableList<String> txttypematlist = FXCollections.observableArrayList("vente","location");
 ServiceMateriel s= new ServiceMateriel();
 JFXListView <?> list;
 @FXML
    private TextField txtrefmat;
    @FXML
    private TextField txtnommat;
    @FXML
    private ComboBox<String> txtcatmat;
    @FXML
    private TextField txtdescrmat;
    @FXML
    private ComboBox<String> txttypemat;
    @FXML
    private TextField txtprixmat;
    @FXML
    private TextField txtqtmat;
    @FXML
    private TextField txtimgmat;
     @FXML
    private TextField txtrech;
    @FXML
    private Button bajoutermat;
    @FXML
    TableView<Materiel> tblData;
    @FXML
    private TableColumn<Materiel,Integer> refcol;
    @FXML
    private TableColumn<Materiel,String> nomcol;
    @FXML
    private TableColumn<Materiel,String> catcol;
    @FXML
    private TableColumn<Materiel,String> descrcol;
    @FXML
    private TableColumn<Materiel,String> typecol;
    @FXML
    private TableColumn<Materiel,Integer> prixcol;
    @FXML
    private TableColumn<Materiel,Integer> qtcol;
    @FXML
    private Button bsupprmat;
    @FXML
    Label lblStatus;
    @FXML
    private Button brechmat;
    @FXML
    private Button bmodif;
    @FXML
    private Button btri;
    
    @FXML
    private TabPane tabpane;
    @FXML
    private Tab tabmateriel;
     @FXML
    private Tab tabform;
    @FXML
    private TableColumn<?, ?> id_reservation_recherche;
    @FXML
    private JFXComboBox<String> txttype;
    @FXML
    private ImageView back;
    @FXML
    private JFXListView<String> listee;
  
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtcatmat.setValue("chasse");
        txtcatmat.setItems(txtcatmatlist);
        txttypemat.setValue("vente");
        txttypemat.setItems(txttypematlist);
        
        txttype.setValue("vente");
        txttype.setItems(txttypematlist);
     
           this.buildData();
    }  
    
    private void HandleEvents(MouseEvent event) {
        //check if not empty
        if (txtrefmat.getText().isEmpty() || txtnommat.getText().isEmpty() || txtcatmat.getValue().equals(null) || txttypemat.getValue().equals(null)) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
            ajoutermateriel();
        }

    }
    
    private void clearFields() {
        txtrefmat.clear();
        txtnommat.clear();
       
        txtdescrmat.clear();
        txtprixmat.clear();
        
        txtqtmat.clear();
        txtimgmat.clear();
       
    }

    @FXML
    private void supprimermateriel(ActionEvent event) throws IOException,SQLException{
        ServiceMateriel sm= new ServiceMateriel();
      
        if(! tblData.getSelectionModel().isEmpty())
        {
           Materiel m = tblData.getSelectionModel().getSelectedItem();
            try {
                sm.supprimermat(m);
                //System.out.println("enntreee");
                
                 this.buildData();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                 
        }
        else
        {
               Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("aucune selection");
                 alert.setHeaderText("aucune selection");
                alert.setContentText("Veuillez selectionner un element");
                 alert.showAndWait();
        }
    }

    @FXML
    private void triermateriel(ActionEvent event)throws IOException,SQLException {
        ServiceMateriel sm= new ServiceMateriel(); 
        String type = (String) txttype.getValue();
        List<Materiel> listetri=null;
          if(type=="vente")
          {listetri=sm.triermat("vente");}
          if(type=="location") 
          {listetri=sm.triermat("location");}
        
        ObservableList<Materiel> obsr =FXCollections.observableArrayList(listetri);
        
           // refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("description"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            //imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            tblData.setItems(obsr);
    }

    @FXML
    private void cherchermateriel(ActionEvent event) throws IOException,SQLException {
        ServiceMateriel sm= new ServiceMateriel();
        String rech = txtrech.getText();  
        String type = (String) txttype.getValue();
        List<Materiel> listerech=null;
        listerech=sm.recherchemat(rech,type);
           
        ObservableList<Materiel> obsr =FXCollections.observableArrayList(listerech);
            
            //refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("description"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            //imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            txtrech.clear();
            tblData.getItems().clear();
            tblData.setItems(obsr);
    }

    @FXML
    private void ajoutermateriel() {
        ServiceMateriel s= new ServiceMateriel();
        try {
           
            int refmat = Integer.parseInt(txtrefmat.getText());
            String nommat = txtnommat.getText();
            String catmat = (String) txtcatmat.getValue();
            String descmat = txtdescrmat.getText();
            String typemat = (String) txttypemat.getValue();
            int prixmat = Integer.parseInt(txtprixmat.getText());
            int qtmat = Integer.parseInt(txtqtmat.getText());
            String imagemat = txtimgmat.getText();
           //String imagemat =  filechoose(event);
       FileChooser fc = new FileChooser();
       String n = null;
       fc.setInitialDirectory(new File ("C:\\Users\\sarah\\Documents\\NetBeansProjects\\ServiceConnexioncopie3\\ServiceConnexion\\ServiceConnexion\\resources"));
       fc.getExtensionFilters().addAll(new ExtensionFilter("*.jpg","*.png"));
       File selectedfile=fc.showOpenDialog(null);
       if(selectedfile!=null){
         listee.getItems().add(selectedfile.getName());
          String name_img= selectedfile.getName();
          System.out.print(name_img);
         txtimgmat.setText(name_img);
         n=name_img;
           
         }else{
           System.out.println("file not valid");
    
       }
            
            
            Materiel m = new Materiel(refmat,nommat,catmat,descmat,typemat,prixmat,qtmat,n);
            s.ajoutermat(m);
            
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Added Successfully");
            this.buildData();
            this.clearFields();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());
            
        }
    }
    
     public void buildData(){
        ServiceMateriel s= new ServiceMateriel();
            List <Materiel> list = null;
            
      try{ String type = (String) txttype.getValue();
          if(type=="vente")
          {list= s.afficherlistematvente();}
          if(type=="location") 
          {list=s.afficherlistematloc();}
            
            ObservableList<Materiel> obsr =FXCollections.observableArrayList(list);
            
           // refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("desciption"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            //imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            tblData.setItems(obsr);
      }catch(SQLException ex ) {
      Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
      
      }
            
     }
    @FXML
    private void modifiermateriel(ActionEvent event) throws SQLException {
     
         ServiceMateriel s= new ServiceMateriel();
        
         int refmat = Integer.parseInt(txtrefmat.getText());
         String nommat = txtnommat.getText();
         String catmat = (String) txtcatmat.getValue();
         String descmat = txtdescrmat.getText();
         String typemat = (String) txttypemat.getValue();
         int prixmat = Integer.parseInt(txtprixmat.getText());
         int qtmat = Integer.parseInt(txtqtmat.getText());
         String imagemat = txtimgmat.getText();
         
         FileChooser fc = new FileChooser();
       String n = null;
       fc.setInitialDirectory(new File ("C:\\Users\\sarah\\Documents\\NetBeansProjects\\ServiceConnexioncopie3\\ServiceConnexion\\ServiceConnexion\\resources"));
       fc.getExtensionFilters().addAll(new ExtensionFilter("*.jpg","*.png"));
       File selectedfile=fc.showOpenDialog(null);
       if(selectedfile!=null){
         listee.getItems().add(selectedfile.getName());
          String name_img= selectedfile.getName();
          System.out.print(name_img);
         txtimgmat.setText(name_img);
         n=name_img;
           
         }else{
           System.out.println("file not valid");
    
       }
            
         
         Materiel m1 = new Materiel(refmat,nommat,catmat,descmat,typemat,prixmat,qtmat,imagemat);
         s.modifiermat(m1,refmat);
         tblData.getItems().clear();
         lblStatus.setTextFill(Color.GREEN);
         lblStatus.setText("Added Successfully");
         this.buildData();
         this.clearFields();
    }
    
    
    
    



   /* @FXML
    private void updatemateriel(ActionEvent event)  throws IOException,SQLException {
        Materiel m = tblData.getSelectionModel().getSelectedItem();
         
         
         txtrefmat.setText(String.valueOf(m.getRef()));
         txtnommat.setText(m.getNom());
         txtcatmat.setValue(m.getCategorie());
         txtdescrmat.setText(m.getDesc());
         txttypemat.setValue(m.getType());
         txtprixmat.setText(String.valueOf(m.getPrix()));
         txtqtmat.setText(String.valueOf(m.getQuantite()));
         txtimgmat.setText(m.getImage());
    }*/

    @FXML
    private void modifiermaterielonclick(MouseEvent event) {
         Materiel m = tblData.getSelectionModel().getSelectedItem();
         
         /*remplissage du formulaire par la ligne selectionnee*/
         txtrefmat.setText(String.valueOf(m.getRef()));
         txtnommat.setText(m.getNom());
         txtcatmat.setValue(m.getCategorie());
         txtdescrmat.setText(m.getDesc());
         txttypemat.setValue(m.getType());
         txtprixmat.setText(String.valueOf(m.getPrix()));
         txtqtmat.setText(String.valueOf(m.getQuantite()));
         txtimgmat.setText(m.getImage());
    }

    @FXML
    private void typeaction(ActionEvent event) {
        this.buildData();
    }

 /*
    private String filechoose(ActionEvent event) {
       FileChooser fc = new FileChooser();
       String n = null;
       fc.setInitialDirectory(new File ("C:\\Users\\sarah\\Documents\\NetBeansProjects\\ServiceConnexioncopie3\\ServiceConnexion\\ServiceConnexion\\resources"));
       fc.getExtensionFilters().addAll(new ExtensionFilter("*.jpg","*.png"));
       File selectedfile=fc.showOpenDialog(null);
       if(selectedfile!=null){
         listee.getItems().add(selectedfile.getName());
          String name_img= selectedfile.getName();
          System.out.print(name_img);
         txtimgmat.setText(name_img);
         n=name_img;
           
         }else{
           System.out.println("file not valid");
       }
       return n;
       
    }*/

    @FXML
    private void filechoose(ActionEvent event) {
    }
}

