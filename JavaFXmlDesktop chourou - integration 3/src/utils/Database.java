/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Database {
     
    private static String url="jdbc:mysql://localhost:3306/projet";
     private static String user="root";
      private static String password="";
     private static Connection connect;

    public static Connection get_instance() 
    {
        
    
        if(connect==null)
        {   
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                connect=DriverManager.getConnection(url,user,password);
                System.out.println("conect etabli");
                
              
             }
            catch(SQLException e)
            { 
                e.printStackTrace();
                 return null;
            } catch (ClassNotFoundException e) {
                 e.printStackTrace();
            }
         
        }
        
        return connect;
          
        
       
    }
    
}
