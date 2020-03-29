/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author moetez
 */
public class UserEspeceController implements Initializable {
    users u=new users(66 ,"yousef" ,"zghal" ,"youssef@gmail.com" ,"youssef2010" ,new java.sql.Date(97, 11, 20),99377068  );
    @FXML
    private JFXButton retour_acceuil;
    public void setUser(users user)
    {
        this.u=user;
    }
    
    private TableColumn<Espece, String> col_nom1;
    private TableColumn<Espece, String> col_type1;
    private TableColumn<Espece, String> col_saison1;
     
    private TableColumn<Espece, String> col_description1;
    private TableView<Espece> Afficher_user;
    private TableColumn<Espece, String> col_mode1;
    private TableColumn<Espece, String> col_lieu1;
private ObservableList data;
    @FXML
    private PieChart chart=new PieChart();
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
    private JFXListView<String> liste_event;
    @FXML
    private TableColumn<Espece,String> col_typeuser;
    @FXML
    private JFXCheckBox recherche_chasse;
    @FXML
    private JFXCheckBox recherche_peche;
    @FXML
    private Label cityNameLabel;
    @FXML
    private ImageView weatherGraph;
    @FXML
    private Label temperatureLabel;
    @FXML
    private TextField cityTF;
    @FXML
    private RadioButton byCity;
    @FXML
    private ToggleGroup search;
    @FXML
    private RadioButton byZipCode;
    @FXML
    private TextField prefixTF;
    @FXML
    private TextField zipCodeTF;
    @FXML
    private Button showWeatherButton;
     WeatherManager weatherManager;
    /**
     * Initializes the controller class.
     */
     public UserEspeceController(){
    		weatherManager = new WeatherManager();
    		
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        		showWeather(null);

        ServiceEspece sl = new ServiceEspece();
        List<Espece> list;
            
         try {
            list = sl.readAll();
      
            ObservableList<Espece> obs = FXCollections.observableArrayList(list); 
            
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                col_nomuser.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_typeuser.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_modeuser.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_saisonuser.setCellValueFactory(new PropertyValueFactory<>("saison"));
                
  
                col_lieuuser.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                 col_descriptionuser.setCellValueFactory(new PropertyValueFactory<>("description"));

             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_user.setItems(obs);
        } catch (SQLException ex) {
            Logger.getLogger(AdminEspeceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }


    @FXML
    private void pdf_generate(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {
            ServiceEspece sl = new ServiceEspece();
            
            List<Espece> list = sl.PdfResLog();
            ObservableList<Espece> obs = FXCollections.observableArrayList(list);
            
         
    
    }

    @FXML
    private void get_event(MouseEvent event) {
         ServiceEspece sl = new ServiceEspece();
          List<Evenement> l=new ArrayList ();
        if(! tab_user.getSelectionModel().isEmpty())
        {       String type=tab_user.getSelectionModel().getSelectedItem().getType();
             try {
                
                 l=sl.recuperer_event(type);
                 
                 
               } catch (SQLException ex) {
                 Logger.getLogger(UserEspeceController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             liste_event.getItems().clear();
             liste_event.getItems().addAll(l.stream().map(e->e.getTitre()).distinct().collect(Collectors.toList()));
         
             
             
             
             
        }
        else
        {
            tab_user.getSelectionModel().clearSelection();
           liste_event.getItems().clear();
        }
    }

    @FXML
    private void rechercher_chasse(MouseEvent event) {
        ServiceEspece se = new ServiceEspece();
                  List<Espece> list=new ArrayList();
                  String typee = null;
                  if(recherche_chasse.isSelected())
                  {
                      typee="chasse";
            try {
                se.rechercher_e(typee);
                  list = se.rechercher_e(typee);
       
            ObservableList<Espece> o = FXCollections.observableArrayList(list); 
            
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                      col_nomuser.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_typeuser.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_modeuser.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_saisonuser.setCellValueFactory(new PropertyValueFactory<>("saison"));
                
  
                col_lieuuser.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                 col_descriptionuser.setCellValueFactory(new PropertyValueFactory<>("description"));
               


             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_user.setItems(o);

             
            } catch (SQLException ex) {
                Logger.getLogger(UserEspeceController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  }
                                            //  tab_user.getItems().clear();

                 

    }

    @FXML
    private void recherche_peche(MouseEvent event) {
      ServiceEspece se = new ServiceEspece();
                  List<Espece> list=new ArrayList();
                  String typee = null;
     if(recherche_peche.isSelected())
                  {
                       typee="peche";
            try {
                se.rechercher_e(typee);
                  se.rechercher_e(typee);
                  list = se.rechercher_e(typee);
       
            ObservableList<Espece> o = FXCollections.observableArrayList(list); 
            
       /*     FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminLogement.fxml"));
               
                Parent root = loader.load();
                AdminLogementController alc = loader.getController();*/
       
                       col_nomuser.setCellValueFactory(new PropertyValueFactory<>("nom"));
                col_typeuser.setCellValueFactory(new PropertyValueFactory<>("type"));
                col_modeuser.setCellValueFactory(new PropertyValueFactory<>("mode"));
                col_saisonuser.setCellValueFactory(new PropertyValueFactory<>("saison"));
                
  
                col_lieuuser.setCellValueFactory(new PropertyValueFactory<>("lieu"));
                 col_descriptionuser.setCellValueFactory(new PropertyValueFactory<>("description"));


             
                //col_Img1.setCellValueFactory(new PropertyValueFactory<>("id"));
               
              tab_user.setItems(o);
                
            } catch (SQLException ex) {
                Logger.getLogger(UserEspeceController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  }
                   //tab_user.getItems().clear();

   
    }
    	 	
	 	
	 	
	 	void resetWeather() {
	 		cityTF.setText("Tunisia");
	 		prefixTF.setText("tn");
	 		zipCodeTF.setText("2080");
	 		showWeather(null);
	 		
	 	}
                

    @FXML
    private void showWeather(ActionEvent event) {
	try {
	 		Weather weather;
	 		if(byZipCode.isSelected()) {
	 			weather = weatherManager.getWeather(prefixTF.getText(), zipCodeTF.getText());
	 			cityNameLabel.setText("Place With a Code "+zipCodeTF.getText());
                                
	 		}
			else {
				cityNameLabel.setText(cityTF.getText());
				weather = weatherManager.getWeather(cityNameLabel.getText());
                                
			}
	 		
			temperatureLabel.setText(String.valueOf(weather.getTemperature())+(char)176+"C");
			weatherGraph.setImage(new Image("http://openweathermap.org/img/w/"+ weather.getIcon() +".png"));
	 		}catch(Exception e) {
	 			//Alert alert = new Alert(AlertType.ERROR);
	 			//alert.setTitle("City not found");
	 		/*	if(byCity.isSelected()) alert.setHeaderText("Nie znaleziono miasta o podanej nazwie.");
	 			else alert.setHeaderText("Nie znaleziono miasta o podanym kodzie pocztowym.");
	 			alert.setContentText("Sprawdź czy poprawnie wprowadziles dane. ");
 */	 			
                              //  alert.showAndWait();
               

	 			resetWeather();
    }

   

    
}

    @FXML
    private void retour_acceuil_clicked(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User_acceuil.fxml"));
          
          Parent root = loader.load();
           
             User_acceuilController apc1 = loader.getController();
             apc1.setUser(u);
       
                 retour_acceuil.getScene().setRoot(root);
    }
}




