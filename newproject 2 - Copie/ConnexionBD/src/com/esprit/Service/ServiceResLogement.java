/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.ResLogement;
import com.esprit.IService.IServiceResLog;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
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
    public void ajouterRes(ResLogement t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`reservationlog`  ( `idLog`, `dateA`, `dateD`, `nbrChamb`) "
                + "VALUES ( '" + t.getIdLog() + "', '" + t.getDateA() + "', '" + t.getDateD() + "', '" + t.getNbrChamb() + "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
    
    
    public void ajouter1Res(ResLogement L) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `projet`.`reservationlog` VALUES (null, ?, ?, ?, ?);");
        pre.setInt(1, L.getIdLog());
        pre.setString(2, L.getDateA());
        pre.setString(3, L.getDateD());
        pre.setInt(4, L.getNbrChamb());
   
        System.out.println(pre.toString());
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Yaaa marra okhra");
    }
            

    @Override
    public void deleteRes(ResLogement L) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from reservationlog WHERE idReservationLog=? ;");
        pre.setInt(1, L.getIdResLog());
   
        System.out.println(pre.toString());
        pre.executeUpdate(); 
        JOptionPane.showMessageDialog(null, "supprimé");
    }

   
    
    @Override
    public void updateRes(ResLogement L) throws SQLException{
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
    
    
    
    
   /* public void rechercher(Logement L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("SELECT * from logement WHERE lieu=? ;");
        
        System.out.println(pre.toString());
        pre.executeUpdate();      
         
    }*/
    
    @Override
    public List<ResLogement> rechercherDateA(String dateAA) throws SQLException {
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
    public List<ResLogement> trierRes() throws SQLException {
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
    public List<ResLogement> readAllRes() throws SQLException {
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
    
    

}
