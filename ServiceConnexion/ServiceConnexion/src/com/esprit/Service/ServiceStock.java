/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Panier;
import com.esprit.Entite.Stock;
import com.esprit.IService.IService;
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
public class ServiceStock implements IService<Stock>{
   

    private Connection con;
    private Statement ste;

    public  ServiceStock() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajoutermat(Stock t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`stock` (refmat, nommat, catmat, descmat, typemat, prixmat, qtmat ) VALUES ('" + t.getRef() + "', '" + t.getNom() + "', '" + t.getCategorie() + "', '" + t.getDesc() +"', '" + t.getType() + "', '" + t.getPrix() + "', '" + t.getQuantite() + "');";
        ste.executeUpdate(requeteInsert);
    }
    
    public void ajouter1(Stock p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`Stock` (nommat, catmat, descmat,typemat, prixmat, qtmat ) VALUES ( ?, ?, ?, ?, ?, ?);");
    pre.setString(1, p.getNom());
    pre.setInt(2, p.getCategorie());
    pre.setString(3, p.getDesc());
    pre.setString(4, p.getType());
    pre.setInt(5, p.getPrix());
    pre.setInt(6, p.getQuantite());
    pre.executeUpdate();
    }
            

    @Override
    public void supprimermat(Stock t) throws SQLException {
//int del=-1;
       try{
        String req2 =
        "delete from stock where refmat=?";
        PreparedStatement ps =
        con.prepareStatement(req2);
        ps.setInt(1, t.getRef());
        ps.execute();
        //del=ste.executeUpdate("delete from materievente where refmat="+t.getRef());
       }catch (SQLException ex) {
              Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
          }
         }

    @Override
     public int delete_mat(int id) throws SQLException
     {  int del=-1;
        del=ste.executeUpdate("delete from stock where refmat="+id);
        return del;   
        
     }
     
    
    
    
    @Override
    public void modifiermat(Stock t,int id) throws SQLException {
 try {
                    PreparedStatement ps= con.prepareStatement
                    (" UPDATE  `stock` SET nommat=?,catmat=?,descmat=?,typemat=?,prixmat=?,qtmat=? WHERE refmat=?");
                    
                    
                     ps.setString(1, t.getNom());
                      ps.setInt(2, t.getCategorie());
                       ps.setString(3, t.getDesc());
                        ps.setString(4, t.getType());
                        ps.setInt(5, t.getPrix());
                         ps.setInt(6, t.getQuantite());
                          ps.setInt(7,id);
                      
                           ps.executeUpdate();
                         
                         
                     
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
      }

    @Override
    public List<Stock> afficherlistemat() throws SQLException {
    List<Stock> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from stock");
     while (rs.next()) {                
               int refmat=rs.getInt("refmat");
               String nommat=rs.getString("nommat");
               int catmat=rs.getInt("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               Stock p=new Stock(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat);
     arr.add(p);
     }
    return arr;
    }
    
    @Override
    public List<Stock> triermat() throws SQLException{
      /*List<Materielvente> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from materielvente order by prixmat");
     while (rs.next()) {                
               int refmat=rs.getInt("refmat");
               String nommat=rs.getString("nommat");
               int catmat=rs.getInt("catmat");
               String descmat=rs.getString("descmat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               Materielvente p=new Materielvente(refmat, nommat, catmat, descmat,prixmat, qtmat);
     arr.add(p);
     }
    return arr;  */
      List<Stock> arr=new ArrayList<>();
      ste = con.createStatement();
      String sql = "SELECT refmat, nommat, catmat, descmat, typemat, prixmat, qtmat FROM stock" +
              " ORDER BY prixmat ASC";
      ResultSet rs=ste.executeQuery(sql);
       while (rs.next()) {                
               int refmat=rs.getInt("refmat");
               String nommat=rs.getString("nommat");
               int catmat=rs.getInt("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               Stock p=new Stock(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat);
     arr.add(p);
     }
    return arr;
        
    }
    
    
public List<Stock> recherchemat(String s) throws SQLException{
         List<Stock> arr=new ArrayList<>();
         ste=con.createStatement();
        ResultSet rs=ste.executeQuery("Select * from stock where nommat like '%" + s + "%' or typemat like '%" + s + "%' or refmat like '%" + s + "%' or descmat like '%" + s + "%' or prixmat like '%" + s + "%' or qtmat like '%" + s + "%'or catmat like '%" + s + "%' ;");
           while (rs.next()) {                
               int refmat=rs.getInt(1);
               String nommat=rs.getString("nommat");
               int catmat=rs.getInt("catmat");
               String descmat=rs.getString("descmat");
               String typemat=rs.getString("typemat");
               int prixmat= rs.getInt("prixmat");
               int qtmat= rs.getInt("qtmat");
               
               
              Stock p=new Stock(refmat, nommat, catmat, descmat, typemat, prixmat, qtmat);
     arr.add(p);
     }
        return arr;
    }

    
    
    
}
