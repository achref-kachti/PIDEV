/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*; 

/**
 * FXML Controller class
 *
 * @author moetez
 */
public class AdminEspeceController implements Initializable {

   String modeListe[] = {"a","b","c","d","e"};
  
  
        // Create a combo box 
                   
  
        // Create a tile pane 
    
  

    @FXML
    private TableView<Espece> tab_especes;
    @FXML
    private TableColumn<Espece, String> col_id;
    @FXML
    private TableColumn<Espece, String> col_nom;
    @FXML
    private TableColumn<Espece, String> col_desc;
    @FXML
    private TableColumn<Espece, String> col_saison;
    @FXML
    private TableColumn<Espece, String> col_type;
    
    @FXML
    private TableColumn<Espece, String> col_mode;
    @FXML
    private TableColumn<Espece, String> col_lieu;
    @FXML
    private JFXCheckBox t_chasse;
    @FXML
    private JFXCheckBox t_peche;
   
      
      ObservableList<String> nomES = FXCollections.observableArrayList("Alouette des champs","bécasse des bois" ,
"caille des blés,", 
"Brochet", "Sandre","Perche","Black-bass",
"Cerf", "Chevreuil", "Isard","Chamois", "Mouflon", "Sanglier");
     
      ObservableList<String> data = FXCollections.observableArrayList("Oiseaux de passage", "Poisson", "Petit gibier de montagne","Grand gibier");
      ObservableList<String> datasaison = FXCollections.observableArrayList("hiver", "printemps", "été","automne");
     @FXML
     private JFXComboBox<String> t_mode = new JFXComboBox<>(data);
     @FXML
     private JFXTextField t_lieu;
     @FXML
     private JFXTextArea t_desc;
    
     @FXML
     private JFXComboBox<String> t_saison =new JFXComboBox<>(datasaison);
     @FXML
     private JFXButton btn_Supprimer;
     @FXML
     private JFXButton btn_ajouterEs;
     private TextField t_nom_modi;
     private TextField t_type_modi;
     private TextField t_desc_modi;
    @FXML
    private JFXComboBox<String> t_nom=new JFXComboBox<>(nomES);
    @FXML
    private Button retour_acceuil;

    public void setT_nom_modi(TextField t_nom_modi) {
        this.t_nom_modi = t_nom_modi;
    }

    public void setT_type_modi(TextField t_type_modi) {
        this.t_type_modi = t_type_modi;
    }

    public void setT_desc_modi(TextField t_desc_modi) {
        this.t_desc_modi = t_desc_modi;
    }

   /* public void setT_sainson_modi(TextField t_sainson_modi) {
        this.t_sainson_modi = t_sainson_modi;
    }
    */
    //private TextField t_sainson_modi;
    
    @FXML
    private JFXButton btn_modifier;
    @FXML
    private JFXButton rechercher_espece;
    @FXML
    private JFXTextField nom_recherche;
   
    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
        t_mode.setItems(data);
        t_saison.setItems(datasaison);
        t_nom.setItems(nomES);

        try {
            list = sl.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
               // col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
                 col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));

                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_especes.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEspeceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

 

    @FXML
    private void modifier_espece(ActionEvent event) throws IOException,SQLException{
        /*  FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("update.fxml"));
              Parent root = loader.load();
             UpdateController apc = loader.getController();
               
                btn_modifier.getScene().setRoot(root);*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEspece.fxml"));
        Parent root = loader.load();
               UpdateEspeceController apc = loader.getController();
         String nom = tab_especes.getSelectionModel().getSelectedItem().getNom();
         String lieu = tab_especes.getSelectionModel().getSelectedItem().getLieu();
         String desc = tab_especes.getSelectionModel().getSelectedItem().getDescription();
         String saison = tab_especes.getSelectionModel().getSelectedItem().getSaison();
         String mode = tab_especes.getSelectionModel().getSelectedItem().getMode();
         
         
         
         // String type=  t_lype.getText();
         // String nom= t_nom.getText();                 
          /*String mode= t_mode.getValue();
          String lieu=  t_lieu.getText();
          String saison=  t_saison.getText();
        String desc=  t_desc.getText();*/
          //String description=r.getDescription();
          

          
          
         System.out.println(nom);
          
           System.out.println(mode);
            System.out.println(desc);
        
          //t_nom.setText(nom);
          t_lieu.setText(lieu);
         // t_mode.set
          t_desc.setText(desc);
          //t_saison.setText(saison);
          t_mode.setValue(mode);
          
          
          //apc.setM_nom(t_nom);
          apc.setM_description(t_desc);
          //apc.setM_saison(t_saison);
          apc.setM_lieu(t_lieu);
          apc.setM_mode(t_mode);
          
                 btn_modifier.getScene().setRoot(root);
              

      
       
                 
    }

    @FXML
    private void ajout_espece(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                        .getResource("AdminEspece.fxml"));
           String nom = t_nom.getSelectionModel().getSelectedItem();
           String saison = t_saison.getSelectionModel().getSelectedItem();
           String description = t_desc.getText();
           String lieu = t_lieu.getText();
           String type=null;
           if(t_chasse.isSelected())
           {
               type="chasse" ;
           }
           if(t_peche.isSelected())
           {
               type="peche";
           }
           
           String mode=    t_mode.getSelectionModel().getSelectedItem();

     

            
           
            ServiceEspece sp = new ServiceEspece();
            Espece p = new Espece(nom,type,mode,lieu, saison, description);
            sp.ajouter(p);
            
            List<Espece >list = sp.readAll();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
           
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));*/
               
                Parent root = loader.load();
                AdminEspeceController alc = loader.getController();
               col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
                tab_especes.setItems(obs);
               
               
               // btn_AjouterLogAdmin.getScene().setRoot(root);
             
                
                 
        
    }

    @FXML
    private void supprimer_espece(ActionEvent event) {
        
        
 ServiceEspece sp = new ServiceEspece();
           
          // Espece e = tab_especes.getSelectionModel().getSelectedItem();
        //   sp.supprimer(e.getNom());
         //  this.rafraichir();
               if(! tab_especes.getSelectionModel().isEmpty())
        {
           Espece e = tab_especes.getSelectionModel().getSelectedItem();
           sp.supprimer(e.getNom());     
           //  this.rafraichir();
           ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
            
         try {
            list = sp.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
            
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                
  
                col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));


             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_especes.setItems(obs);
                    
                    
        }
         catch (SQLException ex) {
            Logger.getLogger(AdminEspeceController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void rechercher_espece(ActionEvent event) throws SQLException {
        ServiceEspece se = new ServiceEspece();  
        FXMLLoader loader = new FXMLLoader
                        (getClass()
                        .getResource("AdminEspece.fxml"));
        String nom=nom_recherche.getText();
       List<Espece >list = se.RECHERCHER(nom);
   
          
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
         col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_mode.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                  col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
               
                tab_especes.setItems(obs);
        
    }

    @FXML
    private void retour_acceuil(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_acceuil.fxml"));
           
             Parent root = loader.load();
           
             Admin_acceuilController apc = loader.getController();
                 retour_acceuil.getScene().setRoot(root);
    }
    
}
