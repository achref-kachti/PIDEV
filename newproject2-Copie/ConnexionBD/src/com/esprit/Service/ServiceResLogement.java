/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Logement;
import com.esprit.Entite.ResLogement;
import com.esprit.IService.IServiceResLog;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author House
 */
public class ServiceResLogement implements IServiceResLog<ResLogement> {

    private Connection con;
    private Statement ste;

    public ServiceResLogement() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouterResLog(ResLogement t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`reservationlog`  ( `idLog`, `dateA`, `dateD`, `nbrChamb`) "
                + "VALUES ( '" + t.getIdLog() + "', '" + t.getDateA() + "', '" + t.getDateD() + "', '" + t.getNbrChamb() + "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
    
     
    
    @Override
    public int sommeChamb(int idLogg, String dateAA, String dateDD) throws SQLException {
        //List<ResLogement> arr=new ArrayList<>();
        int S = 0;
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select sum(nbrChamb) as SommeChambreRes from reservationlog where ( (dateA BETWEEN '"+ dateAA+"' AND subdate('"+ dateDD+"',1)) OR (dateD BETWEEN adddate('"+ dateAA+"',1) AND '"+ dateDD+"') OR (dateA <= '"+ dateAA+"'  AND  dateD >= '"+ dateDD+"' )) AND (idLog = '"+ idLogg+"') ;");
        while (rs.next()) {                
               //int idReservationLog=rs.getInt("idReservationLog");
               //int idLog=rs.getInt("idLog");
               int SommeChambreRes=rs.getInt("SommeChambreRes");
                
        System.out.println(SommeChambreRes);
        S = SommeChambreRes ;
        }
        return S;
    }
    
    
    
    @Override
    public int nbrChambRestant(int idResLogg, int idLogg, String dateAA, String dateDD) throws SQLException {
        //List<ResLogement> arr=new ArrayList<>();
        int S=sommeChamb(idLogg, dateAA, dateDD);
        //int s=sommeChamb(idLogg, dateAA, dateDD);
        int NbrChambRestant = 0;
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("SELECT nbrTTchamb - S as NbrRestant from logement L inner join reservationlog RL on L.idLog = RL.idLog where RL.idReservationLog = '"+ idResLogg+"' ;");
        while (rs.next()) {                
               //int idReservationLog=rs.getInt("idReservationLog");
               //int idLog=rs.getInt("idLog");
               int NbrRestant=rs.getInt("NbrRestant");
                
        System.out.println(NbrRestant);
        NbrChambRestant = NbrRestant ;
        }
        return NbrChambRestant;
    }
    
    
    
    public void ajouter1ResLog(ResLogement L) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `projet`.`reservationlog` VALUES (null, ?, ?, ?, ?) ;");
        pre.setInt(1, L.getIdLog());
        pre.setString(2, L.getDateA());
        pre.setString(3, L.getDateD());
        pre.setInt(4, L.getNbrChamb());
   
        System.out.println(pre.toString());
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Ajouté");
    }
            

    @Override
    public void deleteResLog(ResLogement L) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from reservationlog WHERE idReservationLog=? ;");
        pre.setInt(1, L.getIdResLog());
   
        System.out.println(pre.toString());
        pre.executeUpdate(); 
        JOptionPane.showMessageDialog(null, "supprimé");
    }

   
    
    @Override
    public void updateResLog(ResLogement L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("UPDATE reservationlog SET dateA=?, dateD=?, nbrChamb=? WHERE idReservationLog=? and idLog=? ;");
        pre.setString(1, L.getDateA());
        pre.setString(2, L.getDateD());
        pre.setInt(3, L.getNbrChamb());
        pre.setInt(4, L.getIdResLog());
        pre.setInt(5, L.getIdLog());
   
        System.out.println(pre.toString());
        pre.executeUpdate(); 
        JOptionPane.showMessageDialog(null, "modifié");
         
    }
    
    
    
    
    
    @Override
    public List<ResLogement> rechercherResLogDateA(String dateAA) throws SQLException {
        List<ResLogement> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from reservationlog WHERE dateA ='"+ dateAA+"' ");
        while (rs.next()) {                
               int idReservationLog=rs.getInt("idReservationLog");
               int idLog=rs.getInt("idLog");
               String dateA=rs.getString("dateA");
               String dateD=rs.getString("dateD");
               int nbrChamb=rs.getInt("nbrChamb");
               ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb);
        arr.add(l);
        }
        return arr;
    }
    
    
    @Override
    public List<ResLogement> trierResLog() throws SQLException {
    List<ResLogement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationlog order by dateA");
     while (rs.next()) {                
               int idReservationLog=rs.getInt("idReservationLog");
               int idLog=rs.getInt("idLog");
               String dateA=rs.getString("dateA");
               String dateD=rs.getString("dateD");
               int nbrChamb=rs.getInt("nbrChamb");
               ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb);
     arr.add(l);
     }
    return arr;
    }
    
    

    @Override
    public List<ResLogement> readAllResLog() throws SQLException {
    List<ResLogement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationlog");
     while (rs.next()) {                
               int idReservationLog=rs.getInt("idReservationLog");
               int idLog=rs.getInt("idLog");
               String dateA=rs.getString("dateA");
               String dateD=rs.getString("dateD");
               int nbrChamb=rs.getInt("nbrChamb");
               ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb);
     arr.add(l);
     }
    return arr;
    }
    
    
    @Override
    public List<ResLogement> readAllAllResLog() throws SQLException {
    List<ResLogement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationlog R inner join logement L on R.idLog = L.idLog");
     while (rs.next()) {                
               int idReservationLog=rs.getInt("idReservationLog");
               int idLog=rs.getInt("idLog");
               String dateA=rs.getString("dateA");
               String dateD=rs.getString("dateD");
               int nbrChamb=rs.getInt("nbrChamb");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               int prixNuite=rs.getInt("prixNuite");
               ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb, nom, lieu, prixNuite);
     arr.add(l);
     }
    return arr;
    }
    
    
    @Override
    public List<ResLogement> PdfResLog() throws SQLException, DocumentException, FileNotFoundException {
    
    
        
        String file_name ="C:\\Users\\ASUS\\Desktop\\3A(2)\\Projet\\newproject2-Copie\\ConnexionBD\\generate_pdf\\testttt.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        
    List<ResLogement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationlog R inner join logement L on R.idLog = L.idLog");
     while (rs.next()) {                
               int idReservationLog=rs.getInt("idReservationLog");
               int idLog=rs.getInt("idLog");
               String dateA=rs.getString("dateA");
               String dateD=rs.getString("dateD");
               int nbrChamb=rs.getInt("nbrChamb");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               int prixNuite=rs.getInt("prixNuite");
               //ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb, nom, lieu, prixNuite);
               Paragraph para = new Paragraph(rs.getInt("idReservationLog")+"         "+rs.getInt("idLog")+"           "+rs.getString("dateA")+"          "+rs.getString("dateD")+"        "+rs.getInt("nbrChamb")+"        "+rs.getString("nom")+"        "+rs.getString("lieu")+"        "+rs.getInt("prixNuite"));
     document.add(para);
     document.add(new Paragraph(" "));
     //arr.add(l);
     }
    document.close();
    System.out.println("PDF");
    return arr;
    }
    

}
