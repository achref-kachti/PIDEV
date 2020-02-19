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
public class vehicules {
    private int matricule;
    private String heure_depart;
    private String heure_arrivee;
    private String lieu_depart;
    private String lieu_arrivee;
    private int capacite;
    private String type;

    public vehicules(int matricule, String heure_depart, String heure_arrivee, String lieu_depart, String lieu_arrivee, int capacite, String type) {
        this.matricule = matricule;
        this.heure_depart = heure_depart;
        this.heure_arrivee = heure_arrivee;
        this.lieu_depart = lieu_depart;
        this.lieu_arrivee = lieu_arrivee;
        this.capacite = capacite;
        this.type = type;
        
        
        
          
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public String getLieu_depart() {
        return lieu_depart;
    }

    public String getLieu_arrivee() {
        return lieu_arrivee;
    }

    public String getType() {
        return type;
    }
    

    public vehicules() {
         this.matricule = 0;
        this.heure_depart = "";
        this.heure_arrivee = "";
        this.lieu_depart = "";
        this.lieu_arrivee = "";
        this.capacite = 0;
        this.type = "";
        
    }

    public vehicules(int matricule) {
        this.matricule = matricule;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
    
    
    
    
    
    
    
    
    
}


