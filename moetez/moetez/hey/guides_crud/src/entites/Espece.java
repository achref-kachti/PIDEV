package entites;
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
    private String mode;
    private String lieu;
    

    public Espece(int id, String nom, String saison, String type, String description,String mode,String lieu) {
        this.id = id;
        this.nom = nom;
        this.saison = saison;
        this.type = type;
        this.description = description;
        this.mode=mode ;
        this.lieu=lieu;
    }

    public Espece(String nom, String saison, String type, String description,String mode ,String lieu) {
        this.nom = nom;
        this.saison = saison;
        this.type = type;
        this.description = description;
        this.mode=mode ;
        this.lieu=lieu;
        
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

  

    @Override
    public String toString() {
        return "Espece{" + "id=" + id + ", nom=" + nom + ", saison=" + saison + ", type=" + type + ", description=" + description + ", mode=" + mode + ", lieu=" + lieu +  '}';
    }
 

    
    

  
}
