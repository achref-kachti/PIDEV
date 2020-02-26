/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UserLogementController implements Initializable {

    @FXML
    private Label label_rafrichir_u;
    @FXML
    private JFXTextField tf_rechercheLieu;
    @FXML
    private JFXButton btn_rechercherLieu;
    @FXML
    private JFXCheckBox prix_u;
    @FXML
    private AnchorPane pane_reserver;
    @FXML
    private ImageView image_reserver;
    @FXML
    private JFXTextArea ta_descriptionAff;
    @FXML
    private Label prix_label;
    @FXML
    private Label lieu_label;
    @FXML
    private JFXButton btn_reserverLog;
    @FXML
    private Label lab_prixAff;
    @FXML
    private Label lab_lieuAff;
    @FXML
    private JFXDatePicker tf_reserverDateA;
    @FXML
    private JFXDatePicker tf_reserverDateD;
    @FXML
    private JFXTextField tf_reserverNbrChamb;
    @FXML
    private TableView<ResLogement> table_reservation;
    @FXML
    private JFXButton btn_rechercherRes;
    @FXML
    private JFXTextField tf_rechercheLieu1;
    @FXML
    private TableColumn<ResLogement, String> col_nom;
    @FXML
    private TableColumn<ResLogement, String> col_lieu;
    @FXML
    private TableColumn<ResLogement, String> col_prix;
    @FXML
    private TableColumn<ResLogement, String> col_dateA;
    @FXML
    private TableColumn<ResLogement, String> col_dateD;
    @FXML
    private TableColumn<ResLogement, String> col_nbrChamb;
    
                ServiceLogement sl = new ServiceLogement();
                ServiceResLogement sr = new ServiceResLogement();
                List<Logement> list;
                List<ResLogement> list_res;
    @FXML
    private Label lab_nom;
    @FXML
    private JFXListView<String> liste_nom;
    
    
    users u=new users(62 ,"yousef" ,"zghal" ,"youssef.aziz@gmail.com" ,"youssef2010" ,new java.sql.Date(97, 11, 20),99377068  );
   
    @FXML
    private JFXButton btn_supprimerRes;
    @FXML
    private JFXButton button_back_acceuill;
    
    public void setUser(users user)
    {
        this.u=user;
    }
    public void rafraichir()
   {
        
        lab_nom.setText("");
             
        ta_descriptionAff.clear();
        lab_lieuAff.setText("");
        lab_prixAff.setText("");
             
        tf_rechercheLieu.setText("");
        tf_rechercheLieu1.setText("");
          
        tf_reserverNbrChamb.setText("");
            
        image_reserver.setImage(null);
        pane_reserver.setVisible(false);
        
        
        
       /* try {
             list = sl.readAll();;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
        
        try {
            list_res = sr.readAllAllResLog(u.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

       
        try {
            liste_nom.getItems().clear();
            
            liste_nom.getItems().addAll(sl.readAll().stream().map(e->e.getNom()).collect(Collectors.toList()));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_prix.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                col_dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_dateD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_nbrChamb.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                
                ObservableList<ResLogement> obsres = FXCollections.observableArrayList(list_res);
                table_reservation.getItems().clear();
                table_reservation.setItems(obsres);
                
                prix_u.setSelected(false);
                tf_rechercheLieu.clear();
                tf_reserverDateA.setValue(LocalDate.now());
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
                
                tf_reserverDateA.setDayCellFactory(dayCellFactory);
                tf_reserverDateD.setDayCellFactory(dayCellFactory);
                tf_reserverDateD.setValue(null);

       
    }
                
                
                
                
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rafraichir();
    }    

    @FXML
    private void label_rafraichir_clicked(MouseEvent event) {
        this.rafraichir();
    }

    
    
    @FXML
    private void liste_view_user_clicked(MouseEvent event) throws SQLException, FileNotFoundException {
        if(! liste_nom.getSelectionModel().isEmpty())  
      {     String nomm=liste_nom.getSelectionModel().getSelectedItem();
           // System.out.println(nomm);
            pane_reserver.setVisible(true);
           // List<Logement> list;
            
           // Logement L=sl.recuperer_logement(id);
           Logement L = sl.recuperer_logement(nomm);
         
           //System.out.println(L);
             lab_nom.setText(L.getNom());
             lab_lieuAff.setText(L.getLieu());
             ta_descriptionAff.setText(L.getDesc());
             lab_prixAff.setText(String.valueOf(L.getPrixNuite()));
             
             
             image_reserver.setImage(new Image(new FileInputStream("resources/"+L.getImg()+".jpg")));
            //java.sql.Date d=java.sql.Date.valueOf(date_fin.getValue());
       } 
    }

    
    
    
    @FXML
    private void rechercherLieu(ActionEvent event) {
        
        pane_reserver.setVisible(false);
        String lieu=tf_rechercheLieu.getText();
        String lieu2=tf_rechercheLieu.getText();
        
        try {
            liste_nom.getItems().clear();
            liste_nom.getItems().addAll(sl.rechercherLieu(lieu,lieu2).stream().map(e->e.getNom()).collect(Collectors.toList()));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
    }

    
    
    
    @FXML
    private void prix_croissant_clicked(MouseEvent event) {
        
       /* LocalDate a_partir=a_partir_rechercheu.getValue();
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
          */
          
      if(prix_u.isSelected())
      {   
        try {
            liste_nom.getItems().clear();
            liste_nom.getItems().addAll(sl.readAll().stream().sorted((e1,e2)->(int)(e1.getPrixNuite()-e2.getPrixNuite())).map(e->e.getNom()).collect(Collectors.toList()));
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      else
      {   
             try {liste_nom.getItems().clear();
            liste_nom.getItems().addAll(sl.readAll().stream().map(e->e.getNom()).collect(Collectors.toList()));
             } catch (SQLException ex) {
                 Logger.getLogger(UserLogementController.class.getName()).log(Level.SEVERE, null, ex);
             }
      }
        
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
                                    tf_reserverDateA.getValue())
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        tf_reserverDateD.setDayCellFactory(dayCellFactory);
        //contenat_rechercheu.setValue(null);
    }

    @FXML
    private void rechercherRes(ActionEvent event) throws SQLException {
        String Lieu=tf_rechercheLieu1.getText();
        //String Lieu1=tf_rechercheLieu1.getText();
            //ServiceResLogement sl = new ServiceResLogement();
            list_res = sr.rechercherLieuRes(Lieu);
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list_res);
            
            table_reservation.getItems().clear();
                table_reservation.setItems(obs);
    }
    
    
    
    
    
    @FXML
    private void reserverLog(ActionEvent event) throws SQLException {
        
            String nomm =liste_nom.getSelectionModel().getSelectedItem();
            int idLoggg = sr.recuperer_i(nomm);
            
            String nbrChamb = tf_reserverNbrChamb.getText();
            int nbrChambL = Integer.parseInt(nbrChamb);
            String dateA = (tf_reserverDateA.getValue()).toString();
            String dateD = (tf_reserverDateD.getValue()).toString();
            
            int nbrRestant = sr.nbrChambRestant(idLoggg,dateA, dateD);
            System.out.println("nbr_rest"+nbrRestant);
          
            if(nbrRestant <= 0)
            {
                //JOptionPane.showMessageDialog(null, "No more rooms");
                Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("Logement complet");
                 alert.setHeaderText("Logement complet");
                alert.setContentText("Logement complet ");
                 alert.showAndWait();
                 System.out.println("Logement complet");
            }
            else if(nbrChambL> nbrRestant)
            {
            
                  Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("chambre insuffisant");
                 alert.setHeaderText("chabre insuffisante");
                alert.setContentText("il reste seulement"+nbrRestant);
                 alert.showAndWait();
                 System.out.println("Logement complet");
                 
            
            } 
            else
            {
            
            
            
                ResLogement R = new ResLogement(idLoggg, dateA, dateD, nbrChambL,u.getId());
                System.out.println("R=" +R);
                sr.ajouter1ResLog(R);
                this.rafraichir();
            
            
            
            
            }
            
            
            
            
            
            
            
            
            
            
            
            

            
            List<ResLogement> list=sr.readAllAllResLog();
            
            ObservableList<ResLogement> obs = FXCollections.observableArrayList(list_res);
            
       
              
                
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                col_prix.setCellValueFactory(new PropertyValueFactory<>("prixNuite"));
                col_dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
                col_dateD.setCellValueFactory(new PropertyValueFactory<>("dateD"));
                col_nbrChamb.setCellValueFactory(new PropertyValueFactory<>("nbrChamb"));
                
                table_reservation.setItems(obs);
                
                tf_reserverNbrChamb.setText("");
                //tf_reserverDateA.setText("");
                //tf_reserverDateD.setText("");
                
        
    }

    @FXML
    private void supprimerRes(ActionEvent event) {
        
      
        if(! table_reservation.getSelectionModel().isEmpty())
        {
           ResLogement R = table_reservation.getSelectionModel().getSelectedItem();
            try {
                sr.deleteResLog(R);
                //System.out.println("enntreee");
                
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
                alert.setContentText("Veuillez selectionner un element");
                 alert.showAndWait();
        }
    }

    @FXML
    private void button_back_acceuil_clicked(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("User_acceuil.fxml"));
          
          Parent root = loader.load();
           
             User_acceuilController apc1 = loader.getController();
             apc1.setUser(u);
       
                 button_back_acceuill.getScene().setRoot(root);
    }
    
    
    
    
}
