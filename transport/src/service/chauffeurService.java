package service;


import entites.chauffeurs;
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
public class chauffeurService implements ichauffeurService { 
      Connection  myConnex;
      Statement ste;
    
    public chauffeurService() {
          try {
              myConnex  = ConnexionDB.
                      getInstance()
                      .getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void ajouter2(chauffeurs p) throws SQLException
    {
    PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `esprit`.`chauffeurs` ( `cin`, `nom`, `prenom`, `num_tel`) VALUES ( ?, ?, ?, ?);");
    pre.setInt(1, p.getCin());
    pre.setString(2, p.getNom());
    pre.setString(3, p.getPrenom());
   
    pre.setInt(4, p.getNum_tel());

    pre.executeUpdate();
    }
    
    
    //@Override
    public void ajouterchauffeur(chauffeurs p) {
        
          try {
              String req =
                      "INSERT INTO chauffeurs"
                      + "(matricule) VALUES "
                      + "(46)";
              
        
              ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    /**
     *
     * @param matricule
     * @param p
     */


   
    public void modifierchauffeurs(int cin ,chauffeurs p)    {
  try  {
                    PreparedStatement ps= myConnex.prepareStatement
                    (" UPDATE  chauffeurs SET cin=?,nom=?,prenom=?,=?,num_tel=? WHERE cin=?");
                    
                    
                     ps.setInt(1, p.getCin());
                      ps.setString(2, p.getNom());
                       ps.setString(3, p.getPrenom());
                        
                         ps.setInt(4, p.getNum_tel());
                                                

                          ps.setInt(5,cin);
                      
                           ps.executeUpdate();
                         
                         
                     
                        
                } 
             catch (SQLException e) 
                    {
                      }  
              
      }
    
    
    public void supprimerchauffeurs(chauffeurs p) {
        
          try {
              String req2 =
                      "delete from chauffeurs where cin=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, p.getCin());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    
    
    public void supprimerchauffeursMatricule(int cin) {
        
          try {
              String req2 =
                      "delete from chauffeurs where cin=" + cin;    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
            //  ps.setInt(1, p.getMatricule());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    public List<chauffeurs> affichertousChauffeurs() {
        
          try {
              String req3 =
                      "select * from chauffeurs";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Cin du chauffeur" +
                          res.getInt("cin") +"\n-Nom chauffeur "+ 
                          res.getString("nom")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenom")+ "\n-Numero de telephone :"

                          + res.getInt("num_tel")+ "\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
    
    // @Override
    public List<chauffeurs> TriChauffeursCin() {
        
          try {
              String req3 =
                      "select * from chauffeurs ORDER BY cin";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("\n ///////////////////////////////"+ "-Cin du chauffeur" +
                          res.getInt("cin") +"\n-Nom chauffeur "+ 
                          res.getString("nom")+"\n-Prenom chauffeur "+
                          
                          res.getString("prenom")+ "\n-Numero de telephone :"
                          
                          + res.getInt("num_tel")
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
     public List<chauffeurs> TriChauffeursNom() {
        
          try {
              String req3 =
                      "select * from chauffeurs ORDER BY nom";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                   System.out.println("-Cin du chauffeur" +
                          res.getInt("cin") +"\n-Nom chauffeur "+ 
                          res.getString("nom")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenom")+ "\n-Numero de telephone :"

                          + res.getInt("num_tel")+ "\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    
    
    
    
    public List<chauffeurs> afficherchauffeurCin(int cin) {
        
          try {
              String req3 =
                      "select * from chauffeurs where cin ="  +cin;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                 System.out.println("-Cin du chauffeur" +
                          res.getInt("cin") +"\n-Nom chauffeur "+ 
                          res.getString("nom")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenom")+ "\n-Numero de telephone :"

                          + res.getInt("num_tel")+ "\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
    
    
    
    
    
  
    public List<chauffeurs> afficherchauffeurNom(String nom) {
        
          try {
              String req3 =
                      "select * from chauffeurs where nom ="  + nom;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Cin du chauffeur" +
                          res.getInt("cin") +"\n-Nom chauffeur "+ 
                          res.getString("nom")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenom")+ "\n-Numero de telephone :"

                          + res.getInt("num_tel")+ "\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    
    
   


    
  //  @Override
    public void ajouterchauffeurs(chauffeurs p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  /*  @Override
    public void modifierchauffeurs(chauffeurs p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

   // @Override
    public List<chauffeurs> TriVehiculesMatricule(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public List<chauffeurs> TriVehiculesCapacite(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
   /* public List<chauffeurs> affichertousChauffeurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    //@Override
    public List<chauffeurs> afficherChauffeurCin(int cin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 //   @Override
    public List<chauffeurs> afficherChauffeurNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public List<chauffeurs> TriChauffeursCin(int cin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public List<chauffeurs> TriChauffeursNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
