/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;
import java.sql.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FXMLController implements Initializable {
     users u=new users(66 ,"yousef" ,"zghal" ,"youssef@gmail.com" ,"youssef2010" ,new java.sql.Date(97, 11, 20),99377068  );
      List<Reservation> liste_reservation;
      List<Evenement> liste;
     @FXML
    private ListView<String> liste_view_user;
    Evenementc evenementcu=new Evenementc();
    Reservationc reservationcu=new Reservationc();
    userService usercu=new userService();
    //FXMLDocumentController controller=new  FXMLDocumentController();
    @FXML
    private TextField lieu_rechercheu;
    @FXML
    private TextField mot_cleu;
    @FXML
    private DatePicker a_partir_rechercheu;
    @FXML
    private DatePicker contenat_rechercheu;
    @FXML
    private Label label_rafrichir_u;
    @FXML
    private JFXButton rechercher_evenement_u;
    @FXML
    private JFXCheckBox prix_u;
    @FXML
    private AnchorPane pane_reserver;
    @FXML
    private ImageView image_reserver;
    @FXML
    private JFXTextArea description_reserver;
    @FXML
    private Label titre_reserver;
    @FXML
    private Label prix_label;
    @FXML
    private Label lieu_label;
    @FXML
    private Label date_reserver;
    @FXML
    private Label type_label;
    @FXML
    private JFXButton reserver_button;
    @FXML
    private Label prix_reserver;
    @FXML
    private Label lieu_resrerver;
    @FXML
    private Label type_reserver;
    @FXML
    private TableView<Reservation> table_reservation;
    @FXML
    private TableColumn id_reservation_recherche;
    @FXML
    private TableColumn id_user_recherche;
    @FXML
    private TableColumn email_recherche1;
    @FXML
    private TableColumn nom_recherche1;
    @FXML
    private TableColumn prenom_recherche1;
    @FXML
    private TableColumn telephone_recherche1;
    @FXML
    private TableColumn id_evenement_recherche1;
    @FXML
    private TableColumn titre_recherche1;
    @FXML
    private TableColumn lieu_recherche1;
    @FXML
    private TableColumn prix_recherche1;
    @FXML
    private TableColumn capacite_recherche1;
    @FXML
    private TableColumn date_debut_recherche1;
    @FXML
    private TableColumn date_fin_recherche1;
    @FXML
    private JFXComboBox<String> rechercher_combo;
    @FXML
    private JFXDatePicker date_contenat_recherche_r;
    @FXML
    private JFXCheckBox noncommence_rechercher_res;
    @FXML
    private JFXButton rechercher_reservation;
    @FXML
    private JFXButton supprimer_reservation;
    @FXML
    private Label prix_label1;
    @FXML
    private Label prix_label11;
    @FXML
    private JFXButton button_retour_acceuil;
    
    public void setUser(users user)
    {
        this.u=user;
    }
    
    public void rafraichir()
    {
       
        /*    Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        } catch (IOException ex) {
            ;
        }*/
        
      
       titre_reserver.setText("");
             
             description_reserver.clear();
             lieu_resrerver.setText("");
             
             prix_reserver.setText("");
             date_reserver.setText("");
             type_reserver.setText("");
             
            
             image_reserver.setImage(null);
             pane_reserver.setVisible(false);
       
        try {
            liste_view_user.getItems().clear();
            liste_view_user.getItems().addAll(evenementcu.rechercher("", "", "", "", "", "", true,"").stream().map(e->e.getTitre()).collect(Collectors.toList()));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        prix_u.setSelected(false);
        mot_cleu.clear();
        lieu_rechercheu.clear();
        a_partir_rechercheu.setValue(LocalDate.now());
         final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    LocalDate.now())
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
         a_partir_rechercheu.setDayCellFactory(dayCellFactory);
        contenat_rechercheu.setDayCellFactory(dayCellFactory);
        contenat_rechercheu.setValue(null);
        
         try {
             liste=evenementcu.afficher_evenements();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
         rechercher_combo.getItems().clear();
       rechercher_combo.getItems().add("");
       rechercher_combo.getItems().addAll(liste.stream().map(e->e.getTitre()).collect(Collectors.toList()));
       rechercher_combo.setValue("");
       noncommence_rechercher_res.setSelected(false);
    
    date_contenat_recherche_r.setValue(null);
        
        try {
            liste_reservation=reservationcu.rechercher_reservation("", u.getEmail(),true,"");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
        id_reservation_recherche.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_reservation"));
       id_user_recherche.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_user"));
       email_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("email"));
    nom_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("nom"));
    prenom_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("prenom"));
    telephone_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("telephone"));
    id_evenement_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_evenement"));
     titre_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("titre"));
      lieu_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("lieu"));
       prix_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Double>("prix"));
        capacite_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("capacite"));
     date_debut_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,java.sql.Date>("date_debut"));
    
     date_fin_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,java.sql.Date>("date_fin"));
    

       
      ObservableList<Reservation> obsr=FXCollections.observableArrayList(liste_reservation);
       table_reservation.getItems().clear();
       table_reservation.setItems(obsr);
       

        
    }
    
    private void showWebView(Stage primaryStage, String lieu) {
        // Create the WebView
        // Create the WebView
        String lat="";
        String lng="";
        if(lieu.toUpperCase().equals("HAMMAMET"))
        {lat="36.4";
        lng="10.616";}
         if(lieu.toUpperCase().equals("TUNIS"))
        {lat="36.818";
        lng="10.165";}
         if(lieu.toUpperCase().equals("TABARKA"))
        {lat="36.954";
        lng="8.757";}
         
        if(lieu.toUpperCase().equals("BEJA"))
        {lat="36.715";
        lng="9.201";}
        
        if(lieu.toUpperCase().equals("SOUSSE"))
        {lat="35.802";
        lng="10.663";}
        
        if(lieu.toUpperCase().equals("JENDOUBA"))
        {lat="36.484";
        lng="8.789";}
        
        if(lieu.toUpperCase().equals("AINDRAHEM"))
        {lat="36.773";
        lng="8.696";}
        if(lieu.toUpperCase().equals("NABEUL"))
        {lat="36.452";
        lng="10.729";}
        if(lieu.toUpperCase().equals("KEF"))
        {lat="36.171";
        lng="10.746";}
        
        /////////////////////////////////////////////////////////////////
        if(lieu.toUpperCase().equals("MONASTIR"))
        {lat="36.171";
        lng="10.746";}
        if(lieu.toUpperCase().equals("KELIBIA"))
        {lat="36.171";
        lng="10.746";}
          if(lieu.toUpperCase().equals("KORBA"))
        {lat="36.171";
        lng="10.746";}
           if(lieu.toUpperCase().equals("SFAX"))
        {lat="36.171";
        lng="10.746";}
           
           if(lieu.toUpperCase().equals("MAHDIA"))               
        {lat="36.171";
        lng="10.746";}
           
        if(lieu.toUpperCase().equals("TOZEUR"))               
        {lat="36.171";
        lng="10.746";}
        
        if(lieu.toUpperCase().equals("TATAOUINE"))               
        {lat="36.171";
        lng="10.746";}
        
        if(lieu.toUpperCase().equals("JERBA"))               
        {lat="36.171";
        lng="10.746";}



        
        
        
        WebView webView = new WebView();
         
        // Create the WebEngine
        final WebEngine webEngine = webView.getEngine();
 

        String Ch0 = new String("file:///D:/Data/tempo/openst.html?");
        String Ch = new String();
        Ch = Ch0 + "lat=" + lat + "&lng=" + lng;

        webEngine.load(Ch);

       

        // create root
        BorderPane root = new BorderPane();
        root.getStyleClass().add("map");
        root.setCenter(webView);
        /*root.setTop(toolBar);*/
        // create scene
        Scene secondScene = new Scene(root, 800, 550, Color.web("#666970"));
 
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setScene(secondScene);
        newWindow.setTitle("Web Map");
        
                   // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
 
            // Specifies the owner Window (parent) for new window
        newWindow.initOwner(primaryStage);
 

        //secondScene.getStylesheets().add("/WebMap.css");
        // show stage
        newWindow.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rafraichir();
        System.out.println(u);
        // TODO
    }    

    @FXML
    private void rechercher_evenement_u(ActionEvent event) {
        pane_reserver.setVisible(false);
        String lieu=lieu_rechercheu.getText();
        
        LocalDate a_partir=a_partir_rechercheu.getValue();
        LocalDate contenant=contenat_rechercheu.getValue();
        String a_partir_chaine="";
        String contenant_chaine="";
        String description=mot_cleu.getText();
      
       
        
        if(a_partir !=null)
        {
            a_partir_chaine=java.sql.Date.valueOf(a_partir).toString();
            
        }
          if(contenant !=null)
        {
            contenant_chaine=java.sql.Date.valueOf(contenant).toString();
            
        }
          
          
      
        try {
            liste_view_user.getItems().clear();
            liste_view_user.getItems().addAll(evenementcu.rechercher("", "", "", lieu, a_partir_chaine, contenant_chaine,true,description).stream().map(e->e.getTitre()).collect(Collectors.toList()));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    @FXML
    private void label_rafraichir_clicked(MouseEvent event) {
        this.rafraichir();
    }

    @FXML
    private void a_partir_date(MouseEvent event) {
          final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    a_partir_rechercheu.getValue())
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        contenat_rechercheu.setDayCellFactory(dayCellFactory);
        //contenat_rechercheu.setValue(null);
        
    }

    @FXML
    private void prix_croissant_clicked(MouseEvent event) {
         String lieu=lieu_rechercheu.getText();
        
        LocalDate a_partir=a_partir_rechercheu.getValue();
        LocalDate contenant=contenat_rechercheu.getValue();
        String a_partir_chaine="";
        String contenant_chaine="";
        String description=mot_cleu.getText();
      
       
        
        if(a_partir !=null)
        {
            a_partir_chaine=java.sql.Date.valueOf(a_partir).toString();
            
        }
          if(contenant !=null)
        {
            contenant_chaine=java.sql.Date.valueOf(contenant).toString();
            
        }
          
          
      if(prix_u.isSelected())
      {   
        try {
            liste_view_user.getItems().clear();
            liste_view_user.getItems().addAll(evenementcu.rechercher("", "", "", lieu, a_partir_chaine, contenant_chaine,true,description).stream().sorted((e1,e2)->(int)(e1.getPrix()-e2.getPrix())).map(e->e.getTitre()).collect(Collectors.toList()));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      else
      {   
             try {liste_view_user.getItems().clear();
                 liste_view_user.getItems().addAll(evenementcu.rechercher("", "", "", lieu, a_partir_chaine, contenant_chaine,true,description).stream().map(e->e.getTitre()).collect(Collectors.toList()));
             } catch (SQLException ex) {
                 Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
      }
    }

    @FXML
    private void liste_view_user_clicked(MouseEvent event) {
        String message="";
        if(! liste_view_user.getSelectionModel().isEmpty())  
      {
          pane_reserver.setVisible(true);
          String titre=liste_view_user.getSelectionModel().getSelectedItem();
      
        try {
            Evenement e=evenementcu.recuperer_evenement_titre(titre);
           int nb= reservationcu.nb_place_restant(e.getId());
           if(nb<=0){message="complet";}
           else{ message="encore "+nb+ "places";}
             titre_reserver.setText(e.getTitre());
             
             description_reserver.setText(e.getDescription());
             lieu_resrerver.setText(e.getLieu());
             
             prix_reserver.setText(e.getPrix()+"");
             date_reserver.setText(e.getDate_debut()+"/"+e.getDate_fin()+" "+message);
             type_reserver.setText(e.getType());
             
            
             image_reserver.setImage(new Image(new FileInputStream("resources/"+e.getImage()+".jpg")));
            //java.sql.Date d=java.sql.Date.valueOf(date_fin.getValue());
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
              System.out.println(ex);
          }
      } 
    }

    @FXML
    private void reserver_clicked(ActionEvent event) {
        
        if(! liste_view_user.getSelectionModel().isEmpty())  
      {
          pane_reserver.setVisible(true);
          String titre=liste_view_user.getSelectionModel().getSelectedItem();
      
        try {
            Evenement e=evenementcu.recuperer_evenement_titre(titre);
           reservationcu.ajouter_reservation(new Reservation(1,e.getId(),u.getId()));
           this.rafraichir();
             
            
            //java.sql.Date d=java.sql.Date.valueOf(date_fin.getValue());
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
      } 
    }

    @FXML
    private void rechercher_reservation_clicked(ActionEvent event) {
        
        String titrerr=rechercher_combo.getValue();
        
        
   
    boolean noncommencer= noncommence_rechercher_res.isSelected();
    
    LocalDate contenantr=date_contenat_recherche_r.getValue();
      
        String contenant_chainer="";
      
       

          if(contenantr !=null)
        {
            contenant_chainer=java.sql.Date.valueOf(contenantr).toString();
            
        }
          List<Reservation> lister=new ArrayList<Reservation>();
          
        try {
           lister=reservationcu.rechercher_reservation(titrerr, u.getEmail(),true, contenant_chainer);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
       id_reservation_recherche.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_reservation"));
       id_user_recherche.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_user"));
       email_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("email"));
    nom_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("nom"));
    prenom_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("prenom"));
    telephone_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("telephone"));
    id_evenement_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_evenement"));
     titre_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("titre"));
      lieu_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,String>("lieu"));
       prix_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Double>("prix"));
        capacite_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("capacite"));
     date_debut_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,java.sql.Date>("date_debut"));
    
     date_fin_recherche1.setCellValueFactory(new PropertyValueFactory<Reservation,java.sql.Date>("date_fin"));
    

       
      ObservableList<Reservation> obsrr=FXCollections.observableArrayList(lister);
       table_reservation.getItems().clear();
       table_reservation.setItems(obsrr);
              
       
       
       
    }

    @FXML
    private void supprimer_res(ActionEvent event) {
          if(! table_reservation.getSelectionModel().isEmpty())
        {
           Reservation r = table_reservation.getSelectionModel().getSelectedItem();
            try {
                reservationcu.annuler_reservation(r.getId_reservation());
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
    private void lieu_reserver_clicked(MouseEvent event) {
        this.showWebView(new Stage(), lieu_resrerver.getText());
    }

    @FXML
    private void retour_acceuil_clicked(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("User_acceuil.fxml"));
          
          Parent root = loader.load();
           
             User_acceuilController apc1 = loader.getController();
             apc1.setUser(u);
       
                 button_retour_acceuil.getScene().setRoot(root);
    }

    
}
