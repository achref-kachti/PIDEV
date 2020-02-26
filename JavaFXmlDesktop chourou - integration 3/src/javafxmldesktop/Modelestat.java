/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

/**
 *
 * @author lenovo
 */
public class Modelestat {
    
    String titre;
    int reserve;
    int capacite;
    String etat;
    public Modelestat(String titre, int reserve, int capacite, String etat) {
        this.titre = titre;
        this.reserve = reserve;
        this.capacite = capacite;
        this.etat = etat;
    }

    public Modelestat() {
    }

    public String getTitre() {
        return titre;
    }

    public int getReserve() {
        return reserve;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getEtat() {
        return etat;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Modelestat{" + "titre=" + titre + ", reserve=" + reserve + ", capacite=" + capacite + ", etat=" + etat + '}';
    }
    

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
  }
