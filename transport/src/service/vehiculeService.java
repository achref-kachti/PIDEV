package service;


import entites.vehicules;
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
public class vehiculeService implements ivehiculeService { 
      Connection  myConnex;
      Statement ste;
    
    public vehiculeService() {
          try {
              myConnex  = ConnexionDB.
                      getInstance()
                      .getConnection();
              ste = myConnex.createStatement();
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    public void ajouter1(vehicules p) throws SQLException
    {
    PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `esprit`.`vehicules` ( `matricule`, `heure_depart`, `heure_arrivee`, `lieu_depart`, `lieu_arrivee`, `capacite`, `type`) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
    pre.setInt(1, p.getMatricule());
    pre.setString(2, p.getHeure_depart());
    pre.setString(3, p.getHeure_arrivee());
    pre.setString(4, p.getLieu_depart());
    pre.setString(5, p.getLieu_arrivee());
    pre.setInt(6, p.getCapacite());
    pre.setString(7, p.getType());

    pre.executeUpdate();
    }
    
    
    //@Override
    public void ajoutervehicule(vehicules p) {
        
          try {
              String req =
                      "INSERT INTO vehicules"
                      + "(matricule) VALUES "
                      + "(46)";
              
        
              ste.executeUpdate(req);
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    /**
     *
     * @param matricule
     * @param p
     * @return 
     * @throws java.sql.SQLException
     * 
     */
    public void modifiervehicules(int matricule ,vehicules p) throws SQLException   {  
        
          PreparedStatement ps=myConnex.prepareStatement(" UPDATE  vehicules SET lieu_depart=?,lieu_arrivee=?,heure_depart=?,heure_arrivee=? , capacite=? , type=? WHERE matricule=?;");
                      ps.setString(1, p.getHeure_depart());
                       ps.setString(2, p.getHeure_arrivee());
                        ps.setString(3, p.getLieu_depart());
                        ps.setString(4, p.getLieu_arrivee());
                         ps.setInt(5, p.getCapacite());
                         ps.setString(6, p.getType());
                         ps.setInt(7,matricule);
            ps.executeUpdate();
            }
       /*
  try  {
                    PreparedStatement ps= myConnex.prepareStatement
                    (" UPDATE  vehicules SET heure_depart=?,heure_arrivee=?,=?,heure_depart=?,heure_arrivee=? , capacite=? , type=? WHERE matricule=?;");
                    
                    
                     ps.setInt(1, p.getMatricule());
                      ps.setString(2, p.getHeure_depart());
                       ps.setString(3, p.getHeure_arrivee());
                        ps.setString(4, p.getLieu_depart());
                        ps.setString(5, p.getLieu_arrivee());
                         ps.setInt(6, p.getCapacite());
                         ps.setString(7, p.getType());

                          ps.setInt(8,matricule);
                      
                           ps.executeUpdate();
                           System.out.println("aaaaaaaaaaa");
                         
                         
                     
                        
                } 
             catch (SQLException e) 
                    {
                      }  
              
      }*/
    
    
      @Override
    public void supprimervehicules(vehicules p) {
        
          try {
              String req2 =
                      "delete from vehicules where matricule=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, p.getMatricule());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    
    
      @Override
    public void supprimervehiculesMatricule(int matricule) {
        
          try {
              String req2 =
                      "delete from vehicules where matricule=" + matricule;    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
            //  ps.setInt(1, p.getMatricule());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
      @Override
    public List<vehicules> affichertous() {
        
          try {
              String req3 =
                      "select * from vehicules";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
    
    // @Override
    public List<vehicules> TriVehiculesMatricule() {
        
          try {
              String req3 =
                      "select * from vehicules ORDER BY matricule";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
     public List<vehicules> TriVehiculesCapacite() {
        
          try {
              String req3 =
                      "select * from vehicules ORDER BY capacite";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    
    
    
    
      @Override
    public List<vehicules> affichervehiculeMatricule(int matricule) {
        
          try {
              String req3 =
                      "select * from vehicules where matricule ="  + matricule;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

  
    public List<vehicules> affichervehiculeHeure_Depart(String heure_depart) {
        
          try {
              String req3 =
                      "select * from vehicules where heure_depart ="  + heure_depart;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    
    
      @Override
    public List<vehicules> affichervehiculeType(String type) {
        
          try {
              String req3 =
                      "select * from vehicules where type ="  + type;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Vehicule de matricule " +
                          res.getInt("matricule") +"\n-heure de depart "+ 
                          res.getString("heure_depart")+"\n-heure d'arrivee "+
                          res.getString("heure_arrivee") + "-\n lieu depart :" 
                          + res.getString("lieu_depart")+ "\n-lieu d'arrivée :"
                          + res.getString ("lieu_arrivee")+ "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getString("type") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }


    
    @Override
    public void ajoutervehicules(vehicules p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  /*  @Override
    public void modifiervehicules(vehicules p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    @Override
    public List<vehicules> TriVehiculesMatricule(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<vehicules> TriVehiculesCapacite(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
