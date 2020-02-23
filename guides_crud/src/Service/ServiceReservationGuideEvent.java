/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import entites.ReservationGuideEvent;
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
public class ServiceReservationGuideEvent {
 private Connection con;
    private Statement ste;

    public ServiceReservationGuideEvent() {
        con = DataBase.getInstance().getConnection();

    }  
    public void ajouter(ReservationGuideEvent rp) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`ReservationGuideEvent` (`id_reservation_event`, `id_guide`, `id_event`, `reference_res_event`) "
                + "VALUES (NULL,  '" + rp.getId_guide() + "', '" + rp.getId_event() +  "', '" + rp.getReference_res_event() +  "');";
        ste.executeUpdate(requeteInsert);
    }
    
     public void update(ReservationGuideEvent rp,int id_guide, int id_event,String referencez) {
        try{
        PreparedStatement pt=con.prepareStatement("UPDATE ReservationGuideEvent SET  `id_guide` = ? , `id_event` = ?  where reference_res_event = '" + referencez + "' ;");
        pt.setInt(1,id_guide);
        pt.setInt(2,id_event);
        
        
        pt.execute();
        }catch (SQLException ex)
        {
            Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);
        }
       
        
              
              
              
          }
    public void supprimer(String reference)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `ReservationGuideEvent` WHERE `ReservationGuideEvent`.`reference_res_event` = '" + reference + "' ;" );
          
          pt.execute();
      
      
      
      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    }

      public List<ReservationGuideEvent> trier() throws SQLException {
    List<ReservationGuideEvent> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from ReservationGuideEvent order by reference desc");
     while (rs.next()) {                
               int id_reservation=rs.getInt(1);
              String reference;
        reference = rs.getString("reference");
               int id_guide=rs.getInt("id_guide");
               int id_event=rs.getInt("id_event");
               ReservationGuideEvent p=new ReservationGuideEvent(id_reservation, id_guide, id_event,reference);
     arr.add(p);
     }
    return arr;
    }
    
}
