/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Panier;
import com.esprit.Entite.AfficherMatrielPanier;
import com.esprit.IService.IServicepanier;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sarah
 */
public class ServicePanier implements IServicepanier<Panier> {
    private Connection con;
    private Statement ste;

    public  ServicePanier() {
        con = DataBase.getInstance().getConnection();

    }

   /*existence du produit et de l'utilisateur*/
    @Override
    public boolean panierexiste(int  reference, int id)
     {
                   ResultSet result=null;
                   boolean exist=false;
                 
               
              try {
                   
                    String sql="select * from panier where refmat LIKE BINARY '"+reference+"' and iduser LIKE BINARY '"+id+"'";
                     result= ste.executeQuery(sql);
                     
               if(result.isBeforeFirst())
                    exist=true;
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
              
           return exist;   
        
     }
    /*ajout au panier : s'il existe un meme user qui achete le meme produit on incremente la qt achetee*/
    
    
    /*********************************************************************************************************************/
    @Override
    public void ajouterach(Panier t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO panier ( refmat, iduser, qtach ) VALUES ('" + t.getRefmat() + "', '" + t.getIduser() + "', '" + t.getQtach()+1 +  "');";
        if(panierexiste(t.getRefmat(),t.getIduser())==false){
        ste.executeUpdate(requeteInsert);}
        else{
            String req="UPDATE panier SET qtach=qtach+1 where iduser='" + t.getIduser() + "' and refmat='" + t.getRefmat() + "' ";
            ste.executeUpdate(req);
        }
    }
    /****************************************************************ajout zghal**************************************************************************/
    public boolean ajouter_panier(Panier r ) throws SQLException
     { ResultSet result=null;
     int generated_id=this.ajout_panier(r);
            
      Panier r1=this.recuperer_panier(generated_id);
       return true;  
     }
    
     public Panier recuperer_panier(int id) throws SQLException
     {
               
               Panier r=new Panier();
               ResultSet result=ste.executeQuery("select *  from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id  where panier.idach='"+id+"'");
               while(result.next())
               {  
                  r=new Panier(result.getInt(1),result.getInt("refmat"),result.getInt("iduser"),result.getInt("qtach")
                                    );
               }
               
               return r;
     
     }
     
    public int ajout_panier(Panier r) throws SQLException
     {       int generated_id=-1;
             int result=0;
             PreparedStatement prepare=con.prepareStatement("INSERT INTO `panier` (`idach`, `refmat`, `iduser`, `qtach`) VALUES (NULL, ?, ?, ?); ",Statement.RETURN_GENERATED_KEYS);
             prepare.setInt(1, r.getIdach());
             prepare.setInt(2, r.getRefmat());
             result=prepare.executeUpdate();
             ResultSet resultat=prepare.getGeneratedKeys();
                         while ( resultat.next() ) {
                                  generated_id=resultat.getInt(1) ;
                                  }
                
            return generated_id;
     } 
    
    /*********************************************************************************************************************************************/

    /*suppression*/
    
    public void supprimerach(AfficherMatrielPanier t) throws SQLException {
//int del=-1;
       try{
        String req2 =
                ("delete from panier where idach="+t.getIdach());
        //("delete panier from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id  where panier.idach="+t.getIdach());
        PreparedStatement ps =
        con.prepareStatement(req2);
        //ps.setInt(1, t.getIdach());
        ps.execute();
        //del=ste.executeUpdate("delete from materievente where refmat="+t.getRef());
       }catch (SQLException ex) {
              Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
          }
         }

    @Override
   public void annuler_achat(int id) throws SQLException
     {
           /*  int result=-1;
             
             result=ste.executeUpdate("delete  from  panier  where refmat="+ref+"and iduser="+id );
             return result;*/
         
          try{
        String req2 =
        "delete from panier where idach=?";
        PreparedStatement ps =
        con.prepareStatement(req2);
        ps.setInt(1,id);
        ps.execute();
        //del=ste.executeUpdate("delete from materievente where refmat="+t.getRef());
       }catch (SQLException ex) {
              Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
     
    
  
    
    /* modification*/
    @Override
    public void modifierach(Panier t,int id) throws SQLException {
 try {
                    PreparedStatement ps= con.prepareStatement
                    (" UPDATE  `panier` SET refmat=?,iduser=?,qtach=? WHERE idach=?");
                    
                    
                     ps.setInt(1, t.getRefmat());
                      ps.setInt(2, t.getIduser());
                        ps.setInt(3, t.getQtach());
                          ps.setInt(4,id);
                      
                           ps.executeUpdate();
                         
                         
                     
                        
                } 
              catch (SQLException e) 
                    {
                          e.printStackTrace();
     
                      } 
              
      }
    
    /*recuperation de l'achat par titre*/
    @Override
    public Panier recupererachattitre(String titre) throws SQLException
     {
               ResultSet result=null;
               Panier e=new Panier();
                
               
                     result= ste.executeQuery("select *  from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id  where materiel.nommat='"+titre+"'");
                
              while(result.next())
              {
              
                    e=new Panier(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)
                                          );
              
              }
           
              return e;
             
        
     }
    /*affichage*/
    @Override
    public List<Panier> afficherlisteach() throws SQLException {
    List<Panier> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select *  from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id ");
     while (rs.next()) {                
               int idach=rs.getInt("idach");
               int refmat=rs.getInt("refmat");
               int iduser=rs.getInt("iduser");
               int qtach= rs.getInt("qtach");
             

               Panier p=new Panier(idach, refmat, iduser,qtach);
     arr.add(p);
     }
    return arr;
    }
    /*???????????????*/
    
     public List<AfficherMatrielPanier> afficherlisteachjoint(int id) throws SQLException {
    List<AfficherMatrielPanier> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id where users.id='"+id+"'");
     while (rs.next()) { 
               int idach=rs.getInt(1);
               int refmat=rs.getInt(2);
               int iduser=rs.getInt(3);
               

               String nommat=rs.getString(6);
               int prixmat=rs.getInt(10);
              
               String imagemat=rs.getString(12);
                String prenom=rs.getString(15);
               int qtach= rs.getInt(4);
             

              // AfficherMatrielPanier p=new AfficherMatrielPanier(nommat, prenom, imagemat, qtach);
              AfficherMatrielPanier p=new AfficherMatrielPanier(idach, refmat, iduser, nommat, prixmat, imagemat, prenom, qtach);
     arr.add(p);
     }
    return arr;
    }
     
     
     /*tri*/
   
    public List<AfficherMatrielPanier> trierach() throws SQLException{
      List<AfficherMatrielPanier> arr=new ArrayList<>();
      ste = con.createStatement();
      String sql = ("select materiel.nommat, users.prenom,materiel.imagemat, panier.qtach  from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id order by panier.qtach " );
      ResultSet rs=ste.executeQuery(sql);
       while (rs.next()) {                
               String nommat=rs.getString(1);
               String prenom=rs.getString(2);
               String imagemat=rs.getString(3);
               int qtach= rs.getInt(4);
             

               AfficherMatrielPanier p=new AfficherMatrielPanier(nommat, prenom, imagemat, qtach);
     arr.add(p);
     }
    return arr;
        
    }
    
  /*recherche*/ 
   
       public List<AfficherMatrielPanier> rechercheach(String s,int id) throws SQLException{
         List<AfficherMatrielPanier> arr=new ArrayList<>();
         ste=con.createStatement();
        ResultSet rs=ste.executeQuery("Select * from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id  where idach like '%" + s + "%' or qtach like '%" + s + "%' or nommat like '%" + s + "%'or prixmat like '%" + s + "%' and iduser ='"+id+"'");
           while (rs.next()) {                
               int idach=rs.getInt(1);
               int refmat=rs.getInt(2);
               int iduser=rs.getInt(3);
               

               String nommat=rs.getString(6);
               int prixmat=rs.getInt(10);
              
               String imagemat=rs.getString(12);
                String prenom=rs.getString(15);
               int qtach= rs.getInt(4);
             

             
              AfficherMatrielPanier p=new AfficherMatrielPanier(idach, refmat, iduser, nommat, prixmat, imagemat, prenom, qtach);
     arr.add(p);
     }
    return arr;
    }

/*total*/
public double calcultotal(int id) throws SQLException{
     
    double d=0;
    try {
   ste=con.createStatement();
  //ResultSet rs=ste.executeQuery("select sum(qtach*prixach) as tot from panier where iduser='" + id + "'");
    ResultSet rs=ste.executeQuery("select sum(panier.qtach*materiel.prixmat) as tot from panier inner join materiel on panier.refmat=materiel.refmat where iduser='" + id + "'");
   
    while (rs.next()) {                
             d= rs.getDouble(1);
             
     } 
    
    
       
}
catch (SQLException e) 
                    {
                          e.printStackTrace();
                          
     
                      }     
 return d;      
}  


public Paragraph pdf(int id)throws SQLException, FileNotFoundException, DocumentException{
    String filename="C:\\Users\\sarah\\Documents\\NetBeansProjects\\ServiceConnexioncopie3\\ServiceConnexion\\ServiceConnexion\\pdf\\facture.pdf";
    Document document=new Document();
     PdfWriter.getInstance(document, new FileOutputStream(filename)); 
     document.open();
    PreparedStatement ps=null;
     ResultSet rs=null;
     Paragraph p=new Paragraph("Facture du client détenant l'id: "+id+"\r\n \r\n");
     document.add(p);
     Paragraph pp=new Paragraph("Materiel             Client             Quantité             Prix      \r\n \r\n");
     document.add(pp);
     Paragraph ppp=new Paragraph("________________________________________________________________");
     document.add(ppp);
     
     Paragraph para=new Paragraph();
     String query=("select * from panier inner join materiel on panier.refmat=materiel.refmat inner join users on panier.iduser=users.id where users.id='"+id+"'");
     ps=con.prepareStatement(query);
     rs=ps.executeQuery();
     while(rs.next()){
         para=new Paragraph(rs.getString("nommat")+"             "+rs.getString("prenom")+"             "+rs.getInt("qtach")+"             "+rs.getInt("prixmat"));
        document.add(para);
       document.add(new Paragraph("  "));
       
                      }
     
     
     Paragraph o=new Paragraph();
     
     String q=("select sum(panier.qtach*materiel.prixmat) as tot from panier inner join materiel on panier.refmat=materiel.refmat where iduser='" + id + "'");
     ps=con.prepareStatement(q);
     rs=ps.executeQuery();
     while (rs.next()) {                
           o= new Paragraph("Total= "+(float) rs.getDouble(1)+" dt");
           document.add(o);  
     } 
     
     
     
     document.close();
     System.out.println("finished ma vie");
 return para;       
}  
}


