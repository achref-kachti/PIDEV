/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packgui;

import Service.ServiceEspece;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTabPane;
import entites.Espece;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author moetez
 */
public class UserController implements Initializable {

    private TableColumn<Espece, String> col_nom1;
    private TableColumn<Espece, String> col_type1;
    private TableColumn<Espece, String> col_saison1;
     
    private TableColumn<Espece, String> col_description1;
    private TableView<Espece> Afficher_user;
    private TableColumn<Espece, String> col_mode1;
    private TableColumn<Espece, String> col_lieu1;
private ObservableList data;
    private PieChart chart;
    @FXML
    private TableView<Espece> tab_user;
    @FXML
    private TableColumn<Espece, String> col_nomuser;
    @FXML
    private TableColumn<Espece, String> col_modeuser;
    @FXML
    private TableColumn<Espece, String> col_lieuuser;
    @FXML
    private TableColumn<Espece, String> col_saisonuser;
      @FXML
    private TableColumn<Espece, String> col_descriptionuser;
    @FXML
    private JFXButton pdf;
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
       
                col_nomuser.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_modeuser.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_saisonuser.setCellValueFactory(new PropertyValueFactory<>("saison"));
                col_descriptionuser.setCellValueFactory(new PropertyValueFactory<>("description"));
            
                col_lieuuser.setCellValueFactory(new PropertyValueFactory<>("lieu"));


             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_user.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(EspeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    @FXML
    private void pdf_generate(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {
            ServiceEspece sl = new ServiceEspece();
            
            List<Espece> list = sl.PdfResLog();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
            
         
    
    }


  
    
}
