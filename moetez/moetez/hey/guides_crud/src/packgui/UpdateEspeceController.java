/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import Service.ServiceEspece;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entites.Espece;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author moetez
 */
public class UpdateEspeceController implements Initializable {

    @FXML
    private JFXTextField m_nom;
    @FXML
    private JFXCheckBox m_chasse;
    @FXML
    private JFXCheckBox m_peche;

    
    ObservableList<String> data = FXCollections.observableArrayList("text1", "text2", "text3");
     @FXML
    private JFXComboBox<String> m_mode= new JFXComboBox<>(data);
    @FXML
    private JFXTextField m_lieu;
    @FXML
    private JFXTextField m_saison;
    @FXML
    private JFXTextArea m_description;
    @FXML
    private JFXButton btn_modifierEsp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        m_mode.setItems(data);
        // TODO
    }    

    @FXML
    private void modifier_especeEsp(ActionEvent event) {
            String nom = m_nom.getText();
            
            String saison = m_saison.getText();
            String description = m_description.getText();
            String lieu = m_lieu.getText();
           String type=null;
           if(m_chasse.isSelected())
           {
               type="chasse" ;
           }
           if(m_peche.isSelected())
           {
               type="peche";
           }
           
           String mode=m_mode.getSelectionModel().getSelectedItem();
          ServiceEspece sp = new ServiceEspece();
         sp.update(nom,type, mode, lieu, saison,description);
        JOptionPane.showMessageDialog(null, "Espece modifié avec succes !");
        
          
    }
/*
    private void supprimer_espece(ActionEvent event)throws IOException,SQLException {
        FXMLLoader loader = new FXMLLoader
                      (getClass()
                        .getResource("Espe.fxml"));
         ServiceEspece sp = new ServiceEspece();
  //           String nom=tf_nom_supp.getText();
    //        sp.supprimer(nom);
            JOptionPane.showMessageDialog(null, "Espéce supprimé avec succes !");
                List<Espece >list = sp.readAll();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
           
      
               
               Parent root = loader.load();
                EspeController alc = loader.getController();
             col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
                
             
               
                tab_especes.setItems(obs);
               
               
        //           t_no.setText("");
      //          t_type.setText("");
                t_saison.setText("");
                t_desc.setText("");
    }
    */

    
    public void setM_nom(JFXTextField m_nom) {
        
        this.m_nom.setText(m_nom.getText());
        

    }

    public void setM_chasse(JFXCheckBox m_chasse) {
    
         this.m_chasse.setText(m_chasse.getText());
    }

    public void setM_peche(JFXCheckBox m_peche) {
         this.m_peche.setText(m_peche.getText());
    }

    public void setM_mode(JFXComboBox<String> m_mode) {
      this.m_peche.setText(m_peche.getText());
    }

    public void setM_lieu(JFXTextField m_lieu) {
        this.m_lieu.setText(m_lieu.getText());
    }

    public void setM_saison(JFXTextField m_saison) {
      this.m_saison.setText(m_saison.getText());
    }

    public void setM_description(JFXTextArea m_description) {
          this.m_description.setText(m_description.getText());
    }
}
