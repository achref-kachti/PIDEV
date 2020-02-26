/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nature
 */
public class ModifController implements Initializable {
   @FXML
   private TextField tf_nom_modif;
   @FXML
   private TextField tf_prenom_modif;
    @FXML
    private TextField tf_telephone_modif;
    @FXML
    private TextField tf_adresse_modif;
     @FXML
    private TextField tf_password_modif;

   
    @FXML
    private Button btn_update;
    private CheckBox chassebox;
    private CheckBox pechebox;
    @FXML
    private JFXCheckBox chasse;
    @FXML
    private JFXCheckBox peche;
    @FXML
    private Button btn_return;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
   @FXML
    private void handlechasseBox() {
        if(chasse.isSelected()) {
           peche.setSelected(false);
             
             }
        
    }
   @FXML
    private void handlepecheBox() {
        if(peche.isSelected()) {
            chasse.setSelected(false);
         
             
             }
        
    }

    @FXML
    private void update_gui(ActionEvent event) throws SQLException {
          ServiceGuide sp = new ServiceGuide();
         String nomG = tf_nom_modif.getText();
            String prenomG = tf_prenom_modif.getText();
            String adresseG = tf_adresse_modif.getText();
            String telephoneG = tf_telephone_modif.getText();
            int tlf =Integer.parseInt(telephoneG);
             String passwordG = tf_password_modif.getText();
             String specialite = null;
              if(chasse.isSelected()) {
           specialite="chasse";
             }
              if(peche.isSelected()) {
           specialite="peche";
             }
             
        
        
        
       
        sp.update(nomG,prenomG,tlf,adresseG,passwordG,specialite);
        JOptionPane.showMessageDialog(null, "Guide modifié avec succes !");
           
        
          
        }
    
    void setTf_nom_modif(TextField tf_nom_modif) {
     
           this.tf_nom_modif.setText(tf_nom_modif.getText());
    }

    void setTf_prenom_modif(TextField tf_prenom_modif) {
       this.tf_prenom_modif.setText(tf_prenom_modif.getText());
    }

    void setTf_password_modif(TextField tf_password_modif) {
            this.tf_password_modif.setText(tf_password_modif.getText());
    }

    void setTf_adresse_modif(TextField tf_adresse_modif) {
       this.tf_adresse_modif.setText(tf_adresse_modif.getText());
    }
    void setTf_telephone_modif(TextField tf_telephone_modif) {
       this.tf_telephone_modif.setText(tf_telephone_modif.getText());
    }

    @FXML
    private void return_to_acc(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_1.fxml"));
            
                Parent root = loader.load();
              Admin_1Controller apc = loader.getController();
               
               btn_return.getScene().setRoot(root);
        
    }
    }
    
   
    

    