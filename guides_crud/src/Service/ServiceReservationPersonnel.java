/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import entites.Guide;
import entites.ReservationPersonnel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nature
 */
public class ServiceReservationPersonnel {
 private Connection con;
    private Statement ste;

    public ServiceReservationPersonnel() {
        con = DataBase.getInstance().getConnection();

    }  
    public void ajouter(ReservationPersonnel rp) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`ReservationGuidePersonnel` (`id_reservation`, `date_db_res`, `date_fin_res`, `id_guide`, `reference`) "
                + "VALUES (NULL, '" + rp.getDatedb() + "', '" + rp.getDatefin() + "', '" + rp.getId_guide() +  "', '" + rp.getReference() +  "');";
        ste.executeUpdate(requeteInsert);
    }
    
     public void update(ReservationPersonnel rp, int id_guide, String date_db_res, String date_fin_res, int referencez) {
        try{
        PreparedStatement pt=con.prepareStatement("UPDATE reservationguidepersonnel SET `id_guide` = ? , `date_db_res` = ? , `date_fin_res` = ? where `reference` = '" + referencez + "' ;");
        pt.setInt(1,id_guide);
        pt.setString(2,date_db_res);
        pt.setString(3,date_fin_res);
        
        
        pt.execute();
        }catch (SQLException ex)
        {
            Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);
        }
       
        
              
              
              
          }
    public void supprimer(int reference)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `ReservationGuidePersonnel` WHERE `ReservationGuidePersonnel`.`reference` = '" + reference + "' ;" );
         
          pt.execute();
      
      
      
      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    } 
      /* Affichage */
      public List<ReservationPersonnel> readAll() throws SQLException {
    List<ReservationPersonnel> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from ReservationGuidePersonnel");
     while (rs.next()) {                
               int id_reservation=rs.getInt(1);
              
                String date_db_res=rs.getString("date_db_res");
                String date_fin_res=rs.getString("date_fin_res");
                
               
        int reference=rs.getInt("reference");
               int id_guide=rs.getInt("id_guide");
               ReservationPersonnel p=new ReservationPersonnel(id_reservation, date_db_res, date_fin_res, id_guide, reference);
     arr.add(p);
     }
    return arr;
    }
}
