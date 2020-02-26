/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FXMLuserController implements Initializable {
    userService userc=new userService();
    @FXML
    private JFXPasswordField password_user;
    @FXML
    private JFXTextField email_user;
    @FXML
<<<<<<< HEAD
=======
    private JFXButton acceder_user;
    @FXML
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
    private AnchorPane int_creer;
    @FXML
    private JFXTextField last_name;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXDatePicker birthday;
    @FXML
    private JFXTextField tel;
    @FXML
<<<<<<< HEAD
=======
    private JFXButton creer_compte;
    @FXML
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
    private JFXTextField name;
    @FXML
    private Label warn_label_compte;
    @FXML
<<<<<<< HEAD
    private JFXButton acceder_user;
    @FXML
    private JFXButton creer_compte;
    @FXML
=======
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
    private JFXButton creer_button1;
    
    public void rafraichir()
    {
        tel.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.matches("\\d{0,8}?")) {
            tel.setText(oldValue);
            }
            }
            });
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isAfter(
                                    LocalDate.now().minusYears(18))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        name.clear();
        last_name.clear();
        mail.clear();
        password.clear();
        birthday.setValue(LocalDate.now().minusYears(18));
        birthday.setDayCellFactory(dayCellFactory);
        tel.clear();
        warn_label_compte.setText("");
        int_creer.setVisible(false);
        
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.rafraichir();
    }    

    @FXML
    private void acceder_clicked(ActionEvent event) throws IOException  {
        
        String email=email_user.getText();
        String password=password_user.getText();
        users u=new users();
        boolean exist=false;
        try {
            exist=userc.user_exit(password, email);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        if((email.equals("admin@gmail.com")) && password.equals("admin"))
        {
<<<<<<< HEAD
              FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_acceuil.fxml"));
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
             Parent root = loader.load();
             Admin_acceuilController apc = loader.getController();
             //FXMLDocumentController apc = loader.getController();
             //Admin_1Controller apc = loader.getController();
=======
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             //FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
             Parent root = loader.load();
             FXMLDocumentController apc = loader.getController();
            // Admin_1Controller apc = loader.getController();
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
                 email_user.getScene().setRoot(root);
             
        
        }
        else if(exist==true)
        {
            System.out.println("user normal existant");
            try {
                u=userc.recuperer_user_email(email);
<<<<<<< HEAD
                 //FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("User_acceuil.fxml"));
             Parent root = loader.load();
             //FXMLController iuser_c = loader.getController();
             User_acceuilController iuser_c = loader.getController();
             iuser_c.setUser(u);
             // iuser_c.rafraichir();
=======
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
             Parent root = loader.load();
             FXMLController iuser_c = loader.getController();
             iuser_c.setUser(u);
             iuser_c.rafraichir();
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
             
                 email_user.getScene().setRoot(root);
             
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("Utilisateur");
                 alert.setHeaderText("utilisateur inexistant");
                alert.setContentText("svp verifierz vos données");
                 alert.showAndWait();
        
        }
         
        
          
        }

    @FXML
    private void creer_compte(ActionEvent event) {
        String nom=name.getText();
        String prenom=last_name.getText();
        String email=mail.getText();
        String pass=password.getText();
        java.sql.Date date_naissance=java.sql.Date.valueOf(birthday.getValue());
        String telephone=tel.getText();
        boolean email_exist=false;
        boolean telephone_exist=false;
        try {
             email_exist=userc.afficher_users().stream().anyMatch(u->u.getEmail().equals(email));
            telephone_exist=userc.afficher_users().stream().anyMatch(u->String.valueOf(u.getTelephone()).equals(telephone));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLuserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if((nom.isEmpty()) ||(prenom.isEmpty())||(email.isEmpty())||(pass.isEmpty())||(telephone.isEmpty()))
        {
            warn_label_compte.setText("valider tous champs");
        }
        else if(!email.contains("@"))
        {
             warn_label_compte.setText("email invalide");
        }
         else if(email_exist)
        {
             warn_label_compte.setText("cet email existe deja");
        }
         else if(telephone_exist)
        {
             warn_label_compte.setText("ce numero existe deja");
        }
        else
         {
            try {
                users user=new users(1,nom,prenom,email,pass,date_naissance,Integer.valueOf(telephone));
                userc.add_user(user);
                this.rafraichir();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLuserController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         }
        
        
    }

    @FXML
    private void creer_compte1(ActionEvent event) {
        if(int_creer.isVisible()==false)
        {
            this.rafraichir();
            int_creer.setVisible(true);}
        else
                {int_creer.setVisible(false);}
    }
<<<<<<< HEAD



=======
>>>>>>> 9a7e7bbd8bfb0003bc2fe51d365b75c28be148f6
    
    
    
}
