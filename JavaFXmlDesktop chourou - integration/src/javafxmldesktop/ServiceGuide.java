/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;


import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import javafxmldesktop.DataBase;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author House
 */
public class ServiceGuide implements IGuide<Guide>
{

    private Connection con;
    private Statement ste;

    public ServiceGuide() {
        con = DataBase.getInstance().getConnection();

    }

    /* ajout */
    @Override
    public void ajouter(Guide g) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO guides (`id`, `nom`, `prenom`, `telephone`, `adresse`, `password`, `specialite`) "
                + "VALUES (NULL, '" + g.getNom() + "', '" + g.getPrenom() + "', '" + g.getTelephone() + "', '" + g.getAdresse() + "', '" + g.getPassword() + "', '"+g.getSpecialite()+"');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "guide ajouté avec succes");
    }
  
     /* update */
    @Override
    public void update(String nomm,String prenom, int telephone ,String adresse,String password,String specialite) {
        try{
        PreparedStatement pt=con.prepareStatement("UPDATE guides SET `prenom` = ? , `telephone` = ? , `adresse` = ? , `password` = ? , `specialite` = ? where `nom` = '" + nomm + "' ;");
      
        pt.setString(1,prenom);
        pt.setInt(2,telephone);
        pt.setString(3,adresse);
        pt.setString(4,password);
        pt.setString(5,specialite);
       
        pt.execute();
        }catch (SQLException ex)
        {
            Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);
        }
       
        
              
              
              
          }
    /* suppression */
    @Override
    public void supprimer(String nomm)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `guides` WHERE `guides`.`nom` = '" + nomm + "' ;" );
          
          pt.execute();
      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    
    }
      public int recuperer_i(String t)throws SQLException {
    int arr = 0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select  guides.id from  guides where guides.nom = '"+t+"' ;");
     
    while (rs.next()) {                
           int id =rs.getInt("id");
   
            arr=id;
     }
    return arr;
    }
     public void supprimer_id(int id)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `guides` WHERE `guides`.`id` = '" + id + "' ;" );
          
          pt.execute();
                      JOptionPane.showMessageDialog(null, "guide supprimé avec succes");

      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    
    }
    
    /*tri */
    @Override
      public List<Guide> trier() throws SQLException {
    List<Guide> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from guides order by id desc");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String adresse=rs.getString("adresse");
               int telephone;
        telephone = rs.getInt("telephone");
               String password;
        password = rs.getString("password");
               String specialite=rs.getString("specialite");
               Guide p=new Guide(id, nom, prenom, telephone, adresse, password, specialite);
     arr.add(p);
     }
    return arr;
    }
     
      /* recherche */
    
          

    /**
     *
     * @return
     * @throws SQLException
     */
      /*    Affichage   */
    @Override
    public List<Guide> readAll() throws SQLException {
    List<Guide> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from guides");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String adresse=rs.getString("adresse");
                String specialite=rs.getString("specialite");
               String password ;
        password = rs.getString("password");
               int telephone=rs.getInt("telephone");
               Guide p=new Guide(id, nom, prenom, telephone, adresse, password, specialite);
     arr.add(p);
     }
    return arr;
    }
    public List<Guide>  read() throws SQLException {
    List<Guide> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id,nom,specialite from guides");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String specialite=rs.getString("specialite");
               Guide p=new Guide(nom,id,specialite);
     arr.add(p);
     }
    return arr;
    }

    public List<Guide> RECHERCHER(String nomm) throws SQLException {
        List<Guide> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from guides where nom = '"+nomm+"' ");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String adresse=rs.getString("adresse");
                String specialite=rs.getString("specialite");
               String password ;
        password = rs.getString("password");
               int telephone=rs.getInt("telephone");
               Guide p=new Guide(id, nom, prenom, telephone, adresse, password, specialite);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public List<Guide> RECHERCHER(int idd) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    

    

   
    

}
