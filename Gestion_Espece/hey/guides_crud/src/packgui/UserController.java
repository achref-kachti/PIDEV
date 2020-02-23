/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import Service.ServiceEspece;
import entites.Espece;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author moetez
 */
public class UserController implements Initializable {

    @FXML
    private ImageView img_co;
    @FXML
    private Button btn_weather;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
        try {
            list = sl.readAll();
       
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_saison.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_especes.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(EspeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    
    public void 
    
}
