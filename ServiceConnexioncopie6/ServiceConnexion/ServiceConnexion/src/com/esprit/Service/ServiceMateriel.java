/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;
import com.esprit.Entite.Materiel;
import com.esprit.IService.IServiceMateriel;
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
 * @author sarah
 */
public class ServiceMateriel implements IServiceMateriel<Materiel> {
    public Connection con;
    public Statement ste;

    public  ServiceMateriel() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajoutermat(Materiel t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO materiel (refmat, nommat, catmat, descmat, typemat, prixmat, qtmat, imagemat  ) VALUES ('" + t.getRef() + "', '" + t.getNom() + "', '" + t.getCategorie() + "', '" + t.getDesc() +"', '" + t.getType() + "', '" + t.getPrix() + "', '" + t.getQuantite() + "', '" + t.getImage() + "');";
        ste.executeUpdate(requeteInsert);
    }
    
    /*public void ajouter1(Materiel p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO materiel (nommat, catmat, descmat,typemat, prixmat, qtmat, imagemat ) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setString(1, p.getNom());
    pre.setInt(2, p.getCategorie());
    pre.setString(3, p.getDesc());
    pre.setString(4, p.getType());
    pre.setInt(5, p.getPrix());
    pre.setInt(6, p.getQuantite());
    pre.setString(7, p.getImage());
    pre.executeUpdate();
    }*/
            

    @Override
    public void supprimermat(Materiel t) throws SQLException {
//int del=-1;
       try{
        String req2 =
        "delete from materiel where refmat=?";
        PreparedStatement ps =
        con.prepareStatement(req2);
        ps.setInt(1, t.getRef());
        ps.execute();
        //del=ste.executeUpdate("delete from materievente where refmat="+t.getRef());
       }catch (SQLException ex) {
              Logger.getLogger(Materiel.class.getName()).log(Level.SEVERE, null, ex);
          }
         }
    
    
     public int supprimermat1(int idr)throws SQLException
     {
             int result=-1;
             result=ste.executeUpdate("delete from materiel where refmat ="+idr);
             return result;
     }
   
     
    
    
    
    @Override
    public void modifiermat(Materiel t) throws SQLException {
 try {
                    PreparedStatement ps= con.prepareStatement
                    (" UPDATE  materiel SET nommat=?,catmat=?,descmat=?,typemat=?,prixmat=?,qtmat=?, imagemat=? WHERE refmat=?");
                    
                    
                     ps.setString(1, t.getNom());
                      ps.setString(2, t.getCategorie());
                       ps.setString(3, t.getDesc());
                        ps.setString(4, t.getType());
                        ps.setInt(5, t.getPrix());
                         ps.setInt(6, t.getQuantite());
                         ps.setString(7, t.getImage());
                         ps.setInt(8,t.getRef());
                      
                           ps.executeUpdate();
                           //JOptionPane.showMessageDialog(null, "modifié");
                         
                     
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
      }

    @Override
    public List<Materiel> afficherlistemat() throws SQLException {
    List<Materiel> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from materiel");
     while (rs.next()) {                
               int refmat=rs.getInt("refmat");
               String nommat=rs.getString("nommat");
               String catmat=rs.getString("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               String imagemat=rs.getString("imagemat");
               Materiel p=new Materiel(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat, imagemat);
     arr.add(p);
     }
    return arr;
    }
    
    
    
    public List<Materiel> afficherlistema1t() throws SQLException {
    List<Materiel> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from materiel");
     while (rs.next()) { 
         
         Materiel m = new Materiel();
              m.setRef(rs.getInt("refmat"));
               m.setNom(rs.getString("nommat"));
              m.setCategorie(rs.getString("catmat"));
               m.setDesc(rs.getString("descmat"));
               m.setType(rs.getString("typemat"));
             m.setPrix(rs.getInt("prixmat"));
              m.setQuantite(rs.getInt("qtmat"));
            m.setImage(rs.getString("imagemat"));
     arr.add(m);
     }
    return arr;
    }
    
    @Override
    public List<Materiel> triermat() throws SQLException{
     
      List<Materiel> arr=new ArrayList<>();
      ste = con.createStatement();
      String sql = "SELECT refmat, nommat, catmat, descmat, typemat, prixmat, qtmat, imagemat FROM materiel" +
              " ORDER BY prixmat ASC";
      ResultSet rs=ste.executeQuery(sql);
       while (rs.next()) {                
               int refmat=rs.getInt("refmat");
               String nommat=rs.getString("nommat");
               String catmat=rs.getString("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
                              String imagemat=rs.getString("imagemat");

               Materiel p=new Materiel(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat, imagemat);
     arr.add(p);
     }
    return arr;
        
    }
    
    
    
    
    
public List<Materiel> recherchemat(String s) throws SQLException{
         List<Materiel> arr=new ArrayList<>();
         ste=con.createStatement();
        ResultSet rs=ste.executeQuery("Select * from materiel where nommat like '%" + s + "%' or typemat like '%" + s + "%' or refmat like '%" + s + "%' or descmat like '%" + s + "%' or prixmat like '%" + s + "%' or qtmat like '%" + s + "%'or catmat like '%" + s + "%' ;");
           while (rs.next()) {                
               int refmat=rs.getInt(1);
               String nommat=rs.getString("nommat");
               String catmat=rs.getString("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               String imagemat=rs.getString("imagemat");

               
               
              Materiel p=new Materiel(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat, imagemat );
     arr.add(p);
     }
        return arr;
    }

    
    
    
       
}
