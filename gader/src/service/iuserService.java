package service;


import entites.users;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salma
 */
public interface iuserService {
    public void  ajouteruser(users p);
           public void modifieruser(int id , users p);


    public void supprimeruser (users p);
        public void supprimeruser(int id);

    public List<users> affichertoususers();
        public List<users> afficheruserId(int id);

                public List<users> afficheruserNom(String nom);
                
                   public void ajouter3(users p) ;

                
                                public List<users> TriUtilisateursNom(String nom);
                                                            //    public List<users> TriUtilisateursNom(String nom);


                


}
