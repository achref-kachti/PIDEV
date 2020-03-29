/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;

/**
 *
 * @author lenovo
 */
public class Connection_Bd
{
   
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
