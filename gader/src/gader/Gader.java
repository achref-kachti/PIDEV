/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gader;

import entites.vehicules;
import java.sql.SQLException;
import service.chauffeurService;
import service.vehiculeService;
import entites.chauffeurs;

import service.userService;
import entites.users;

/**
 *
 * @author Lenovo
 */
public class Gader {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
   vehiculeService s=new vehiculeService();
        chauffeurService c=new chauffeurService ();
        userService u = new userService ();
        
        vehicules v2 = new vehicules (4,"20/01/2020",30,3);
       
                chauffeurs c1 = new chauffeurs (12321232,"ahmed","ali",24198889);
                                chauffeurs c2 = new chauffeurs (000,"mouread","zzz",24193889);
                                
                    users u1 = new users (1,"ali","mezghani","ali@esprit.tn","abcde","16/01/1888",666);
                                        users u2 = new users (2,"salma","mezghani","ali@esprit.tn","abcde","16/01/1888",23262911);

                    
                   // u.modifieruse(1,u2);
                   //c.modifierchauffeurs(123,c2);
                   //   s.ajouter1(v7);
//s.modifiervehicules(2,v7);
s.ajoutervehicules(v2);
}
}