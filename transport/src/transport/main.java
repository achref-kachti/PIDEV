/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

import entites.vehicules;
import java.sql.SQLException;
import service.chauffeurService;
import service.vehiculeService;
import entites.chauffeurs;

/**
 *
 * @author Lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        vehiculeService s=new vehiculeService();
        chauffeurService c=new chauffeurService ();
        
        vehicules v1=new vehicules(2,"Mehdia","djerba","15h","20h",25,"Voiture");
        vehicules v2 = new vehicules (3,"Morneg","Centre ville","9h","11h",15,"TUS");
        vehicules v3 = new vehicules (4,"france","paris","22h","00h",20,"avion");
            vehicules v6 = new vehicules (30,"14","rabat","12h","14h",11,"toktok"); 
                vehicules v7 = new vehicules (20,"maroc","rabat","12h","14h",11,"toktok");
                
                chauffeurs c1 = new chauffeurs (222,"ahmed","ali",24198889);
                                chauffeurs c2 = new chauffeurs (333,"mouread","zzz",24193889);

     

                /* try{
       // s.ajouter1(v6);
      //   s.ajouter1(v7);
          s.modifiervehicules(2,v7); 
        }
        catch(SQLException ex){System.out.println(ex);} */

//c.ajouter2(c2);


/*try{
       // s.ajouter1(v6);
      //   s.ajouter1(v7);
          c.ajouter2(c1); 
        }
        catch(SQLException ex){System.out.println(ex);}

try{
        s.ajouter1(v2);
        }
        catch(SQLException ex){System.out.println(ex);} */ 
//s.modifiervehicules(v3);
   /* try {
s.ajouter1(v4);
    }          catch(SQLException ex){System.out.println(ex);}  */

   
  // s.affichervehiculeMatricule(4);
  //  s.TriVehiculesMatricule(); */
  
  //c.affichertousChauffeurs();
  c.afficherchauffeurCin(222);
}
}