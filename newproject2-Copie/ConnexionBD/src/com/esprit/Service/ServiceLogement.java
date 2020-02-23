/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Logement;
import com.esprit.IService.IServiceLog;
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
public class ServiceLogement implements IServiceLog<Logement> {

    private Connection con;
    private Statement ste;

    public ServiceLogement() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Logement t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`logement` ( `nom`, `lieu`, `description`, `nbrTTchamb`"
                + ", `prixNuite`, `img`) "
                + "VALUES ( '" + t.getNom() + "', '" + t.getLieu() + "', '" + t.getDesc() + "', '" + t.getNbrTTchamb() + "',"
                + " '" + t.getPrixNuite() + "', '" + t.getImg() + "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
    
    
    public void ajouter1(Logement L) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `projet`.`logement` VALUES (null ,?, ?, ?, ?, ?, ?);");
        pre.setString(1, L.getNom());
        pre.setString(2, L.getLieu());
        pre.setString(3, L.getDesc());
        pre.setInt(4, L.getNbrTTchamb());
        pre.setInt(5, L.getPrixNuite());
        pre.setString(6, L.getImg());
   
        System.out.println(pre.toString());
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
            

    @Override
    public void delete(Logement L) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from logement WHERE idLog=? ;");
        pre.setInt(1, L.getIdLog());
   
        System.out.println(pre.toString());
        pre.executeUpdate();   
        JOptionPane.showMessageDialog(null, "supprimé");
    }

   
    
    @Override
    public void update(Logement L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("UPDATE logement SET nom=?, lieu=?, description=?, nbrTTchamb=?, prixNuite=?, img=? WHERE idLog=? ;");
        pre.setString(1, L.getNom());
        pre.setString(2, L.getLieu());
        pre.setString(3, L.getDesc());
        pre.setInt(4, L.getNbrTTchamb());
        pre.setInt(5, L.getPrixNuite());
        pre.setString(6, L.getImg());
        pre.setInt(7, L.getIdLog());
   
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
    public List<Logement> rechercherLieu(String nomm, String lieuu, String descriptionn) throws SQLException {
        List<Logement> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from logement WHERE nom ='"+ nomm+"' OR lieu ='"+ lieuu+"' OR description ='"+ descriptionn+"' ");
        while (rs.next()) {                
               int idLog=rs.getInt("idLog");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               String description=rs.getString("description");
               int nbrTTchamb=rs.getInt("nbrTTchamb");
               int prixNuite=rs.getInt("prixNuite");
               //String img=rs.getString("img");
               Logement l=new Logement(idLog, nom, lieu, description, nbrTTchamb, prixNuite);
        arr.add(l);
        }
        return arr;
    }
    
    
    @Override
    public List<Logement> trier() throws SQLException {
    List<Logement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from logement order by nbrTTchamb");
     while (rs.next()) {                
               int idLog=rs.getInt("idLog");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               String description=rs.getString("description");
               int nbrTTchamb=rs.getInt("nbrTTchamb");
               int prixNuite=rs.getInt("prixNuite");
               String img=rs.getString("img");
               Logement l=new Logement(idLog, nom, lieu, description, nbrTTchamb, prixNuite, img);
     arr.add(l);
     }
    return arr;
    }
    
    
    @Override
    public List<Logement> trierLieu() throws SQLException {
    List<Logement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from logement order by lieu");
     while (rs.next()) {                
               int idLog=rs.getInt("idLog");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               String description=rs.getString("description");
               int nbrTTchamb=rs.getInt("nbrTTchamb");
               int prixNuite=rs.getInt("prixNuite");
               String img=rs.getString("img");
               Logement l=new Logement(idLog, nom, lieu, description, nbrTTchamb, prixNuite, img);
     arr.add(l);
     }
    return arr;
    }
    
    

    @Override
    public List<Logement> readAll() throws SQLException {
    List<Logement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from logement");
     while (rs.next()) {                
               int idLog=rs.getInt("idLog");
               String nom=rs.getString("nom");
               String lieu=rs.getString("lieu");
               String description=rs.getString("description");
               int nbrTTchamb=rs.getInt("nbrTTchamb");
               int prixNuite=rs.getInt("prixNuite");
               //String img=rs.getString("img");
               Logement l=new Logement(idLog, nom, lieu, description, nbrTTchamb, prixNuite);
     arr.add(l);
     }
    return arr;
    }

    
    
    

}
