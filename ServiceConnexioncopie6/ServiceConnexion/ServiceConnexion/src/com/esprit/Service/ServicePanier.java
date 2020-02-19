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

  
    public boolean panierexiste(int  reference, int id)
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
              try {
                   
                    String sql="select * from panier where refmat LIKE BINARY '"+reference+"' and iduser LIKE BINARY '"+id+"'";
                     result= ste.executeQuery(sql);
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
              
           return exist;   
        
     }
    
      @Override
    public void ajouterach(Panier t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO panier ( refmat, iduser, qtach ) VALUES ('" + t.getRefmat() + "', '" + t.getIduser() + "', '" + t.getQtach() +  "');";
        if(panierexiste(t.getRefmat(),t.getIduser())==false){
        ste.executeUpdate(requeteInsert);}
        else{
            String req="UPDATE panier SET qtach=qtach+'" + t.getQtach() + "' where iduser='" + t.getIduser() + "' and refmat='" + t.getRefmat() + "' ";
            ste.executeUpdate(req);
        }
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
                    (" UPDATE  `panier` SET refmat=?,iduser=?,qtach=? WHERE idach=?");
                    
                    
                     ps.setInt(1, t.getRefmat());
                      ps.setInt(2, t.getIduser());
                        ps.setInt(3, t.getQtach());
                          ps.setInt(4,id);
                      
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
    ResultSet rs=ste.executeQuery("select * from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id ");
     while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               int qtach= rs.getInt("qtach");
             

               Panier p=new Panier(idach, refmat, iduser,qtach);
     arr.add(p);
     }
    return arr;
    }
    
    @Override
    public List<Panier> trierach() throws SQLException{
      List<Panier> arr=new ArrayList<>();
      ste = con.createStatement();
      String sql = "SELECT idach, refmat, iduser, qtach FROM panier" +
              " ORDER BY qtach ASC";
      ResultSet rs=ste.executeQuery(sql);
       while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               int qtach= rs.getInt("qtach");
               

               Panier p=new Panier(idach, refmat, iduser,qtach);
     arr.add(p);
     }
    return arr;
        
    }
    
    
public List<Panier> rechercheach(String s) throws SQLException{
         List<Panier> arr=new ArrayList<>();
         ste=con.createStatement();
        ResultSet rs=ste.executeQuery("Select * from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id  where idach like '%" + s + "%'  or iduser like '%" + s + "%'or qtach like '%" + s + "%' or nommat like '%" + s + "%'or prixmat like '%" + s + "%';");
           while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               int qtach= rs.getInt("qtach");
              

               Panier p=new Panier(idach, refmat, iduser, qtach);
     arr.add(p);
     }
    return arr;
    }

public double calcultotal(int id) throws SQLException{
     
    double d=0;
    try {
   ste=con.createStatement();
  //ResultSet rs=ste.executeQuery("select sum(qtach*prixach) as tot from panier where iduser='" + id + "'");
    ResultSet rs=ste.executeQuery("select sum(panier.qtach*materiel.prixmat) as tot from panier inner join materiel on panier.refmat=materiel.refmat where iduser='" + id + "'");
   
    while (rs.next()) {                
             d= rs.getDouble(1);
             
     } 
    
    
       
}
catch (SQLException e) 
                    {
                          e.printStackTrace();
                          
     
                      }     
 return d;      
}       
   
}

