/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;


/**
 *
 * @author Lenovo
 */
public class vehicules {
    private int matricule;
    private String date_depart;
   
    private int capacite;
   private int id_chauffeur;

    public vehicules(int matricule, String date_depart, int capacite, int id_chauffeur) {
        this.matricule = matricule;
        this.date_depart = date_depart;
        this.capacite = capacite;
        this.id_chauffeur = id_chauffeur;
    }

    
    
    public vehicules() {
        this.matricule = 0;
        this.date_depart = "";
        this.capacite = 0;
        this.id_chauffeur =0;
    }

    @Override
    public String toString() {
        return "vehicules{" + "matricule=" + matricule + ", date_depart=" + date_depart + ", capacite=" + capacite + ", id_chauffeur=" + id_chauffeur + '}';
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getId_chauffeur() {
        return id_chauffeur;
    }

    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }
    
   
   
    
    
}


