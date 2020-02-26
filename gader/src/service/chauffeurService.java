package service;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entites.chauffeurs;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public void ajouterchauffeur(chauffeurs p) throws SQLException
         
    {
    PreparedStatement pre=myConnex.prepareStatement("INSERT INTO `esprit`.`chauffeurs` ( `cinc`, `nomc`, `prenomc` ,`num_telc`) VALUES ( ?, ?, ?, ?);");
    pre.setInt(1, p.getCinc());
    pre.setString(2, p.getNomc());
    pre.setString(3, p.getPrenomc());
    pre.setInt(4, p.getNum_telc());

    pre.executeUpdate();
    }
    
    
    //@Override
    

    /**
     *
     * @param cin
     * @param matricule
     * @param p
     * @throws java.sql.SQLException
     */


   
    public void modifierchauffeurs(int cin ,chauffeurs p)    {
        try {
  
                    PreparedStatement ps= myConnex.prepareStatement
                    (" UPDATE  chauffeurs SET nomc=?,prenomc=?,num_telc=? WHERE cinc=?");
                    
                    
                   
                      ps.setString(1, p.getNomc());
                       ps.setString(2, p.getPrenomc());
                        
                         ps.setInt(3, p.getNum_telc());
                                                

                          ps.setInt(4,cin);
                      
                       int executeUpdate =    ps.executeUpdate();
                         
                         
                     
        }
       catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
                
            
                        
              
      }
    
    
    public void supprimerchauffeurs(chauffeurs p) {
        
          try {
              String req2 =
                      "delete from chauffeurs where cinc=?";    
             
              PreparedStatement ps = 
                      myConnex.prepareStatement(req2);
              ps.setInt(1, p.getCinc());
              ps.executeUpdate();
        //   System.out.println("supression réussie");
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    
    
    public void supprimerchauffeursMatricule(chauffeurs p) {
        
          try {
              String req2 =
                      "delete from chauffeurs where cinc=" + p.getCinc();    
             
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
                          res.getInt("cinc") +"\n-Nom chauffeur "+ 
                          res.getString("nomc")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenomc")+ "\n-Numero de telephone :"

                          + res.getInt("num_telc")+ "\n ///////////////////////////////"
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
                      "select * from chauffeurs ORDER BY cinc";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("\n ///////////////////////////////"+ "-Cin du chauffeur" +
                          res.getInt("cinc") +"\n-Nom chauffeur "+ 
                          res.getString("nomc")+"\n-Prenom chauffeur "+
                          
                          res.getString("prenomc")+ "\n-Numero de telephone :"
                          
                          + res.getInt("num_telc")
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
                      "select * from chauffeurs ORDER BY nomc";
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                   System.out.println("-Cin du chauffeur" +
                          res.getInt("cinc") +"\n-Nom chauffeur "+ 
                          res.getString("nomc")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenomc")+ "\n-Numero de telephone :"

                          + res.getInt("num_telc")+ "\n ///////////////////////////////"
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
                      "select * from chauffeurs where cinc ="  +cin;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                 System.out.println("-Cin du chauffeur" +
                          res.getInt("cinc") +"\n-Nom chauffeur "+ 
                          res.getString("nomc")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenomc")+ "\n-Numero de telephone :"

                          + res.getInt("num_telc")+ "\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }

    
    
    
    
    
    
  
    public List<chauffeurs> afficherchauffeurNom(String nomc) {
        
          try {
              String req3 =
                      "select * from chauffeurs where nomc ="  + nomc;
              ResultSet res =   ste.executeQuery(req3);
              
              while (res.next()) {
                  System.out.println("-Cin du chauffeur" +
                          res.getInt("cinc") +"\n-Nom chauffeur "+ 
                          res.getString("nomc")+"\n-Prenom chauffeur "+
                          
                           res.getString("prenomc")+ "\n-Numero de telephone :"

                          + res.getInt("num_telc")+ "\n ///////////////////////////////"
                          
                  );
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(chauffeurService.class.getName()).log(Level.SEVERE, null, ex);
          }
          
           return null;
    }
    
    
    public List<chauffeurs> readAll() throws SQLException {
    List<chauffeurs> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery("select * from chauffeurs");
     while (rs.next()) {        
                        int cin=rs.getInt("cinc");

               String nom=rs.getString("nomc");
                String prenom=rs.getString("prenomc");
               int telephone=rs.getInt("num_telc");
               chauffeurs p=new chauffeurs(cin, nom, prenom, telephone);
     arr.add(p);
     }
    return arr;
    }
    
       public List<chauffeurs> readAllNom() throws SQLException {
    List<chauffeurs> arr=new ArrayList<>();
    ste=myConnex.createStatement();
    ResultSet rs=ste.executeQuery("select * from chauffeurs ORDER BY nomc");
     while (rs.next()) {        
                        int cin=rs.getInt("cinc");

               String nom=rs.getString("nomc");
                String prenom=rs.getString("prenomc");
               int telephone=rs.getInt("num_telc");
               chauffeurs p=new chauffeurs(cin, nom, prenom, telephone);
     arr.add(p);
     }
    return arr;
    }
       
    /**
     *
     * @param s
     * @return
     * @throws SQLException
     */
    public List<chauffeurs> rechercheAvancee(String s) throws SQLException{
         List<chauffeurs> arr=new ArrayList<>();
         ste=myConnex.createStatement();
         
        ResultSet rs=ste.executeQuery( "Select * from chauffeurs where cinc like '%" + s + "%' or nomc like '%" + s + "%' or prenomc like '%" + s + "%' or num_telc like '%" + s + "%' ;");
           while (rs.next()) {                
               //int cin=rs.getInt(1);
                              int cin= rs.getInt("cinc");

               String nom=rs.getString("nomc");
               String prenom=rs.getString("prenomc");
               int tel= rs.getInt("num_telc");
               
               
          chauffeurs p=new chauffeurs(cin, nom,prenom,tel );
     arr.add(p);
     }
    
               return arr;

    }
       

   
  
    
    
    public Paragraph pdf()throws SQLException, FileNotFoundException, DocumentException{
    String filename="C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\gader\\src\\pdf\\gader.pdf";
    Document document=new Document();
     PdfWriter.getInstance(document, new FileOutputStream(filename)); 
     document.open();
    PreparedStatement ps=null;
     ResultSet rs=null;
     
     Paragraph pp=new Paragraph("Cin chauffeur         ||        Nom chauffeur         ||    Prenom chauffeur       ||     Numero telephone      \r\n \r\n");
     document.add(pp);
     Paragraph ppp=new Paragraph("________________________________________________________________");
     document.add(ppp);
     Paragraph para=new Paragraph();
     String query=("select * from chauffeurs ");
     ps=myConnex.prepareStatement(query);
     rs=ps.executeQuery();
     while(rs.next()){
         para=new Paragraph(rs.getInt("cinc")+"      ||         "+rs.getString("nomc")+"      ||         "+rs.getString("prenomc")+"      ||         "+rs.getInt("num_telc"));
        document.add(para);
       document.add(new Paragraph("  "));
                      }
     
     document.close();
     System.out.println("finished ma vie");
 return para;       
}
    

  /*  @Override
    public void modifierchauffeurs(chauffeurs p) uthj
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

    @Override
    public void supprimerchauffeursMatricule(int cin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouterchauffeurs(chauffeurs c1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List afficherChauffeurNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
