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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public void delete1(String nom) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from logement WHERE nom= '" +nom+ "' ;");
        //pre.setInt(1, L.getIdLog());
    pre.execute();
        //System.out.println(pre.toString());
        //pre.executeUpdate();   
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
    
    public int updateed(String nomm, String nom ,String lieu ,String description,int nbTTchamb ,int prix ,String img) throws SQLException
    {
         int res=-1;
         PreparedStatement prepare=con.prepareStatement("UPDATE `logement` SET nom=?, lieu=?, description=?, nbrTTchamb=?, prixNuite=?, img=? WHERE nom='"+nomm+"'; ");
    
         
        prepare.setString(1, nom);
        prepare.setString(2, lieu);
        prepare.setString(3, description);
            prepare.setInt(4, nbTTchamb);
       
        prepare.setInt(5, prix);
        prepare.setString(6, img);
       


        res=prepare.executeUpdate();
       
        return res;
    }
    
    
    
    
   /* public void rechercher(Logement L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("SELECT * from logement WHERE lieu=? ;");
        
        System.out.println(pre.toString());
        pre.executeUpdate();      
         
    }*/
    
    @Override
    public List<Logement> rechercherLieu(String nomm, String lieuu) throws SQLException {
        List<Logement> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from logement WHERE nom ='"+ nomm+"' OR lieu ='"+ lieuu+"'  ");
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

    
    public boolean nom_exist(String nom) throws SQLException
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
             
                   ste=con.createStatement();
                    result=ste.executeQuery("select * from logement where nom='"+nom+"'");
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
           return exist;   
        
     }
    
    
    @Override
    public Logement recuperer_logement(String nom) throws SQLException
     {
               ResultSet result=null;
               Logement L=new Logement();
                
               
              ste=con.createStatement();
    result=ste.executeQuery("select * from logement where logement.nom = '" +nom+ "' ;");
       
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    L=new Logement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getInt(5)  ,result.getInt(6),result.getString(7));
              
              }
              
              
              return L;
    }
    
    
    
    

}
