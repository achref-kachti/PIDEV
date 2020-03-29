/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TabPane tabpane;
    @FXML
    private Tab tab_gerer;
    @FXML
    private Button button_ajouter;
    @FXML
    private ListView<String> liste_ref;
     Evenementc evenementc=new Evenementc();
     Reservationc reservationc=new Reservationc();
      List<Evenement> liste;
      List<Reservation> liste_reservation;
      List<Modelestat> liste_modele;
    @FXML
    private TextArea description;
    @FXML
    private TextField lieu;
    @FXML
    private TextField image;
    @FXML
    private TextField titre;
    @FXML
    private TextField capacite;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private AnchorPane interface_gerer;
    @FXML
    private Label warn_label;
    @FXML
    private Button modifier_button;
    @FXML
    private Button button_supprimer;
   
    @FXML
    private Tab afficher_evenement;
    @FXML
    private AnchorPane interface_afficher;
    
    @FXML
    private TableView<Evenement> tableau;
    @FXML
    private TableColumn colonne1_id;
    @FXML
    private TableColumn colonne1_titre;
    @FXML
    private TableColumn colonne_image;
    @FXML
    private TableColumn colonne_description;
    @FXML
    private TableColumn colonne_lieu;
    @FXML
    private TableColumn colonne_capacite;
    @FXML
    private TableColumn colonne_prix;
    @FXML
    private TableColumn colonne_date_debut;
    @FXML
    private TableColumn colonne_date_fin;
    @FXML
    private TextField titre_recherche;
    @FXML
    private TextField capacite_recherche;
    @FXML
    private TextField prix_recherche;
    @FXML
    private TextField lieu_recherche;
    @FXML
    private DatePicker a_partir_recherche;
    @FXML
    private DatePicker contenat_recherche;
    @FXML
    private Button button_recherche;
    @FXML
    private CheckBox non_commence;
    @FXML
    private PieChart chart;
    @FXML
    private BarChart chart_bar;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private ComboBox<String> combo_type;
    @FXML
    private TableColumn colonne_type;
    @FXML
    private ImageView image_viewer;
    @FXML
    private TextField mot_cle;
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
    private TableColumn id_evenement_recherche1;
 
    @FXML
    private TextField email_recherche_res;
    @FXML
    private DatePicker date_contenat_recherche_r;
    @FXML
    private CheckBox noncommence_rechercher_res;
    @FXML
    private Button rechercher_reservation;
    @FXML
    private ComboBox<String> rechercher_combo;
    @FXML
    private Button supprimer_reservation;
    @FXML
    private BarChart chart_reservation;
    @FXML
    private NumberAxis nb_y;
    @FXML
    private CategoryAxis evenement;
    @FXML
    private TableView<Modelestat> modele;
    @FXML
    private TableColumn titre_modele;
    @FXML
    private TableColumn reserve_modele;
    @FXML
    private TableColumn capacite_modele;
    @FXML
    private TableColumn etat_modele;
    @FXML
    private CheckBox non_commence_modele;
    @FXML
    private CheckBox complet_modele;
    @FXML
    private Label label_modele;
   
    

    
   public void rafraichir()
   {
       date_debut.setValue(LocalDate.now().plusDays(1));
        date_fin.setValue(LocalDate.now().plusDays(2));
        titre.clear();
        image.clear();
        description.clear();
        capacite.clear();
        prix.clear();
        lieu.clear();
        combo_type.setValue("decouverte");
        warn_label.setText("");
        non_commence_modele.setSelected(false);
        complet_modele.setSelected(false);
       
        image_viewer.setImage(null);
        button_ajouter.setDisable(false);
        try {
             liste=evenementc.afficher_evenements();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            liste_reservation=reservationc.afficher_reservation_complete();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            liste_modele=reservationc.modele();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
        try {
            liste_ref.getItems().clear();
              //ajouter les id des evenement non commences dans la liste view
             // liste_ref.getItems().addAll(evenementc.rechercher("", "", "", "", "", "", true,"").stream().map(e->e.getId()).collect(Collectors.toList()));
             
             //ajouter les titres des evenement non commences dans la liste view
             //liste_ref.getItems().addAll(evenementc.rechercher("", "", "", "", "", "", true,"").stream().map(e->e.getTitre()).collect(Collectors.toList()));
           
           liste_ref.getItems().addAll(evenementc.afficher_evenements().stream().map(e->e.getTitre()).collect(Collectors.toList()));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
   
        
       colonne1_id.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id"));
       colonne1_titre.setCellValueFactory(new PropertyValueFactory<Evenement,String>("titre"));
       colonne_image.setCellValueFactory(new PropertyValueFactory<Evenement,String>("image"));
    colonne_description.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
    colonne_lieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieu"));
    colonne_capacite.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("capacite"));
     colonne_prix.setCellValueFactory(new PropertyValueFactory<Evenement,Double>("prix"));
     colonne_date_debut.setCellValueFactory(new PropertyValueFactory<Evenement,java.sql.Date>("date_debut"));
    
     colonne_date_fin.setCellValueFactory(new PropertyValueFactory<Evenement,java.sql.Date>("date_fin"));
     colonne_type.setCellValueFactory(new PropertyValueFactory<Evenement,String>("type"));

       
      ObservableList<Evenement> obs=FXCollections.observableArrayList(liste);
       tableau.getItems().clear();
       tableau.setItems(obs);
       
       
       
      
    
       
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
       







 titre_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("titre"));
       reserve_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("reserve"));
       capacite_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("capacite"));
    etat_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("etat"));
    

       
      ObservableList<Modelestat> obs_modele=FXCollections.observableArrayList(liste_modele);
       modele.getItems().clear();
       modele.setItems(obs_modele);
       
       
       



       
       
       rechercher_combo.getItems().clear();
       rechercher_combo.getItems().add("");
       rechercher_combo.getItems().addAll(liste.stream().map(e->e.getTitre()).collect(Collectors.toList()));
       rechercher_combo.setValue("");
       
       
       
       
       
       
       
       
          ResultSet stat = null;
           XYChart.Series dataSeries1 = new XYChart.Series();
        

      
        

        
      
        try {
            stat= evenementc.stat_evenements();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        chart.getData().clear();
        try {
            while(stat.next())
            {
                  dataSeries1.getData().add(new XYChart.Data(stat.getString(1),stat.getInt(2)));
               chart.getData().add(new PieChart.Data(stat.getString(1), stat.getDouble(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        chart_bar.getData().clear();
        chart_bar.getData().add(dataSeries1);
        
        
        
        
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("cpacite");
         XYChart.Series dataSeries4 = new XYChart.Series();
        dataSeries4.setName("nb_place reserve");
        
        ResultSet stat_r=null;
        try {
            stat_r=reservationc.stat();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            while(stat_r.next())
            {
                 
                  dataSeries3.getData().add(new XYChart.Data(stat_r.getString(1),stat_r.getInt(3)));
                  dataSeries4.getData().add(new XYChart.Data(stat_r.getString(1),stat_r.getInt(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        chart_reservation.getData().clear();
        chart_reservation.getData().add(dataSeries3);
         chart_reservation.getData().add(dataSeries4);
        
        
        
        
        
        
        
       
   }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       /* try {
            evenementc.supprimer_evenement_depasses();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
            this.rafraichir();
            
            prix.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
            prix.setText(oldValue);
            }
            }
            });
            
            capacite.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,7}?")) {
            capacite.setText(oldValue);
            }
            }
            });
            prix_recherche.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
            prix_recherche.setText(oldValue);
            }
            }
            });
            
            capacite_recherche.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,7}?")) {
            capacite_recherche.setText(oldValue);
            }
            }
            });
            
            
            combo_type.getItems().addAll("decouverte","chasse","camping");
            combo_type.setValue("decouverte");
            
            
            
            
            
         }    

    @FXML
    private void ajouter(ActionEvent event){
        String titre_text=titre.getText();
        String image_text=image.getText();
        String description_text=description.getText();
        String lieu_text =lieu.getText();
        String capacite_text=capacite.getText();
        String prix_text=prix.getText();
         boolean titre_exist=false;
        try {
             titre_exist=evenementc.titre_exist(titre_text);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        java.sql.Date date_debut_text=java.sql.Date.valueOf(date_debut.getValue());
        java.sql.Date date_fin_text=java.sql.Date.valueOf(date_fin.getValue());
        
        String type_text=combo_type.getValue();
        System.out.println("type="+type_text);
        
        if((titre_text.isEmpty()) || (image_text.isEmpty()) || (description_text.isEmpty()) || (lieu_text.isEmpty()) || (capacite_text.isEmpty()) 
                || (prix_text.isEmpty()) || (type_text.isEmpty()))
        {
            warn_label.setText("tous les champs doivents etre remplis");
        }
        else if(date_debut_text.compareTo(java.sql.Date.valueOf(LocalDate.now()))<=0)
        {
            warn_label.setText("date debut <= date actuel");
            
        }    
        else if(date_debut_text.compareTo(date_fin_text)==1)
        {
             warn_label.setText("date debut superieur a date fin");
        }
        else if(titre_exist)
        {warn_label.setText("ce titre existe");}
        
        else
        {
            double d_prix=Double.parseDouble(prix_text);
            int int_capacite=Integer.parseInt(capacite_text);
            
            Evenement e1=new Evenement(1,titre_text,image_text,description_text,lieu_text,int_capacite,d_prix,date_debut_text,date_fin_text,type_text);
            try {
                evenementc.ajouter_evenement(e1);
                this.rafraichir();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
           
        }
        
       
        
      
       
    }

    @FXML
    private void liste_ref_selected(MouseEvent event) {
      if(! liste_ref.getSelectionModel().isEmpty())  
      {String titre_recup=liste_ref.getSelectionModel().getSelectedItem();
      
      button_ajouter.setDisable(true);
        try {
            Evenement e=evenementc.recuperer_evenement_titre(titre_recup);
             titre.setText(e.getTitre());
             image.setText(e.getImage());
             description.setText(e.getDescription());
             lieu.setText(e.getLieu());
             capacite.setText(e.getCapacite()+"");
             prix.setText(e.getPrix()+"");
             
             date_debut.setValue(e.getDate_debut().toLocalDate());
             date_fin.setValue(e.getDate_fin().toLocalDate());
             combo_type.setValue(e.getType());
             image_viewer.setImage(new Image(new FileInputStream("resources/"+e.getImage()+".jpg")));
            //java.sql.Date d=java.sql.Date.valueOf(date_fin.getValue());
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
              System.out.println(ex);
          }
      } 
    }

    @FXML
    private void interface_gerer_clicked(MouseEvent event) {
        this.rafraichir();
    }

    @FXML
    private void modifier_cliked(ActionEvent event) {
      
        if( ! liste_ref.getSelectionModel().isEmpty())
        {
                String titre_recup=liste_ref.getSelectionModel().getSelectedItem();
                int ids=0;
            try {
                ids = evenementc.recuperer_evenement_titre(titre_recup).getId();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                String titre_text=titre.getText();
        String image_text=image.getText();
        String description_text=description.getText();
        String lieu_text =lieu.getText();
        String capacite_text=capacite.getText();
        String prix_text=prix.getText();
        String type_text=combo_type.getValue();
        
         boolean titre_exist=false;
        try {
             titre_exist=evenementc.titre_exist_modifier(titre_text,ids);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       
        java.sql.Date date_debut_text=java.sql.Date.valueOf(date_debut.getValue());
        java.sql.Date date_fin_text=java.sql.Date.valueOf(date_fin.getValue());
        if((titre_text.isEmpty()) || (image_text.isEmpty()) || (description_text.isEmpty()) || (lieu_text.isEmpty()) || (capacite_text.isEmpty()) 
                || (prix_text.isEmpty()) || (type_text.isEmpty()))
        {
            warn_label.setText("tous les champs doivents etre remplis");
        }
        else if(date_debut_text.compareTo(java.sql.Date.valueOf(LocalDate.now()))<=0)
        {
            warn_label.setText("date debut <= date actuel");
        }    
        else if(date_debut_text.compareTo(date_fin_text)==1)
        {
             warn_label.setText("date debut superieur a date fin");
        }
        else if(titre_exist)
        {warn_label.setText("ce titre existe");}
        
        else
        {
            
            double d_prix=Double.parseDouble(prix_text);
            int int_capacite=Integer.parseInt(capacite_text);
            
            Evenement e1=new Evenement(1,titre_text,image_text,description_text,lieu_text,int_capacite,d_prix,date_debut_text,date_fin_text,type_text);
            try {
                evenementc.modifier_evenement(e1, ids);
                this.rafraichir();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
           
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
    private void supprimer_clicked(ActionEvent event) {
        
         if( ! liste_ref.getSelectionModel().isEmpty())
        {
                
             try {
                 int ids=evenementc.recuperer_evenement_titre(liste_ref.getSelectionModel().getSelectedItem()).getId();
                 evenementc.supprimer_evenement(ids);
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
    private void rechercher_clicked(ActionEvent event) {
        
        String titre=titre_recherche.getText();
        String capacite=capacite_recherche.getText();
        String prix=prix_recherche.getText();
        String lieu=lieu_recherche.getText();
        //String a_partir=java.sql.Date.valueOf(a_partir_recherche.getValue()).toString();
        //String contenant=java.sql.Date.valueOf(contenat_recherche.getValue()).toString();
        LocalDate a_partir=a_partir_recherche.getValue();
        LocalDate contenant=contenat_recherche.getValue();
        String a_partir_chaine="";
        String contenant_chaine="";
        String description=mot_cle.getText();
        boolean non_commence_box=non_commence.isSelected();
       
        
        if(a_partir !=null)
        {
            a_partir_chaine=java.sql.Date.valueOf(a_partir).toString();
            
        }
          if(contenant !=null)
        {
            contenant_chaine=java.sql.Date.valueOf(contenant).toString();
            
        }
           List<Evenement> liste_recherche=new ArrayList<Evenement>();
          
      try {
             liste_recherche=evenementc.rechercher(titre, capacite, prix, lieu, a_partir_chaine, contenant_chaine,non_commence_box,description);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
      
   
        
       colonne1_id.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("id"));
       colonne1_titre.setCellValueFactory(new PropertyValueFactory<Evenement,String>("titre"));
       colonne_image.setCellValueFactory(new PropertyValueFactory<Evenement,String>("image"));
    colonne_description.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
    colonne_lieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieu"));
    colonne_capacite.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("capacite"));
     colonne_prix.setCellValueFactory(new PropertyValueFactory<Evenement,Double>("prix"));
     colonne_date_debut.setCellValueFactory(new PropertyValueFactory<Evenement,java.sql.Date>("date_debut"));
    
     colonne_date_fin.setCellValueFactory(new PropertyValueFactory<Evenement,java.sql.Date>("date_fin"));

       
      ObservableList<Evenement> obs=FXCollections.observableArrayList(liste_recherche);
       tableau.getItems().clear();
       tableau.setItems(obs);
        
        
    }

    @FXML
    private void rechercher_reservation_clicked(ActionEvent event) {
     
        String titrerr=rechercher_combo.getValue();
        String emailr=email_recherche_res.getText();
        
   
    boolean noncommencer= noncommence_rechercher_res.isSelected();
    
    LocalDate contenantr=date_contenat_recherche_r.getValue();
      
        String contenant_chainer="";
      
       

          if(contenantr !=null)
        {
            contenant_chainer=java.sql.Date.valueOf(contenantr).toString();
            
        }
          List<Reservation> lister=new ArrayList<Reservation>();
          
        try {
           lister=reservationc.rechercher_reservation(titrerr, emailr, noncommencer, contenant_chainer);
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
                reservationc.annuler_reservation(r.getId_reservation());
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
    private void nom_commence_box_clicked(MouseEvent event) {
        List<Modelestat> list=new ArrayList<Modelestat>(); 
        boolean non_commence=non_commence_modele.isSelected();
         boolean complet=complet_modele.isSelected();
        try {
            list=reservationc.modele_recherche(non_commence,complet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        titre_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("titre"));
       reserve_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("reserve"));
       capacite_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("capacite"));
    etat_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("etat"));
    

       
      ObservableList<Modelestat> obs_modele_1=FXCollections.observableArrayList(list);
       modele.getItems().clear();
       modele.setItems(obs_modele_1);
       
       
       
    }

    @FXML
    private void complet_box_clicked(MouseEvent event) {
        
        
          List<Modelestat> list=new ArrayList<Modelestat>(); 
        boolean non_commence=non_commence_modele.isSelected();
         boolean complet=complet_modele.isSelected();
        try {
            list=reservationc.modele_recherche(non_commence,complet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        titre_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("titre"));
       reserve_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("reserve"));
       capacite_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,Integer>("capacite"));
    etat_modele.setCellValueFactory(new PropertyValueFactory<Modelestat,String>("etat"));
    

       
      ObservableList<Modelestat> obs_modele_1=FXCollections.observableArrayList(list);
       modele.getItems().clear();
       modele.setItems(obs_modele_1);
    }

    @FXML
    private void label_model_clicked(MouseEvent event) {
        this.rafraichir();
    }

  

   
    
}
