package entites;
import entites.User;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nature
 */
public class Guide extends User{
    
    private String  specialite;
    //nwali na3ml heritage ml classe user w nzid juste specialité comme attribut*
    
    

    public Guide(int id, String nom, String prenom, int telephone, String adresse,String password, String specialite) {
       super(id, nom, prenom, telephone, adresse, password);
        this. specialite =  specialite;
    }

    public Guide(String nom, String prenom, int telephone,String adresse,String password, String specialite) {
         super(nom, prenom, telephone, adresse, password);
        this.specialite = specialite;
    }
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    @Override
    public String toString() {
        return "\nUser{" + super.toString()+ "specialite "+ specialite +'}';
    }
}
