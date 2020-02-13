/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Panier;
import com.esprit.IService.IServicepanier;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sarah
 */
public class ServicePanier implements IServicepanier<Panier> {
    private Connection con;
    private Statement ste;

    public  ServicePanier() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouterach(Panier t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`panier` (idach, refmat, iduser, nomach, prixach, qtach, typeach ) VALUES ('" + t.getIdach() + "', '" + t.getRefmat() + "', '" + t.getIduser() + "', '" + t.getNomach() +"', '" + t.getPrixach() +"', '" + t.getQtach() + "', '" + t.getTypeach() + "');";
        ste.executeUpdate(requeteInsert);
    }
    
   /* public void ajouter1(Stock p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`Stock` (nommat, catmat, descmat,typemat, prixmat, qtmat ) VALUES ( ?, ?, ?, ?, ?, ?);");
    pre.setString(1, p.getNom());
    pre.setInt(2, p.getCategorie());
    pre.setString(3, p.getDesc());
    pre.setString(4, p.getType());
    pre.setInt(5, p.getPrix());
    pre.setInt(6, p.getQuantite());
    pre.executeUpdate();
    }*/
            

    @Override
    public void supprimerach(Panier t) throws SQLException {
//int del=-1;
       try{
        String req2 =
        "delete from panier where idach=?";
        PreparedStatement ps =
        con.prepareStatement(req2);
        ps.setInt(1, t.getIdach());
        ps.execute();
        //del=ste.executeUpdate("delete from materievente where refmat="+t.getRef());
       }catch (SQLException ex) {
              Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
          }
         }

   /* @Override
     public int delete_mat(int id) throws SQLException
     {  int del=-1;
        del=ste.executeUpdate("delete from stock where refmat="+id);
        return del;   
        
     }*/
     
    
    
    
    @Override
    public void modifierach(Panier t,int id) throws SQLException {
 try {
                    PreparedStatement ps= con.prepareStatement
                    (" UPDATE  `panier` SET refmat=?,iduser=?,nomach=?,prixach=?,qtach=?,prixach=? WHERE idach=?");
                    
                    
                     ps.setInt(1, t.getRefmat());
                      ps.setInt(2, t.getIduser());
                       ps.setString(3, t.getNomach());
                        ps.setInt(4, t.getPrixach());
                        ps.setInt(5, t.getQtach());
                         ps.setString(6, t.getTypeach());
                          ps.setInt(7,id);
                      
                           ps.executeUpdate();
                         
                         
                     
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
      }

    @Override
    public List<Panier> afficherlisteach() throws SQLException {
    List<Panier> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from panier");
     while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               String nomach=rs.getString("nomach");
               int prixach= rs.getInt("prixach");
               int qtach= rs.getInt("qtach");
               String typeach=rs.getString("typeach");

               Panier p=new Panier(idach, refmat, iduser, nomach, prixach, qtach, typeach);
     arr.add(p);
     }
    return arr;
    }
    
    @Override
    public List<Panier> trierach() throws SQLException{
      List<Panier> arr=new ArrayList<>();
      ste = con.createStatement();
      String sql = "SELECT idach, refmat, iduser, nomach, prixach, qtach, typeach FROM panier" +
              " ORDER BY prixach ASC";
      ResultSet rs=ste.executeQuery(sql);
       while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               String nomach=rs.getString("nomach");
               int prixach= rs.getInt("prixach");
               int qtach= rs.getInt("qtach");
               String typeach=rs.getString("typeach");

               Panier p=new Panier(idach, refmat, iduser, nomach, prixach, qtach, typeach);
     arr.add(p);
     }
    return arr;
        
    }
    
    
public List<Panier> rechercheach(String s) throws SQLException{
         List<Panier> arr=new ArrayList<>();
         ste=con.createStatement();
        ResultSet rs=ste.executeQuery("Select * from panier where idach like '%" + s + "%' or refmat like '%" + s + "%' or iduser like '%" + s + "%' or nomach like '%" + s + "%' or prixach like '%" + s + "%' or qtach like '%" + s + "%'or typeach like '%" + s + "%' ;");
           while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               String nomach=rs.getString("nomach");
               int prixach= rs.getInt("prixach");
               int qtach= rs.getInt("qtach");
               String typeach=rs.getString("typeach");

               Panier p=new Panier(idach, refmat, iduser, nomach, prixach, qtach, typeach);
     arr.add(p);
     }
    return arr;
    }

/*public float calcultotal(int id) throws SQLException{
     try {
   ste=con.createStatement();
   ResultSet rs=ste.executeQuery("select sum(qtach*prixach) as tot from panier where idach='" + id + "'");
    while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               String nomach=rs.getString("nomach");
               int prixach= rs.getInt("prixach");
               int qtach= rs.getInt("qtach");
               String typeach=rs.getString("typeach");

               Panier p=new Panier(idach, refmat, iduser, nomach, prixach, qtach, typeach);
     arr.add(p);
     }
     } 
       catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
}*/
    
    
    
}
