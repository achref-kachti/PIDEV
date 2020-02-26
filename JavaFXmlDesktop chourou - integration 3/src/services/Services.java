/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author lenovo
 */
import com.email.durgesh.Email;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafxmldesktop.Connection_Bd;
import javafxmldesktop.Evenement;
import javafxmldesktop.Modelestat;
import javafxmldesktop.Reservation;
import javafxmldesktop.users;
import javax.mail.MessagingException;


 class userService
{
     Statement state;
     Connection cox;
     public userService()
     {
        cox=Connection_Bd.get_instance();
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





class Evenementc
{
    
     Statement state;
     Connection cox;
     public Evenementc()
     {
        cox=Connection_Bd.get_instance();
         try {
             state=cox.createStatement();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
     }
     
       public List<Evenement> afficher_evenements() throws SQLException
     {
               ResultSet result=null;
               List<Evenement> liste=new ArrayList<Evenement>();
                
               
              
                    
                     result= state.executeQuery("select * from evenement");
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    liste.add(new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10)));
              
              }
              
              
              return liste;
             
        
     }
         public ResultSet stat_evenements() throws SQLException
     {
               ResultSet result=null;
               List<Evenement> liste=new ArrayList<Evenement>();
                
               
              
                    
                     result= state.executeQuery("select lieu,count(*)total from evenement GROUP by lieu ");
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              
              
              return result;
             
        
     }
       
       
      
         
         
               public Evenement recuperer_evenement1(Evenement E) throws SQLException
     {
               ResultSet result=null;
               Evenement e=new Evenement();
                
               
              
                    
                     result= state.executeQuery("select * from evenement where id="+E.getId());
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    e=new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10));
              
              }
              
              
              return e;
             
        
     }
       

     
    public int ajouter_evenement(Evenement e) throws SQLException
    {
          int res=-1;
          
         
          
          PreparedStatement prepare=cox.prepareStatement("INSERT INTO `evenement` (`id`, `titre`, `image`, `description`,`lieu`,`capacite`, `prix`, `date_debut`, `date_fin`, `type`) VALUES"
        +"(NULL,?,?,?,?,?,?,?,?,?)");
    
        prepare.setString(1, e.getTitre());
        prepare.setString(2, e.getImage());
        prepare.setString(3, e.getDescription());
         prepare.setString(4, e.getLieu());
        prepare.setInt(5, e.getCapacite());
        prepare.setDouble(6, e.getPrix());
        prepare.setDate(7, e.getDate_debut());
        prepare.setDate(8, e.getDate_fin());
        prepare.setString(9, e.getType());
        res=prepare.executeUpdate();
        return res;
    
    }
      public int supprimer_evenement1(Evenement e) throws SQLException
    {
        int res=-1;
        res=state.executeUpdate("delete from evenement where id="+e.getId());
        return res;
    
    } 
    public int modifier_evenement(Evenement e,int id) throws SQLException
    {
         int res=-1;
         PreparedStatement prepare=cox.prepareStatement("UPDATE `evenement` SET `titre` = ?, `image` = ?, `description` =?, "
           +"`lieu` = ?,`capacite` =?,`prix` = ?,`date_debut` = ?, `date_fin` = ?, `type` = ? WHERE `evenement`.`id` = ?; ");
    
         
         prepare.setString(1, e.getTitre());
        prepare.setString(2, e.getImage());
        prepare.setString(3, e.getDescription());
         prepare.setString(4, e.getLieu());
        prepare.setInt(5, e.getCapacite());
        prepare.setDouble(6, e.getPrix());
       

        prepare.setDate(7, e.getDate_debut());
        prepare.setDate(8, e.getDate_fin());
          prepare.setString(9, e.getType());
        prepare.setInt(10, id);

        res=prepare.executeUpdate();
       
        return res;
    }
   
    
     public boolean titre_exist(String titre) throws SQLException
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
             
                   
                    String sql="select * from evenement where titre='"+titre+"'";
                     result= state.executeQuery(sql);
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
                 
             
              
              
           return exist;   
        
     }
        public boolean titre_exist_modifier(String titre,int id) throws SQLException
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
             
                   
                    String sql="select * from evenement where titre='"+titre+"' and id !="+id;
                     result= state.executeQuery(sql);
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
                 
             
              
              
           return exist;   
        
     }
    
    public List<Evenement> rechercher(String titre,String capacite,String prix,String lieu,String apartir,String contenant,boolean non_commences,String description) throws SQLException
    {
          List<Evenement> liste=new ArrayList<Evenement>();
         ResultSet result=null;
         String sql="SELECT * FROM `evenement` WHERE 1";
         if(!titre.isEmpty())
             sql=sql+" and titre='"+titre+"'";
         if(!capacite.isEmpty())
             sql=sql+" and capacite="+capacite;
           if(!prix.isEmpty())
             sql=sql+" and prix="+prix;
            if(!lieu.isEmpty())
             sql=sql+" and lieu='"+lieu+"'";
            if(!apartir.isEmpty())
             sql=sql+" and date_debut>='"+apartir+"'";
             if(!contenant.isEmpty())
             sql=sql+" and ('"+contenant+"' between date_debut and date_fin)";
             if(non_commences==true)
                 sql=sql+" and date_debut>sysdate()";
             if(!description.isEmpty())
             {
                 sql=sql+" and description like '%"+description+"%'";
             }
             System.out.println(sql);
             
             result=state.executeQuery(sql);
             while(result.next())
              {
              
                    liste.add(new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                           result.getString(5) ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10)));
              
              }
              
              
              return liste;

             
            
         
    
    
    }
    
       public Evenement recuperer_evenement(int id) throws SQLException
     {
               ResultSet result=null;
               Evenement e=new Evenement();
                
               
              
                    
                     result= state.executeQuery("select * from evenement where id="+id);
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    e=new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10));
              
              }
              
              
              return e;
             
        
     }
       
       
          public Evenement recuperer_evenement_titre(String titre) throws SQLException
     {
               ResultSet result=null;
               Evenement e=new Evenement();
                
               
              
                    
                     result= state.executeQuery("select * from evenement where titre='"+titre+"'");
                //System.out.println(result.isBeforeFirst());
                        
               
              
              
              while(result.next())
              {
              
                    e=new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10));
              
              }
              
              
              return e;
             
        
     }
        public int supprimer_evenement(int id) throws SQLException
    {
        int res=-1;
        res=state.executeUpdate("delete from evenement where id="+id);
        return res;
    
    }
    
    
}




class Reservationc
{
    
    Statement state;
     Connection cox;
     public Reservationc()
     {
        cox=Connection_Bd.get_instance();
         try {
             state=cox.createStatement();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
     }
     
     public int ajout_reservation(Reservation r) throws SQLException
     {       int generated_id=-1;
             int result=0;
             PreparedStatement prepare=cox.prepareStatement("INSERT INTO `reservation_evenement` (`id`, `id_evenement`, `id_user`) VALUES (NULL, ?, ?); ",Statement.RETURN_GENERATED_KEYS);
             prepare.setInt(1, r.getId_evenement());
             prepare.setInt(2, r.getId_user());
             result=prepare.executeUpdate();
             ResultSet resultat=prepare.getGeneratedKeys();
                         while ( resultat.next() ) {
                                  generated_id=resultat.getInt( 1 ) ;
                                  }
                         
                         
                     
                     
                        
            return generated_id;
     }
     
     public int annuler_reservation(int idr) throws SQLException
     {
             int result=-1;
             result=state.executeUpdate("delete from reservation_evenement where id="+idr);
             return result;
     }
     
     public int capacite_evenement( int id_evenement) throws SQLException
     {
               ResultSet result=null;
             int capacite=0;
             result=state.executeQuery("SELECT capacite from evenement where id="+id_evenement);
             while(result.next())
             {
                  capacite=result.getInt(1);
             }
             
             return capacite;
            
     }
     
     public ResultSet stat()throws SQLException
     {
               ResultSet result=null;
             
             result=state.executeQuery("select titre,count(*)total,capacite from reservation_evenement INNER join evenement on evenement.id=reservation_evenement.id_evenement GROUP by titre" );
             
             
             return result;
            
     }
     
     public List<Modelestat> modele()throws SQLException
     {
               ResultSet result=null;
               
               Modelestat m=new Modelestat();
               List<Modelestat> liste=new ArrayList<Modelestat>();
             
             result=state.executeQuery("select titre,count(*)total,capacite from reservation_evenement INNER join evenement on evenement.id=reservation_evenement.id_evenement GROUP by titre" );
             String etat="disponible";
             while(result.next())
             { 
               String titre=result.getString(1);
               int reserve=result.getInt(2);
               int capacite=result.getInt(3);
               if(reserve>=capacite)
               {etat="complet";}
               else
               {
                   etat="disponible";
               }
               m=new Modelestat(titre,reserve,capacite,etat);
               liste.add(m);
             }
             
             
            return liste;
     }
     
     
      public List<Modelestat> modele_recherche(boolean non_commence,boolean complet)throws SQLException
     {
               ResultSet result=null;
               
               Modelestat m=new Modelestat();
               List<Modelestat> liste=new ArrayList<Modelestat>();
               String sql="select titre,date_debut,count(*)total,capacite from reservation_evenement INNER join evenement on evenement.id=reservation_evenement.id_evenement GROUP by titre having 1 ";
                if(non_commence==true)
                {sql=sql+"and date_debut > sysdate()";}
                if(complet==true)
                {
                    sql=sql+ "and total >= capacite";
                }
             result=state.executeQuery(sql);
             String etat="disponible";
             while(result.next())
             { 
               String titre=result.getString(1);
               int reserve=result.getInt(3);
               int capacite=result.getInt(4);
               if(reserve>=capacite)
               {etat="complet";}
               else
               {
                   etat="disponible";
               }
               m=new Modelestat(titre,reserve,capacite,etat);
               liste.add(m);
             }
             
             
            return liste;
     }
     
     
     public int nbreservation_evenement( int id_evenement) throws SQLException
     {
               ResultSet result=null;
             int capacite=0;
             result=state.executeQuery("SELECT count(*) from reservation_evenement where id_evenement="+id_evenement);
             while(result.next())
             {
                  capacite=result.getInt(1);
             }
             
             return capacite;
            
     }
     
     
     
     
     public int nb_place_restant( int id_evenement) throws SQLException
     {
             
             int total_restant=this.capacite_evenement(id_evenement)-this.nbreservation_evenement(id_evenement);
             return total_restant;
            
            
     }
     
     public boolean ajouter_reservation(Reservation r ) throws SQLException
     {
             ResultSet result=null;
             int total_restant=0;
            
             total_restant=this.nb_place_restant(r.getId_evenement());
             
             if(total_restant<1)
             {
                 Alert alert = new Alert(Alert.AlertType.WARNING);
              
                alert.setTitle("evenement complet");
                 alert.setHeaderText("evenement complet");
                alert.setContentText("evenement complet ");
                 alert.showAndWait();
                 System.out.println("evenement complet");
                 return false;
             }
              int generated_id=this.ajout_reservation(r);
            ///*  
            Reservation r1=this.recuperer_reservation_complete(generated_id);
              String mail_to =r1.getEmail();
    
    Email email = new Email("montassar43@gmail.com","montassar007");
        
        try {
            email.setFrom("montassar43@gmail.com", "Reservation");
        } catch (MessagingException ex) {
            Logger.getLogger(Reservationc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Reservationc.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
        try {
            email.setSubject("");
        } catch (MessagingException ex) {
            Logger.getLogger(Reservationc.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            email.setContent("<h1>bonjour " +r1.getNom()+" votre reservation au evenement:"+r1.getTitre()+" du "+r1.getDate_debut()+"au "
                    +r1.getDate_fin()+" est effectuée avec succes,Prix: "+r1.getPrix()+"DT"+"</h1>", "text/html");
        } catch (MessagingException ex) {
            Logger.getLogger(Reservationc.class.getName()).log(Level.SEVERE, null, ex);
        }
        email.addRecipient(mail_to);
        try {
            email.send();
        } catch (MessagingException ex) {
            Logger.getLogger(Reservationc.class.getName()).log(Level.SEVERE, null, ex);
        }
              
           // */
             return true;
     }
     
     public List<Reservation> afficher_reservation() throws SQLException
     {
               List<Reservation> liste=new ArrayList<Reservation>();
               
               ResultSet result=state.executeQuery("select * from reservation_evenement");
               while(result.next())
               {  
                  liste.add(new Reservation(result.getInt(1),result.getInt(2),result.getInt(3)));
               }
               
               return liste;
     
     }
     
      public Reservation recuperer_reservation(int id) throws SQLException
     {
               
               Reservation r=new Reservation();
               ResultSet result=state.executeQuery("select * from reservation_evenement where id="+id);
               while(result.next())
               {  
                  r=new Reservation(result.getInt(1),result.getInt(2),result.getInt(3));
               }
               
               return r;
     
     }
      
       public Reservation recuperer_reservation_complete(int id) throws SQLException
     {
               
               Reservation r=new Reservation();
               ResultSet result=state.executeQuery("select * from (reservation_evenement INNER JOIN evenement on reservation_evenement.id_evenement=evenement.id "
                                                    +  "INNER JOIN users on reservation_evenement.id_user=users.id) where reservation_evenement.id="+id);
               while(result.next())
               {  
                  r=new Reservation(result.getInt(1),result.getInt("id_user"),result.getString("email"),result.getString("nom")
                                     ,result.getString("prenom"),result.getInt("telephone"),result.getInt("id_evenement"),
                                       result.getString("titre"),result.getString("lieu") ,result.getDouble("prix"),
                                      result.getInt("capacite"), result.getDate("date_debut"), result.getDate("date_fin"));
               }
               
               return r;
     
     }
      public List<Reservation> afficher_reservation_complete() throws SQLException
     {
               List<Reservation> liste=new ArrayList<Reservation>();
                Reservation r=new Reservation();
                String sql;
                sql="select * from (reservation_evenement INNER JOIN evenement on reservation_evenement.id_evenement=evenement.id "
                                                    +  "INNER JOIN users on reservation_evenement.id_user=users.id) where 1";
               ResultSet result=state.executeQuery(sql);
               while(result.next())
               {  
                  liste.add(new Reservation(result.getInt(1),result.getInt("id_user"),result.getString("email"),result.getString("nom")
                                     ,result.getString("prenom"),result.getInt("telephone"),result.getInt("id_evenement"),
                                       result.getString("titre"),result.getString("lieu") ,result.getDouble("prix"),
                                      result.getInt("capacite"), result.getDate("date_debut"), result.getDate("date_fin")));
               }
               
               
               return liste;
     
     }
      
      public List<Reservation> rechercher_reservation(String titre,String email,boolean non_commence,String contenant_date) throws SQLException
     {
               List<Reservation> liste=new ArrayList<Reservation>();
                Reservation r=new Reservation();
                String sql;
                sql="select * from (reservation_evenement INNER JOIN evenement on reservation_evenement.id_evenement=evenement.id "
                                                    +  "INNER JOIN users on reservation_evenement.id_user=users.id) where 1";
               
                if(! titre.isEmpty())
                {
                    sql=sql+" and titre='"+titre+"'";
                
                }
                 if(! email.isEmpty())
                {
                    sql=sql+" and email='"+email+"'";
                
                }
                  if(! contenant_date.isEmpty())
                {
                    sql=sql+" and '"+contenant_date+"' between date_debut and date_fin";
                
                }
                   if(non_commence==true)
                       
                {
                    sql=sql+" and  date_debut>sysdate()";
                
                }
                   System.out.println(sql);
                ResultSet result=state.executeQuery(sql);
               while(result.next())
               {  
                  liste.add(new Reservation(result.getInt(1),result.getInt("id_user"),result.getString("email"),result.getString("nom")
                                     ,result.getString("prenom"),result.getInt("telephone"),result.getInt("id_evenement"),
                                       result.getString("titre"),result.getString("lieu") ,result.getDouble("prix"),
                                      result.getInt("capacite"), result.getDate("date_debut"), result.getDate("date_fin")));
               }
               
               
               return liste;
     
     }
     
}


