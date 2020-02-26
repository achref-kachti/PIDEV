package service;


import entites.vehicules;
import java.sql.SQLException;
import java.util.List;
import entites.ChauffeurVehicule;
import entites.chauffeurs;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salma
 */
public interface ivehiculeService<T> {
    public void  ajoutervehicules(vehicules p) throws SQLException;
           public void modifiervehicules(int matricule , vehicules p)throws SQLException;

    public void supprimervehicules(vehicules p);
        public void supprimervehiculesMatricule(int matricule);

    public List<vehicules> affichertous();
        public List<vehicules> affichervehiculeMatricule(int matricule);
                public List<vehicules> affichervehiculeHeure_Depart(String heure_depart);
               public List<chauffeurs> rechercheAvanceeV(String s) throws SQLException;

                public List<vehicules> affichervehiculeType(String type);
                
                                public List<vehicules> TriVehiculesMatricule(String type);
                                                                public List<vehicules> TriVehiculesCapacite(String type);
                                                                
                                                                
                                                                    List<T> readAll() throws SQLException;
                                                                    List<T> readAllCapacite() throws SQLException;
                                                                    
                                                                    
                                                                         public List<chauffeurs> afficherJointure() throws SQLException ;




                


}
