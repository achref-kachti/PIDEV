package service;


import entites.chauffeurs;
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
public interface ichauffeurService {
    public void  ajouterchauffeurs(chauffeurs p);
           public void modifierchauffeurs(int cin , chauffeurs p);


    public void supprimerchauffeurs(chauffeurs p);
        public void supprimerchauffeursMatricule(int cin);

    public List<chauffeurs> affichertousChauffeurs();
        public List<chauffeurs> afficherChauffeurCin(int cin);

                public List<chauffeurs> afficherChauffeurNom(String nom);
                
                 //   public void ajouter2(chauffeurs p) ;

                
                                public List<chauffeurs> TriChauffeursCin(int cin);
                                                                public List<chauffeurs> TriChauffeursNom(String nom);


                


}
