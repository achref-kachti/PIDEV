/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.users;
import com.esprit.Utils.DataBase;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author sarah
 */
 public class userService
{
     Statement state;
     Connection cox;
     public userService()
     {
        cox=DataBase.getInstance().getConnection();
         try {
             state=cox.createStatement();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
     }
     public List<users> afficher_users() throws SQLException
     {
                ResultSet result=null;
               List<users> liste=new ArrayList<users>();
            
                    
                     result= state.executeQuery("select * from users");
                //System.out.println(result.isBeforeFirst());
                        
           while (result.next())
           {
               liste.add(new users(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getDate(6),result.getInt(7)));
                
           
           }
              
              
           return liste;
        
     }
     
     
     public List<users> afficher_users_tri_nom() throws SQLException
     {
                ResultSet result=null;
               List<users> liste=new ArrayList<users>();
            
                    
                     result= state.executeQuery("select * from users order by nom");
                //System.out.println(result.isBeforeFirst());
                        
           while (result.next())
           {
               liste.add(new users(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getDate(6),result.getInt(7)));
                
           
           }
              
              
           return liste;
        
     }
     
      public users recuperer_user_email(String email) throws SQLException
     {
                ResultSet result=null;
               
            
                    users u=new users();
                     result= state.executeQuery("select * from users where email='"+email+"'");
                //System.out.println(result.isBeforeFirst());
                        
           while (result.next())
           {
               u=new users(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getDate(6),result.getInt(7));
                
           
           }
              
              
           return u;
        
     }
      
      public users recuperer_user_id(int id) throws SQLException
     {
                ResultSet result=null;
               
            
                    users u=new users();
                     result= state.executeQuery("select * from users where id="+id);
                //System.out.println(result.isBeforeFirst());
                        
           while (result.next())
           {
               u=new users(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getDate(6),result.getInt(7));
                
           
           }
              
              
           return u;
        
     }
     
     public int delete_user(int id) throws SQLException
     {
                 int del=-1;
                
             
                    
                     del=state.executeUpdate("delete from users where id="+id);
                        
                
             
              
           return del;   
        
     }
     
     public boolean user_exit(String password, String email) throws SQLException
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
             
                   
                    String sql="select * from users where mot_de_passe LIKE BINARY '"+password+"' and email LIKE BINARY '"+email+"'";
                     result= state.executeQuery(sql);
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
                 
             
              
              
           return exist;   
        
     }
     
      public int  add_user(users user) throws SQLException
     {
                 
                 int result=0;
               
          
                    PreparedStatement prepare= cox.prepareStatement
                    ("INSERT INTO `users` (`id`, `nom`, `prenom`, `email`, `mot_de_passe`, `date_naissance`, `telephone`) "
  + "VALUES (NULL, ?, ?, ?, ?, ?, ?)");
                    
                    
                     prepare.setString(1, user.getNom());
                      prepare.setString(2, user.getPrenom());
                       prepare.setString(3, user.getEmail());
                        prepare.setString(4, user.getMot_de_passe());
                         prepare.setDate(5, user.getDate_naissance());
                        // prepare.setObject(5, LocalDate.now());
                          prepare.setInt(6, user.getTelephone());
                          //System.out.println(prepare.toString());
                         result=prepare.executeUpdate();
                         
                        
                     
                        
                

              
              
          return result;
        
     }
      
      public int  modify_user(users user,int id) throws SQLException
     {
                 
                 int nb=-1;
               
              
                    PreparedStatement prepare= cox.prepareStatement
                    (" UPDATE `users` SET nom=?,prenom=?,email=?,mot_de_passe=?,date_naissance=?,telephone=? WHERE id=?");
                    
                    
                     prepare.setString(1, user.getNom());
                      prepare.setString(2, user.getPrenom());
                       prepare.setString(3, user.getEmail());
                        prepare.setString(4, user.getMot_de_passe());
                         prepare.setDate(5, user.getDate_naissance());
                        // prepare.setObject(5, LocalDate.now());
                          prepare.setInt(6, user.getTelephone());
                          //System.out.println(prepare.toString());
                          prepare.setInt(7,id);
                        nb=prepare.executeUpdate();
                         
                         
                     
                        
                
            
              
                          
              
              
          return nb;
        
     }
      
      
    
     

}
