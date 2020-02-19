/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Logement;
import com.esprit.Entite.ResLogement;
import com.esprit.Entite.ResRestaurant;
import com.esprit.Entite.Restaurant;
import com.esprit.Service.ServiceLogement;
import com.esprit.Service.ServiceResLogement;
import com.esprit.Service.ServiceResRestaurant;
import com.esprit.Service.ServiceRestaurant;
import com.esprit.Utils.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) throws DocumentException, FileNotFoundException{
        
        ServiceLogement ser = new ServiceLogement();
        
        Logement L1 = new Logement(2,"ashref", "tunis", "foot", 85, 45, "mp");
        Logement L2 = new Logement("shkoon", "uuu", "lala", 2, 55, "ytd");
        //Logement L3 = new Logement(3,"ss", "sssef", "ffrfr", 55, 220, "dcedd");
        Logement L3 = new Logement(8);
        Logement L4 = new Logement("EsperanceDeTunis", "greencity", "hdg", 23, 45, "png");
       
        
        ServiceResLogement ser1 = new ServiceResLogement();
        
        ResLogement RL1 = new ResLogement(6, 5, "2018-07-20", "2020-08-25", 6);
        ResLogement RL2 = new ResLogement(4, "2020-11-25", "2020-12-02", 2);
        ResLogement RL3 = new ResLogement(2, "2020-10-20", "2020-10-26", 50);
        ResLogement RL4 = new ResLogement(3);
        ResLogement RL5 = new ResLogement(1);
        
        
        ServiceRestaurant ser2 = new ServiceRestaurant();
        
        Restaurant R1 = new Restaurant("edd", "marsa", "m", 200, "opp");
        Restaurant R2 = new Restaurant("mammamia", "uu", "luu", 23, "gt");
        Restaurant R3 = new Restaurant(4);
        Restaurant R4 = new Restaurant(2, "szszd", "greencity", "fki",75, "dng");
        
        
        ServiceResRestaurant ser3 = new ServiceResRestaurant();
        
        ResRestaurant RR1 = new ResRestaurant(5, "2018-01-15", 4);
        ResRestaurant RR2 = new ResRestaurant(4, 5, "2019-12-02", 1);
        ResRestaurant RR3 = new ResRestaurant(3, "2020-06-01", 2);
        ResRestaurant RR4 = new ResRestaurant(5);
        
        
        try {
            
    /*     String file_name ="C:\\Users\\ASUS\\Desktop\\3A(2)\\Projet\\test.pdf";
            Document document = new Document();
            
            //Simple paragraph
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();                                                     */
           /* Paragraph para = new Paragraph("SHKOON");
            document.add(para);*/
            
            
            
            
           /* document.close(); 
            
            System.out.println("PDF"); */
//Logement        
       //   ser.ajouter1(L4);
            //ser.ajouter(L1);
            
             List<Logement> list = ser.readAll();
             System.out.println(list);
            
            //List<Logement> list = ser.trier();
            //System.out.println(list);
            
            //ser.update(L1);
            //ser.delete(L3);
            
            //List<Logement> list = ser.rechercherLieu("srilanka");
            //System.out.println(list);
            
            
            
//ReservationLogement
            //ser1.ajouterResLog(RL1);
            //ser1.ajouter1ResLog(RL3);
            
            //List<ResLogement> list = ser1.readAllResLog();
            //System.out.println(list);
           
            //List<ResLogement> list = ser1.trierResLog();
            //System.out.println(list);
           
            //ser1.updateResLog(RL1);
            //ser1.deleteResLog(RL4);
            
            //List<ResLogement> list = ser1.rechercherResLogDateA("2020-10-20");
            //System.out.println(list);
            
            //List<ResLogement> list = ser1.readAllAllResLog();
            //System.out.println(list);
            
            //ser1.sommeChamb(2,"2020-10-20", "2020-10-26");
            //ser1.nbrChambRestant(1,2,"2020-10-20", "2020-10-26");
            
            
            //ser1.nbrChambRestant(6);
            
            
         //   List<ResLogement> list = ser1.PdfResLog();
        //    System.out.println(list);

//Restaurant     
            //ser2.ajouterRest(R1);
            //ser2.ajouter1Rest(R2);
            
            //List<Restaurant> list = ser2.readAllRest();
            //System.out.println(list);
            
            //List<Restaurant> list = ser2.trierRestPlace();
            //System.out.println(list);
            
            //ser2.updateRest(R4);
            //ser2.deleteRest(R3);
            
            //List<Restaurant> list = ser2.rechercherRestLieu("marsa");
            //System.out.println(list);
            
            //List<Restaurant> list = ser2.readAllRest();
            //System.out.println(list);


            
            
//ReservationRestaurant
            //ser3.ajouterResRest(RR1);
            //ser3.ajouter1ResRest(RR3);
            
            //List<ResRestaurant> list = ser3.readAllResRest();
            //System.out.println(list);
           
            //List<ResRestaurant> list = ser3.trierResRest();
            //System.out.println(list);
           
            //ser3.updateResRest(RR2);
            //ser3.deleteResRest(RR4);
            
            //List<ResRestaurant> list = ser3.rechercherResRestDateR("2019-12-02");
            //System.out.println(list);
            
            //List<ResRestaurant> list = ser3.readAllAllResRest();
            //System.out.println(list);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            //System.err.println(ex);
        }
        //ex.printStackTrace();
        //ex.printStackTrace();
        
    }
    
}