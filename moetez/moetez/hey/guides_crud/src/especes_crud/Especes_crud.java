/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package especes_crud;

import Maps.Maps;
import Service.ServiceEspece;
import java.sql.SQLException;
import java.util.List;
import entites.Espece;
import Utils.DataBase;
import entites.Espece;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author nature
 */
public class Especes_crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        	/*final Maps example = new Maps("test");
		example.generateMarker(Maps.getCenter());
		*/
        try {
            ServiceEspece ser = new ServiceEspece();
            
            
            //Espece u2= new Espece("yassine", "brahmi", "guitoun", "azerty","kk","kk");
            
            //  ser.ajouter(u2);
          //  ser.update("arnouub","fsfsf","reservation","fff","ddd","fff");
            System.out.println(ser.recuperer_event("chasse"));
           List<Espece> list = ser.rechercher_e("chasse");
            //  ser.supprimer("eya");
            //  MailApp app = new MailApp();
            // app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // app.setSize(800,400);
            // app.setVisible(true);
            //  ser1.supprimer(2);
            // ser2.ajouter(rg1);
            //
            // ser2.supprimer("11");
            //ser.ajouter((Guide) u2);
            //  ser1.update(r1, 70, "20/4/2010", "28/4/2010", 2);
            // ser.ajouter((Guide) u1);
            // ser.update("aaaa", "aaaaaaa", 1, "ccc", "azcccc23","cccccc");
            // List<ReservationPersonnel> list = ser1.readAll();
            
            //  List<Guide> list = ser1.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            Logger.getLogger(Especes_crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author House
 */
