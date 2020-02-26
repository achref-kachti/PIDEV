/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author House
 */
public class ServiceResRestaurant implements IServiceResRest<ResRestaurant> {

    private Connection con;
    private Statement ste;

    public ServiceResRestaurant() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouterResRest(ResRestaurant t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`reservationrest`  ( `idRest`, `dateR`, `nbrPlace`) "
                + "VALUES ( '" + t.getIdRest() + "', '" + t.getDateR() + "', '" + t.getNbrPlace() + "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Yaaa");
    }
    
    
    public void ajouter1ResRest(ResRestaurant L) throws SQLException
    {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `projet`.`reservationrest` VALUES (null, ?, ?, ?);");
        pre.setInt(1, L.getIdRest());
        pre.setString(2, L.getDateR());
        pre.setInt(3, L.getNbrPlace());
   
        System.out.println(pre.toString());
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Yaaa marra okhra");
    }
            

    @Override
    public void deleteResRest(ResRestaurant L) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement pre=con.prepareStatement("DELETE from reservationrest WHERE idReservationRest=? ;");
        pre.setInt(1, L.getIdResRest());
   
        System.out.println(pre.toString());
        pre.executeUpdate(); 
        JOptionPane.showMessageDialog(null, "supprimé");
    }

   
    
    @Override
    public void updateResRest(ResRestaurant L) throws SQLException{
        PreparedStatement pre=con.prepareStatement("UPDATE reservationrest SET dateR=?, nbrPlace=? WHERE idReservationRest=? and idRest=? ;");
        pre.setString(1, L.getDateR());
        pre.setInt(2, L.getNbrPlace());
        pre.setInt(3, L.getIdResRest());
        pre.setInt(4, L.getIdRest());
   
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
    public List<ResRestaurant> rechercherResRestDateR(String dateRR) throws SQLException {
        List<ResRestaurant> arr=new ArrayList<>();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select * from reservationrest WHERE dateR ='"+ dateRR+"' ");
        while (rs.next()) {                
               int idReservationRest=rs.getInt("idReservationRest");
               int idRest=rs.getInt("idRest");
               String dateR=rs.getString("dateR");
               int nbrPlace=rs.getInt("nbrPlace");
               ResRestaurant l=new ResRestaurant(idReservationRest, idRest, dateR, nbrPlace);
        arr.add(l);
        }
        return arr;
    }
    
    
    @Override
    public List<ResRestaurant> trierResRest() throws SQLException {
    List<ResRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationrest order by dateR");
     while (rs.next()) {                
               int idReservationRest=rs.getInt("idReservationRest");
               int idRest=rs.getInt("idRest");
               String dateR=rs.getString("dateR");
               int nbrPlace=rs.getInt("nbrPlace");
               ResRestaurant l=new ResRestaurant(idReservationRest, idRest, dateR, nbrPlace);
     arr.add(l);
     }
    return arr;
    }
    
    

    @Override
    public List<ResRestaurant> readAllResRest() throws SQLException {
    List<ResRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationrest");
     while (rs.next()) {                
               int idReservationRest=rs.getInt("idReservationRest");
               int idRest=rs.getInt("idRest");
               String dateR=rs.getString("dateR");
               int nbrPlace=rs.getInt("nbrPlace");
               ResRestaurant l=new ResRestaurant(idReservationRest, idRest, dateR, nbrPlace);
     arr.add(l);
     }
    return arr;
    }
    
    
    @Override
    public List<ResRestaurant> readAllAllResRest() throws SQLException {
    List<ResRestaurant> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reservationrest RR inner join restaurant R on RR.idRest = R.idRest");
     while (rs.next()) {                
               int idReservationRest=rs.getInt("idReservationRest");
               int idRest=rs.getInt("idRest");
               String dateR=rs.getString("dateR");
               int nbrPlace=rs.getInt("nbrPlace");
               String nomRest=rs.getString("nomRest");
               String lieuRest=rs.getString("lieuRest");
               ResRestaurant l=new ResRestaurant(idReservationRest, idRest, dateR, nbrPlace, nomRest, lieuRest);
     arr.add(l);
     }
    return arr;
    }
    

}
