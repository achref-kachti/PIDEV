/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import javafxmldesktop.DataBase;

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
public class ServiceAffectationGuide {
 private Connection con;
    private Statement ste;

    public ServiceAffectationGuide() {
        con = DataBase.getInstance().getConnection();

    }  
  /*  public void ajouter(ReservationGuideEvent rp) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO ReservationGuideEvent` (`id_reservation_event`, `id_guide`, `id_event`, `reference_res_event`) "
                + "VALUES (NULL,  '" + rp.getId_guide() + "', '" + rp.getId_event() +  "', '" + rp.getReference_res_event() +  "');";
        ste.executeUpdate(requeteInsert);
    }*/
     public int ajout_reservation(ReservationGuideEvent r) throws SQLException{
     {       int generated_id=-1;
             int result=0;
             PreparedStatement prepare=con.prepareStatement("INSERT INTO ReservationGuideEvent (`id_reservation_event`, `id_guide`, `id_event`) VALUES (NULL, ?, ?); ",Statement.RETURN_GENERATED_KEYS);
           
             prepare.setInt(1, r.getId_guide());
             prepare.setInt(2, r.getId_event());
             result=prepare.executeUpdate();
             ResultSet resultat=prepare.getGeneratedKeys();
                         while ( resultat.next() ) {
                                  generated_id=resultat.getInt( 1 ) ;
                                  }
                         
                         
                     
                     
                        
            return generated_id;
     }}
     
           public List<ReservationGuideEvent> readAll() throws SQLException {
    List<ReservationGuideEvent> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select *  from  ReservationGuideEvent, evenement where ReservationGuideEvent.id_event = evenement.id ");
     
    while (rs.next()) {                
            
     int id_reservation_event =rs.getInt("id_reservation_event");
    int id_event =rs.getInt("id_event");
    String titre =rs.getString("titre");
               ReservationGuideEvent p=new ReservationGuideEvent(id_reservation_event, id_event,titre);
               
     arr.add(p);
     }
    return arr;
    }
         public String recuperer_titre()throws SQLException {
    String arr = null;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select guides.nom, evenement.titre, evenement.description  from  ReservationGuideEvent, guides ,evenement where ReservationGuideEvent.id_guide = guides.id and evenement.id = ReservationGuideEvent.id_event");
     
    while (rs.next()) {                
          //  int id_reservation_event =rs.getInt("id_reservation_event");
        String nom_guide =rs.getString("nom");
    String description =rs.getString("description");
    String titre =rs.getString("titre");
            arr=titre;
     }
    return arr;
    }
               public int recuperer_t(String t)throws SQLException {
    int arr = 0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select  evenement.id from  evenement where evenement.titre ='"+t+"';");
     
    while (rs.next()) {                
           int id_event =rs.getInt("id");
   
            arr=id_event;
     }
    return arr;
    }
                 public int id_res()throws SQLException {
    int arr =0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select ReservationGuideEvent.id_reservation_event, evenement.titre, evenement.description  from  ReservationGuideEvent, guides ,evenement where ReservationGuideEvent.id_guide = guides.id and evenement.id = ReservationGuideEvent.id_event");
     
    while (rs.next()) {                
          int id_reservation_event =rs.getInt("id_reservation_event");
     
            arr=id_reservation_event;
     }
    return arr;
    }
      public int id_guide()throws SQLException {
    int arr =0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select guides.id from  ReservationGuideEvent, guides where ReservationGuideEvent.id_guide = guides.id ");
     
    while (rs.next()) {                
          int id_guide =rs.getInt("id");
     
            arr=id_guide;
     }
    return arr;
    }
      public int id_event()throws SQLException {
    int arr =0;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select evenement.id  from  ReservationGuideEvent, guides ,evenement where ReservationGuideEvent.id_guide = guides.id and evenement.id = ReservationGuideEvent.id_event");
     
    while (rs.next()) {                
          int id =rs.getInt("id");
     
            arr=id;
     }
    return arr;
    }
      public List<ReservationGuideEvent> recuperer_titre_desc_nomguide() throws SQLException {
    List<ReservationGuideEvent> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select guides.nom, evenement.titre, evenement.description  from  ReservationGuideEvent, guides ,evenement where ReservationGuideEvent.id_guide = guides.id and evenement.id = ReservationGuideEvent.id_event");
     
    while (rs.next()) {                
          //  int id_reservation_event =rs.getInt("id_reservation_event");
        String nom_guide =rs.getString("nom");
    String description =rs.getString("description");
    String titre =rs.getString("titre");
               ReservationGuideEvent p=new ReservationGuideEvent(nom_guide, description,titre);
               
     arr.add(p);
     }
    return arr;
    }
      public String recuperer_titree() throws SQLException {
    String titree=null;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select  evenement.titre  from  evenement ");
  
    while (rs.next()) {                
          
     String titre =rs.getString("titre");
   
    
               ReservationGuideEvent p=new ReservationGuideEvent(titre);
               
     titree=titre;
     }
    return titree;
    }
        public  List<ReservationGuideEvent> recuperer_titre1() throws SQLException {
        List<ReservationGuideEvent> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select  evenement.titre  from  evenement ");
  
    while (rs.next()) {                
          
     String titre =rs.getString("titre");
   
    
               ReservationGuideEvent p=new ReservationGuideEvent(titre);
               
     arr.add(p);
     }
    return arr;
    }
      public String recuperer_type() throws SQLException {
    String t=null;
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select  evenement.type  from  evenement ");
  
    while (rs.next()) {                
          
  
     String type =rs.getString("type");
    
               ReservationGuideEvent p=new ReservationGuideEvent(type);
               
     t=type;
     }
    return t;
    }
      
    
     public Evenement recuperer_evenement_titre(String titre) throws SQLException
     {
               ResultSet result=null;
               Evenement e=new Evenement();
                
               
              
                    
                     result= ste.executeQuery("select * from evenement where titre='"+titre+"'");
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    e=new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10));
              
              }
              
              
              return e;
             
        
     }
    public Evenement recuperer_evenement(int id) throws SQLException
     {
               ResultSet result=null;
               Evenement e=new Evenement();
                
               
              
                    
                 result= ste.executeQuery("select * from evenement where id="+id);
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    e=new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10));
              
              }
              
              
              return e;
             
        
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
    public void supprimer(int id_reservation, int id_guide , int id_event)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM ReservationGuideEvent WHERE ReservationGuideEvent.id_reservation_event = '" + id_reservation + "' and ReservationGuideEvent.id_guide = '" + id_guide + "' and ReservationGuideEvent.id_event = '" + id_event + "';" );
          
          pt.execute();
      
      
      
      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    }
      public void supprimer_id(int id)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `ReservationGuideEvent` WHERE id_reservation_event = '" + id + "' ;" );
          
          pt.execute();
      
      
      
      }catch (SQLException ex) {
                Logger.getLogger(ServiceGuide.class.getName()).log(Level.SEVERE,null,ex);

      }
    }
        public void supprimer_res(int id)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM ReservationGuideEvent  WHERE ReservationGuideEvent.id_reservation_event = '" + id + "' ;" );
          
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
            
               int id_guide=rs.getInt("id_guide");
               int id_event=rs.getInt("id_event");
               ReservationGuideEvent p=new ReservationGuideEvent(id_reservation, id_guide);
     arr.add(p);
     }
    return arr;
    }
            public List<Evenement> return_event() throws SQLException {
    List<Evenement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select titre from evenement ");
     while (rs.next()) {                
             
              String titre=rs.getString("titre");
               Evenement p=new Evenement(titre);
     arr.add(p);
     }
    return arr;
    }

    
}
