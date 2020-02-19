/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entites.Espece;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase;
import entites.Espece;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import IEspece.IEspece;

/**
 *
 * @author House
 */
public class ServiceEspece implements IEspece<Espece>
{

    private Connection con;
    private Statement ste;

    public ServiceEspece() {
        con = DataBase.getInstance().getConnection();

    }

    /* ajout */
    @Override
    public void ajouter(Espece g) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`espece` (`id`, `nom`, `type`, `saison`, `description`) "
                + "VALUES (NULL, '" + g.getNom() + "', '" + g.getType()+ "', '" + g.getSaison()+ "', '" + g.getDescription()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Espéce ajouté avec succes");
    }
  
     /* update */
    @Override
    public void update(String nomm,String type, String description,String saison) {
        try{
        PreparedStatement pt=con.prepareStatement("UPDATE espece SET `type` = ? , `description` = ? , `saison` = ?  where `nom` = '" + nomm + "' ;");
      
        pt.setString(1,type);
        pt.setString(2,description);
        pt.setString(3,saison);
        
       
        pt.execute();
        }catch (SQLException ex)
        {
            Logger.getLogger(ServiceEspece.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
       
        
              
              
              
          
    /* suppression */
    @Override
    public void supprimer(String nomm)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `espece` WHERE `espece`.`nom` = '" + nomm + "' ;" );
          
          pt.execute();
      }catch (SQLException ex) {
                Logger.getLogger(ServiceEspece.class.getName()).log(Level.SEVERE,null,ex);

      }
    
    }
    
    /*tri */
  /*  @Override
      public List<Espece> trier() throws SQLException {
    List<Espece> arr=new ArrayList<>();
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
               Espece p=new Espece(id, nom, prenom, telephone, adresse, password, specialite);
     arr.add(p);
     }
    return arr;
    }
    */
   
          

    /**
     *
     * @return
     * @throws SQLException
     */
     /* recherche */
    /*  public List<Espece> RECHERCHER(String nomm) throws SQLException {   //recherche par spécialité
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece where `nom` = '"+nomm+"' ");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String type=rs.getString("type");
                String saison=rs.getString("saison");
                String description=rs.getString("description");
            
               Espece p=new Espece(id, nom, type, saison, description);
     arr.add(p);
     }
    return arr;
    }
      /*    Affichage   */
    @Override
    public List<Espece> readAll() throws SQLException {
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String type=rs.getString("type");
                String saison=rs.getString("saison");
                String description=rs.getString("description");
      
               Espece e=new Espece(id, nom, type, saison, description);
     arr.add(e);
     }
    return arr;
    }

   

   
    

    

   
    

}
