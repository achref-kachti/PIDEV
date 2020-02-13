/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Logement;
import com.esprit.Entite.ResLogement;
import com.esprit.Service.ServiceLogement;
import com.esprit.Service.ServiceResLogement;
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
        ServiceLogement ser = new ServiceLogement();
        
        Logement l1 = new Logement(2,"ashref", "tunis", "foot", 85, 45, "mp");
        Logement l2 = new Logement("shkoon", "uuu", "lala", 2, 55, "ytd");
        //Logement l3 = new Logement(3,"ss", "sssef", "ffrfr", 55, 220, "dcedd");
        Logement l3 = new Logement(8);
        Logement l4 = new Logement("EsperanceDeTunis", "greencity", "hdg", 23, 45, "png");
        
        
        ServiceResLogement ser1 = new ServiceResLogement();
        
        ResLogement R1 = new ResLogement(6, 5, "2018-07-20", "2020-08-25", 6);
        ResLogement R2 = new ResLogement(4, "2020-11-25", "2020-12-02", 2);
        ResLogement R3 = new ResLogement(5, "2020-05-05", "2020-06-01", 2);
        ResLogement R4 = new ResLogement(3);
        
        
        try {
//Logement        
            //ser.ajouter1(l4);
            //ser.ajouter(l1);
            
            // List<Logement> list = ser.readAll();
            //System.out.println(list);
            
            //List<Logement> list = ser.trier();
            //System.out.println(list);
            
            //ser.update(l1);
            //ser.delete(l3);
            
            //List<Logement> list = ser.rechercherLieu("srilanka");
            //System.out.println(list);
            
            
            
//Reservation
            //ser1.ajouterRes(R1);
            //ser1.ajouter1Res(R3);
            
           // List<ResLogement> list = ser1.readAllRes();
           // System.out.println(list);
           
           // List<ResLogement> list = ser1.trierRes();
           // System.out.println(list);
           
            //ser1.updateRes(R1);
            //ser1.deleteRes(R4);
            
            List<ResLogement> list = ser1.rechercherDateA("2020-10-20");
            System.out.println(list);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}