package service;


import entites.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilis.ConnexionDB;
//import java.connection.* ;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salma
 */
public class userService implements iuserService { 
      Connection  myConnex;
      Statement ste;
    
    public userService() {
          try {
              myConnex  = ConnexionDB.
                      getInstance()
                      .getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    /*public void ajouter2 (utilisateurs p) throws SQLException
    {
    PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `esprit`.`utilisateurs` ( `id`, `nom`, `prenom`, `email`, `mot_de_passe`, `date_naissance`, `telephone`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setInt(1, p.getId());
    pre.setString(2, p.getNom());
    pre.setString(3, p.getPrenom());
    pre.setString(4, p.getEmail());
    pre.setString(5, p.getMot_de_passe());
    pre.setString(6, p.getDate_naissance());
    pre.setInt(7, p.getTelephone());

    pre.executeUpdate();
    }
     */
    
    //@Override
    public void ajouterusers(users p) throws SQLException {
        
         PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `esprit`.`users` ( `id`, `nom`, `prenom`, `email`, `mot_de_passe`, `date_naissance`, `telephone`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setInt(1, p.getId());
    pre.setString(2, p.getNom());
    pre.setString(3, p.getPrenom());
    pre.setString(4, p.getEmail());
    pre.setString(5, p.getMot_de_passe());
    pre.setString(6, p.getDate_naissance());
    pre.setInt(7, p.getTelephone());

    pre.executeUpdate();
    }

    /**
     *
     * @param id
     * @param p
     * @return 
     * @throws java.sql.SQLException
     * 
     */
    public void modifierusers(int id ,users p) throws SQLException   {  
        
          PreparedStatement ps=myConnex.prepareStatement(" UPDATE  users SET nom=?,prenom=?,email=?,mot_de_passe=? , date_naissance=? , telephone=? WHERE id=?;");
                      ps.setString(1, p.getNom());
                       ps.setString(2, p.getPrenom());
                        ps.setString(3, p.getEmail());
                        ps.setString(4, p.getMot_de_passe());
                         ps.setString(5, p.getDate_naissance());
                         ps.setInt(6, p.getTelephone());
                         ps.setInt(7,id);
            ps.executeUpdate();
            }
       /*
  try  {
                    PreparedStatement ps= myConnex.prepareStatement
                    (" UPDATE  utilisateurss SET nom=?,prenom=?,=?,nom=?,prenom=? , capacite=? , type=? WHERE id=?;");
                    
                    
                     ps.setInt(1, p.getId());
                      ps.setString(2, p.getNom());
                       ps.setString(3, p.getPrenom());
                        ps.setString(4, p.getLieu_depart());
                        ps.setString(5, p.getLieu_arrivee());
                         ps.setInt(6, p.getCapacite());
                         ps.setString(7, p.getType());

                          ps.setInt(8,id);
                      
                           ps.executeUpdate();
                           System.out.println("aaaaaaaaaaa");
                         
                         
                     
                        
                } 
             catch (SQLException e) 
                    {
                      }  
              
      }*/
    
    
   //   @Override
    public void supprimerusers(users p) {
        
          try {
              String req2 =
                      "delete from users where id=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, p.getId());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    
    
     // @Override
    public void supprimerusersId(int id) {
        
          try {
              String req2 =
                      "delete from users where id=" + id;    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
            //  ps.setInt(1, p.getId());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    //  @Override
    public List<users> affichertoususers() {
        
          try {
              String req3 =
                      "select * from users";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-id de l'utilisateur " +
                          res.getInt("id") +"\n-Nom "+ 
                          res.getString("nom")+"\n-Prenom "+
                          res.getString("prenom") + "-\n -Mot de passe :" 
                          + res.getString("mot_de_passe")+ "\n-Date de naissance :"
                          + res.getString ("date_naissance")+ "\n-Telephone :"
                          + res.getInt("Telephone")+ "\n-Email : " + res.getString("email") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
    
    // @Override
    public List<users> TriUsersNom() {
        
          try {
              String req3 =
                      "select * from users ORDER BY id";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-id de l'utilisateur " +
                          res.getInt("id") +"\n-Nom "+ 
                          res.getString("nom")+"\n-Prenom "+
                          res.getString("prenom") + "-\n -Mot de passe :" 
                          + res.getString("mot_de_passe")+ "\n-Date de naissance :"
                          + res.getString ("date_naissance")+ "\n-Telephone :"
                          + res.getInt("Telephone")+ "\n-Email : " + res.getString("email") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    /**
     *
     * @return
     */
   
              
             
   
  
    public List<users> afficherUtilisateurNom(String nom) {
        
          try {
              String req3 =
                      "select * from users where nom ="  + nom;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-id de l'user " +
                          res.getInt("id") +"\n-Nom "+ 
                          res.getString("nom")+"\n-Prenom "+
                          res.getString("prenom") + "-\n -Mot de passe :" 
                          + res.getString("mot_de_passe")+ "\n-Date de naissance :"
                          + res.getString ("date_naissance")+ "\n-Telephone :"
                          + res.getInt("Telephone")+ "\n-Email : " + res.getString("email") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    
    
    //  @Override
    public List<users> afficherusersId(int id) {
        
          try {
              String req3 =
                      "select * from userss where id ="  + id;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                 System.out.println("-id de l'user " +
                          res.getInt("id") +"\n-Nom "+ 
                          res.getString("nom")+"\n-Prenom "+
                          res.getString("prenom") + "-\n -Mot de passe :" 
                          + res.getString("mot_de_passe")+ "\n-Date de naissance :"
                          + res.getString ("date_naissance")+ "\n-Telephone :"
                          + res.getInt("Telephone")+ "\n-Email : " + res.getString("email") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(userService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }


    
   

  /*  @Override
    public void modifieruserss(userss p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    //@Override
    public List<users> TriUserNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    /*@Override
    public void ajouterusers(users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

    @Override
    public void modifieruser(int id, users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimeruser(users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimeruser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   /* @Override
    public List<users> affichertoususers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

    @Override
    public List<users> afficheruserId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<users> afficheruserNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<users> TriUtilisateursNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter3(users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouteruser(users p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*    @Override
    public List<users> affichertoususers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

    public void modifieruse(int i, users u2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
