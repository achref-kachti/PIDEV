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
public class Espece {
    
   private int id ;
    private String nom;
    private String saison;
    private String type;
    private String description;

    public Espece(int id, String nom, String saison, String type, String description) {
        this.id = id;
        this.nom = nom;
        this.saison = saison;
        this.type = type;
        this.description = description;
    }

    public Espece(String nom, String saison, String type, String description) {
        this.nom = nom;
        this.saison = saison;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 

    
    

  
}
