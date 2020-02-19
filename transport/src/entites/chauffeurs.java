/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Lenovo
 */
public class chauffeurs {
    private int cin;
    private String nom;
    private String prenom;
    
    private int num_tel;

    public chauffeurs(int cin, String nom, String prenom, int num_tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
    }
    
    
    
    public chauffeurs() {
        this.cin = 0;
        this.nom = "";
        this.prenom = "";
        this.num_tel = 0;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    
 
    
    
    
    

}


    
    



