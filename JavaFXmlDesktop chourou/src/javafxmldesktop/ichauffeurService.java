package javafxmldesktop;




import java.sql.SQLException;
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
public interface ichauffeurService <T> {
    public void  ajouterchauffeurs(chauffeurs p);
           public void modifierchauffeurs(int cin , chauffeurs p);
    List<T> readAll() throws SQLException;
        List<T> readAllNom() throws SQLException;
               public List<chauffeurs> rechercheAvancee(String s) throws SQLException;




    public void supprimerchauffeurs(chauffeurs p);
        public void supprimerchauffeursMatricule(int cin);

    public List<chauffeurs> affichertousChauffeurs();

        public List<chauffeurs> afficherChauffeurCin(int cin);

                public List<chauffeurs> afficherChauffeurNom();
                
                 //   public void ajouter2(chauffeurs p) ;

                
                                public List<chauffeurs> TriChauffeursCin(int cin);
                                                                public List<chauffeurs> TriChauffeursNom();


                
}
