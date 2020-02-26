package javafxmldesktop;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void ajoutervehicules(vehicules p) throws SQLException
    {
    PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `projet`.`vehicules` ( `matricule`, `date_depart`, `capacite`, `id_chauffeur`) VALUES ( ?, ?, ?, ?);");
    pre.setInt(1, p.getMatricule());
    pre.setString(2, p.getDate_depart());
  ;
    pre.setInt(3, p.getCapacite());
    pre.setInt(4, p.getId_chauffeur());

          int executeUpdate = pre.executeUpdate();
    }
    
    
    //@Override
    

    /**
     *
     * @param matricule
     * @param p
     * @return 
     * @throws java.sql.SQLException
     * 
     */
    public void modifiervehicules(int matricule ,vehicules p) throws SQLException   {  
        
          PreparedStatement ps=myConnex.prepareStatement(" UPDATE  vehicules SET date_depart=?, capacite=? , id_chauffeur=?  WHERE matricule=?;");
                      ps.setString(1, p.getDate_depart());
                     
                         ps.setInt(2, p.getCapacite());
                         ps.setInt(3, p.getId_chauffeur());
                         ps.setInt(4,matricule);
          int executeUpdate = ps.executeUpdate();
            }
    public void modifiervehicules1(int matricule ,String datedp,String capa) throws SQLException   {  
        
          PreparedStatement ps=myConnex.prepareStatement(" UPDATE  vehicules SET date_depart=?, capacite=?  WHERE matricule='"+matricule+"';");
                      ps.setString(1, datedp);
                     
                         ps.setString(2, capa);
                         
                         
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
    
       public List<vehicules> readAll() throws SQLException {
    List<vehicules> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery("select * from vehicules");
     while (rs.next()) {        
                        int mat=rs.getInt("matricule");

               String dated=rs.getString("date_depart");
               int cap=rs.getInt("capacite");
               int idc=rs.getInt("id_chauffeur");
               vehicules p=new vehicules(mat, dated, cap, idc);
     arr.add(p);
     }
    return arr;
    }
       
       
       
          public List<vehicules> readAllCapacite() throws SQLException {
    List<vehicules> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery("select * from vehicules ORDER BY capacite");
     while (rs.next()) {        
                        int mat=rs.getInt("matricule");

               String dated=rs.getString("date_depart");
               int cap=rs.getInt("capacite");
               int idc=rs.getInt("id_chauffeur");
               vehicules p=new vehicules(mat, dated, cap, idc);
     arr.add(p);
     }
    return arr;
    }
    
    
    
    
    
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
                  System.out.println("- matricule du vehicule " +
                          res.getInt("matricule") +"\n-date de depart "+ 
                          res.getString("date_depart")+  "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getInt("id du chauffeur :") +"\n ///////////////////////////////"
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
                    System.out.println("-matricule du vehicule " +
                          res.getInt("matricule") +"\n-date de depart "+ 
                          res.getString("date_depart")+  "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getInt("id du chauffeur :") +"\n ///////////////////////////////"
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
                 System.out.println("-matricule du vehicule " +
                          res.getInt("matricule") +"\n-date de depart "+ 
                          res.getString("date_depart")+  "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getInt("id du chauffeur :") +"\n ///////////////////////////////"
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
                 System.out.println("-matricule du vehicule " +
                          res.getInt("matricule") +"\n-date de depart "+ 
                          res.getString("date_depart")+  "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getInt("id du chauffeur :") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

  
    public List<vehicules> affichervehiculeDate_Depart(String date_depart) {
        
          try {
              String req3 =
                      "select * from vehicules where date_depart ="  + date_depart;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-matricule du vehicule " +
                          res.getInt("matricule") +"\n-date de depart "+ 
                          res.getString("date_depart")+  "\n-capacite :"
                          + res.getInt("capacite")+ "\n-de type : " + res.getInt("id du chauffeur :") +"\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(vehiculeService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
      public List<vehicules> rechercheAvanceeV(String s) throws SQLException{
         List<vehicules> arr=new ArrayList<>();
         ste=myConnex.createStatement();
         
        ResultSet rs=ste.executeQuery( "Select * from vehicules where matricule like '%" + s + "%' or date_depart like '%" + s + "%' or capacite like '%" + s + "%' or id_chauffeur like '%" + s + "%' ;");
           while (rs.next()) {                
               //int cin=rs.getInt(1);
                              int mat= rs.getInt("matricule");

               String dd=rs.getString("date_depart");
               int cap=rs.getInt("capacite");
               int idc= rs.getInt("id_chauffeur");
               
               
          vehicules p=new vehicules(mat, dd,cap,idc );
     arr.add(p);
     }
    
               return arr;

    }
    
    
    
    
    
    
     public List<ChauffeurVehicule> afficherJointure() throws SQLException {
        List<ChauffeurVehicule> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery( "select * from vehicules inner join chauffeurs on chauffeurs.cinc=vehicules.id_chauffeur");
     while (rs.next()) {        
                      
         int cinc = rs.getInt(5);
         String nomc = rs.getString(6);
         int matricule= rs.getInt(1);
         int capacite = rs.getInt(3);
         
               ChauffeurVehicule p=new ChauffeurVehicule(cinc,nomc,matricule,capacite);
               
               
               
     arr.add(p);
     }
    return arr;
          
    }
     
     
     
      public List<ChauffeurVehicule> afficherJointure2(int idc) throws SQLException {
        List<ChauffeurVehicule> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery( "select * from vehicules inner join chauffeurs on chauffeurs.cinc=vehicules.id_chauffeur WHERE chauffeurs.cinc LIKE " + idc +";");
     while (rs.next()) {        
                      
         int cinc = rs.getInt(5);
         String nomc = rs.getString(6);
         int matricule= rs.getInt(1);
         int capacite = rs.getInt(3);
         
               ChauffeurVehicule p=new ChauffeurVehicule(cinc,nomc,matricule,capacite);
               
               
               
     arr.add(p);
     }
    return arr;
          
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

    @Override
    public List<vehicules> affichervehiculeHeure_Depart(String heure_depart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<vehicules> affichervehiculeType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
  
}
