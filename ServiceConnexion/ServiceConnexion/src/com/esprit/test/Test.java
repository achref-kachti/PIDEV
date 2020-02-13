/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Stock;
import com.esprit.Service.ServiceStock;
import com.esprit.Entite.Panier;
import com.esprit.Service.ServicePanier;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) {
   /*Test Stock***************************************************************/
        ServiceStock ser = new ServiceStock();
        Stock  s1 = new Stock (1,"fusil", 1, "un fusil","vente", 200, 10);
        Stock  s2 = new Stock (2,"canne a peche", 2, "un canne a peche ","location", 100, 300);
        Stock  s3 = new Stock (4,"Hamecon", 2, "un hamecon pour poissons","vente", 160, 900);
        
        ServicePanier serv = new ServicePanier();
        Panier  p1 = new Panier (1, 1, 200, "cartouches",50, 250,"vente");
        Panier  p2 = new Panier (2, 2, 190, "appats",20, 1000,"vente");
        Panier  p3 = new Panier (3, 3, 200, "tenue",25, 40,"location");
        try{
       
        /*ajout*/

            //ser.ajoutermat(s1);
            //ser.ajoutermat(s2);
            //ser.ajoutermat(s3);
            
        /*suppression*/
            
            // ser.supprimermat(s3);
            // ser.delete_mat(4);
             
        /*modification*/
            
           // ser.modifiermat(s2,1);// thot le nom, categorie,.. mtaa l s2 fel materiel li indice mteeou 1
            
        /*affichage*/
            
            List<Stock> list1 = ser.afficherlistemat();
            System.out.println(list1);
            
            
        /*recherche*/
            
          //  List<Stock> list2 = ser.recherchemat("3");
          //  System.out.println(list2);
            
            
        /*tri*/
            
          //  List<Stock> list3 = ser.triermat();
           //System.out.println(list3);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  /*Test Panier**************************************************************************/
       
         
         try{
        /*ajout*/

           // serv.ajouterach(p1);
          //  serv.ajouterach(p2);
           // serv.ajouterach(p3); 
            
        /*suppression*/
            
          //serv.supprimerach(p3);
           
             
        /*modification*/
            
           // serv.modifierach(p2,1);// thot le nom, categorie,.. mtaa  p2 fel panier li indice mteeou 1
            
        /*affichage*/
            
            List<Panier> list4 = serv.afficherlisteach();
            System.out.println(list4);
            
            
        /*recherche*/
            
           // List<Panier> list5 = serv.rechercheach("25");
           // System.out.println(list5);
            
            
        /*tri*/
            
            //List<Panier> list6 = serv.trierach();
           //System.out.println(list6);
           
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
