/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Restaurant;
import com.esprit.IService.IServiceRest;
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
public class ServiceRestaurant implements IServiceRest<Restaurant> {

    private Connection con;
    private Statement ste;

    public ServiceRestaurant() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouterRest(Restaurant t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`restaurant` ( `nomRest`, `lieuRest`, `descriptionRest`, `nbrTTplace`"
                + ", `imgRest`) "
                + "VALUES ( '" + t.getNomRest() + "', '" + t.getLieuRest() + "', '" + t.getDescRest() + "', '" + t.getNbrTTplace() + "'," 
                + " '" + t.getImgRest() + "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
    
    
    public void ajouter1Rest(Restaurant L) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `projet`.`restaurant` VALUES (null ,?, ?, ?, ?, ?);");
        pre.setString(1, L.getNomRest());
        pre.setString(2, L.getLieuRest());
        pre.setString(3, L.getDescRest());
        pre.setInt(4, L.getNbrTTplace());
        pre.setString(5, L.getImgRest());
   
        System.out.println(pre.toString());
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
            

    @Override
    public void deleteRest(Restaurant L) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from restaurant WHERE idRest=? ;");
        pre.setInt(1, L.getIdRest());
   
        System.out.println(pre.toString());
        pre.executeUpdate();      
    }

   
    
    @Override
    public void updateRest(Restaurant L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("UPDATE restaurant SET nomRest=?, lieuRest=?, descriptionRest=?, nbrTTplace=?, imgRest=? WHERE idRest=? ;");
        pre.setString(1, L.getNomRest());
        pre.setString(2, L.getLieuRest());
        pre.setString(3, L.getDescRest());
        pre.setInt(4, L.getNbrTTplace());
        pre.setString(5, L.getImgRest());
        pre.setInt(6, L.getIdRest());
   
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
    public List<Restaurant> rechercherRestLieu(String lieuu) throws SQLException {
        List<Restaurant> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from restaurant WHERE lieuRest ='"+ lieuu+"' ");
        while (rs.next()) {                
               int idRest=rs.getInt("idRest");
               String nomRest=rs.getString("nomRest");
               String lieuRest=rs.getString("lieuRest");
               String descriptionRest=rs.getString("descriptionRest");
               int nbrTTplace=rs.getInt("nbrTTplace");
               String imgRest=rs.getString("imgRest");
               Restaurant l=new Restaurant(idRest, nomRest, lieuRest, descriptionRest, nbrTTplace, imgRest);
        arr.add(l);
        }
        return arr;
    }
    
    
    @Override
    public List<Restaurant> trierRestPlace() throws SQLException {
    List<Restaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from restaurant order by nbrTTplace");
     while (rs.next()) {                
               int idRest=rs.getInt("idRest");
               String nomRest=rs.getString("nomRest");
               String lieuRest=rs.getString("lieuRest");
               String descriptionRest=rs.getString("descriptionRest");
               int nbrTTplace=rs.getInt("nbrTTplace");
               String imgRest=rs.getString("imgRest");
               Restaurant l=new Restaurant(idRest, nomRest, lieuRest, descriptionRest, nbrTTplace, imgRest);
     arr.add(l);
     }
    return arr;
    }
    
    

    @Override
    public List<Restaurant> readAllRest() throws SQLException {
    List<Restaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from restaurant");
     while (rs.next()) {                
               int idRest=rs.getInt("idRest");
               String nomRest=rs.getString("nomRest");
               String lieuRest=rs.getString("lieuRest");
               String descriptionRest=rs.getString("descriptionRest");
               int nbrTTplace=rs.getInt("nbrTTplace");
               String imgRest=rs.getString("imgRest");
               Restaurant l=new Restaurant(idRest, nomRest, lieuRest, descriptionRest, nbrTTplace, imgRest);
     arr.add(l);
     }
    return arr;
    }
    
    

}
