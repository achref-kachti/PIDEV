/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author House
 */
public class AffichePersonneController implements Initializable {

    @FXML
    private TextField resNom;
    @FXML
    private TextField resPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setResNom(TextField resNom) {
        this.resNom.setText(resNom.getText());
    }

    public void setResPrenom(TextField resPrenom) {
        this.resPrenom.setText(resPrenom.getText());
    }
    
    
}
