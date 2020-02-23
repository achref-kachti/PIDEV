/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guides_crud;

import Service.ServiceGuide;
import Service.ServiceReservationGuideEvent;
import Service.ServiceReservationPersonnel;
import java.sql.SQLException;
import java.util.List;
import entites.Guide;
import Utils.DataBase;
import entites.Guide;
import entites.ReservationGuideEvent;
import entites.ReservationPersonnel;
import entites.User;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mail.MailApp;

/**
 *
 * @author nature
 */
public class Guides_crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceGuide ser = new ServiceGuide();
        ServiceReservationPersonnel ser1 = new ServiceReservationPersonnel();
        ServiceReservationGuideEvent ser2 = new ServiceReservationGuideEvent();
        //Guide p1 = new Guide("eya", "ben fadhel", 10, "cite", 6);
        //Guide p2 = new Guide(23,"aaaa", "bbbbb", 10, "cite", 6);
         //Guide p3 = new Guide(30,"ayy", "jawedi", 23319951,"ariana", 0); 
           User u2= new Guide("yassine", "brahmi", 55672637, "guitoun", "azerty123","peche");
           ReservationPersonnel r1 = new ReservationPersonnel("12/10/98", "20/12/1998",15,2);
           ReservationGuideEvent rg = new ReservationGuideEvent(2, 15,"reservation");
           ReservationGuideEvent rg1 = new ReservationGuideEvent(11, 12,"reservation1");
        
        try {
           //  ser.supprimer("eya");
           //  MailApp app = new MailApp();
       // app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // app.setSize(800,400);
       // app.setVisible(true);    
           //  ser1.supprimer(2);
           // ser2.ajouter(rg1);
          //  ser2.update(rg1,5,5,"reservation1");
           // ser2.supprimer("11");
            //ser.ajouter((Guide) u2);
          //  ser1.update(r1, 70, "20/4/2010", "28/4/2010", 2);
          // ser.ajouter((Guide) u1);
         // ser.update("aaaa", "aaaaaaa", 1, "ccc", "azcccc23","cccccc");
           // List<ReservationPersonnel> list = ser1.readAll();
           List<Guide> list = ser.RECHERCHER(12);
        //  List<Guide> list = ser1.readAll();
           //System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
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
