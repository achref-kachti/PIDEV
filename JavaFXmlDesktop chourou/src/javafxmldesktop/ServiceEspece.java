/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author House
 */
public class ServiceEspece implements IEspece<Espece>
{

    private Connection con;
    private Statement ste;

    public ServiceEspece() {
        con = DataBase.getInstance().getConnection();

    }

    /* ajout */
    @Override
    public void ajouter(Espece e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `projet`.`espece` (`id`, `nom`, `type`, `mode`, `lieu`, `saison`, `description`) "
                + "VALUES (NULL, '" + e.getNom() + "', '" + e.getType()+ "', '" + e.getMode()+ "', '" + e.getLieu()+ "','" + e.getSaison()+ "','" + e.getDescription()+ "');";
        ste.executeUpdate(requeteInsert);
        JOptionPane.showMessageDialog(null, "Espéce ajouté avec succes");
    }
  
     /* update */
    @Override
     public void update(String nomm,String type, String mode,String lieu,String saison,String Description) 
     {
        try{
        PreparedStatement pt=con.prepareStatement("UPDATE espece SET  `type` = ? , `mode` = ? , `lieu` = ?, `saison` = ? ,`description`= ?   where `nom` = '" + nomm + "' ;");
      
        pt.setString(1,type);
        pt.setString(2,mode);
        pt.setString(3,lieu);
        pt.setString(4,saison);
        pt.setString(5,Description);
        pt.execute();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ServiceEspece.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
       
        
              
              
              
          
    /* suppression */
    @Override
    public void supprimer(String nomm)
    {
    
      try {
          PreparedStatement pt= con.prepareStatement(" DELETE FROM `espece` WHERE `espece`.`nom` = '" + nomm + "' ;" );
          
          pt.execute();
      }catch (SQLException ex) {
                Logger.getLogger(ServiceEspece.class.getName()).log(Level.SEVERE,null,ex);

      }
    
    }
    
    /*tri */
  /*  @Override
      public List<Espece> trier() throws SQLException {
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from guides order by id desc");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String adresse=rs.getString("adresse");
               int telephone;
        telephone = rs.getInt("telephone");
               String password;
        password = rs.getString("password");
               String specialite=rs.getString("specialite");
               Espece p=new Espece(id, nom, prenom, telephone, adresse, password, specialite);
     arr.add(p);
     }
    return arr;
    }
    */
   
          

    /**
     *
     * @return
     * @throws SQLException
     */
     /* recherche */
      public List<Espece> RECHERCHER(String nomm) throws SQLException {   //recherche par spécialité
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece where `nom` = '"+nomm+"' ");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String type=rs.getString("type");
                String mode =rs.getString("mode");
                String lieu = rs.getString("lieu");
                
                String saison=rs.getString("saison");
                String description=rs.getString("description");
                
                
            
               Espece p=new Espece(id, nom, type,mode,lieu, saison, description);
     arr.add(p);
     }
    return arr;
    }
      /*    Affichage   */
    @Override
    public List<Espece> readAll() throws SQLException {
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String type=rs.getString("type");
                String mode =rs.getString("mode");
                String lieu =rs.getString("lieu"); 
                String saison=rs.getString("saison");
                String description=rs.getString("description");

      
               Espece e=new Espece( nom,  type,  mode,  lieu, saison , description);
     arr.add(e);
     }
    return arr;
    }

   

   
    @Override
        public List<Espece> PdfResLog() throws SQLException, DocumentException, FileNotFoundException {

        String file_name ="E:\\JavaFXmlDesktop chourou\\pdf\\ListeE.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece ");
     while (rs.next()) {                
               int idA=rs.getInt("id");
           
               String Lieu=rs.getString("lieu");
               String Mode=rs.getString("mode");
               String Saison=rs.getString("saison");
               String description=rs.getString("description");
               //ResLogement l=new ResLogement(idReservationLog, idLog, dateA, dateD, nbrChamb, nom, lieu, prixNuite);
               Paragraph para = new Paragraph(rs.getString("lieu")+"         "+rs.getString("mode")+"           "+rs.getString("saison")+"          "+rs.getString("description"));
 

     document.add(para);
     document.add(new Paragraph(" "));
     //arr.add(l);
     }
    document.close();
    System.out.println("PDF");
    return arr;
    

   
    

}
    public List<Evenement> recuperer_event(String type) throws SQLException {
    List<Evenement> liste=new ArrayList<Evenement>();
    ste=con.createStatement();
    ResultSet result=ste.executeQuery("SELECT evenement.* FROM espece inner join evenement on espece.type=evenement.type where espece.type='"+type+"'");
     while (result.next()) {                
             liste.add(new Evenement(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),
                                          result.getString(5)  ,result.getInt(6),result.getDouble(7),result.getDate(8),result.getDate(9),result.getString(10)));  
     }
     
     return liste;
   
    }
     public List<Espece> rechercher_e(String typee) throws SQLException {   //recherche par spécialité
    List<Espece> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from espece where `type` = '"+typee+"' ");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
                String type=rs.getString("type");
                String mode =rs.getString("mode");
                String lieu = rs.getString("lieu");
                
                String saison=rs.getString("saison");
                String description=rs.getString("description");
                
                
            
               Espece p=new Espece(id, nom, type,mode,lieu, saison, description);
     arr.add(p);
     }
    return arr;
    }
}