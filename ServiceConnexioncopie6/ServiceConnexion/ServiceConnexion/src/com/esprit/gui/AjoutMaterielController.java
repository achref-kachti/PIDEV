/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Materiel;
import com.esprit.Service.ServiceMateriel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author House
 */
public class AjoutMaterielController implements Initializable {
   ObservableList<String> txtcatmatlist = FXCollections.observableArrayList("chasse","peche");
     ObservableList<String> txttypematlist = FXCollections.observableArrayList("vente","location");
   
     private boolean ADD=false;
     private boolean EDIT=false;
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
    private TableColumn<Materiel,String> imgcol;
    @FXML
    private Button bsupprmat;
    @FXML
    Label lblStatus;
    @FXML
    private Button brechmat;
    @FXML
    private Button bmodif;
    @FXML
    private TableColumn<?, ?> id_reservation_recherche;
    @FXML
    private TableColumn<?, ?> id_evenement_recherche1;
    @FXML
    private Button btri;
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.sql.SQLException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtcatmat.setValue("chasse");
        txtcatmat.setItems(txtcatmatlist);
        txttypemat.setValue("vente");
        txttypemat.setItems(txttypematlist);
            
            
            this.buildData();
           
        
        
    } 
    
    public AjoutMaterielController() {
      
    }
    @FXML
    private void HandleEvents(MouseEvent event) {
        //check if not empty
        if (txtrefmat.getText().isEmpty() || txtnommat.getText().isEmpty() || txtcatmat.getValue().equals(null) || txttypemat.getValue().equals(null)) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
            ajouter();
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
  /*************************************************************/
    private void ajouter() {
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
            
            
            Materiel m = new Materiel(refmat,nommat,catmat,descmat,typemat,prixmat,qtmat,imagemat);
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

    
  /**
     * @throws java.sql.SQLException***********************************************************************/
     public void buildData(){
        ServiceMateriel s= new ServiceMateriel();
            List <Materiel> list;
      try{ list= s.afficherlistemat();
            
            ObservableList<Materiel> obsr =FXCollections.observableArrayList(list);
            
            refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("description"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            tblData.setItems(obsr);
      }catch(SQLException ex ) {
      Logger.getLogger(AjoutMaterielController.class.getName()).log(Level.SEVERE, null, ex);
      
      }
            
      //tblData.getItems().clear();
       
       //tblData.getColumns().add(refcol);
        
       
    
}

    @FXML
    private void supprimermateriel(ActionEvent event) {
    
         ServiceMateriel sm= new ServiceMateriel();
       /*  bsupprmat.setOnAction(e -> {
    Materiel selectedItem = tblData.getSelectionModel().getSelectedItem();
    tblData.getItems().remove(selectedItem);
});*/
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
    private void recherchermateriel(ActionEvent event) throws IOException,SQLException {
        ServiceMateriel sm= new ServiceMateriel();
        String rech = txtrech.getText();  
        List<Materiel> listerech=sm.recherchemat(rech);
           
        ObservableList<Materiel> obsr =FXCollections.observableArrayList(listerech);
            
            refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("description"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            tblData.setItems(obsr);
        
    }
    @FXML
    private void triermateriel(ActionEvent event) throws IOException,SQLException{
       ServiceMateriel sm= new ServiceMateriel(); 
        List<Materiel> listetri=sm.triermat();
        ObservableList<Materiel> obsr =FXCollections.observableArrayList(listetri);
        
            refcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("ref"));
            nomcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nom"));
            catcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("categorie"));
            descrcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("description"));
            typecol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("type"));
            prixcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
            qtcol.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("quantite"));
            imgcol.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
            tblData.setItems(obsr);
    }

    @FXML
    private void modifiermateriel(ActionEvent event) throws IOException,SQLException{
         
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
         
         
        
          /*  int refmat = Integer.parseInt(txtrefmat.getText());
            String nommat = txtnommat.getText();
            String catmat = (String) txtcatmat.getValue();
            String descmat = txtdescrmat.getText();
            String typemat = (String) txttypemat.getValue();
            int prixmat = Integer.parseInt(txtprixmat.getText());
            int qtmat = Integer.parseInt(txtqtmat.getText());
            String imagemat = txtimgmat.getText();
            Materiel m1 = new Materiel(refmat,nommat,catmat,descmat,typemat,prixmat,qtmat,imagemat);
            sm.modifiermat(m1);
            this.buildData();*/
            
            
    }


    }
     
     
     /*********************************************************************/
      
      