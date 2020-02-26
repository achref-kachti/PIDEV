/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class Evenement
{
       int id;
       String titre;
       String image;
       String description;
       String lieu;
       int capacite;
       double prix;
       java.sql.Date date_debut;
       java.sql.Date date_fin;
       String type;

    public Evenement() {
        id=-1;
    }

    public Evenement(int id, String titre, String image, String description,String lieu, int capacite, double prix, java.sql.Date date_debut, java.sql.Date date_fin,String type) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.description = description;
        this.lieu = lieu;
        this.capacite = capacite;
        this.prix = prix;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
    
    public String getLieu() {
        return lieu;
    }

    public int getCapacite() {
        return capacite;
    }

    public double getPrix() {
        return prix;
    }

    public java.sql.Date getDate_debut() {
        return date_debut;
    }

    public java.sql.Date getDate_fin() {
        return date_fin;
    }
    
    public String getType()
    {
         return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    
    public void setType(String type)
    {
          this.type=type;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nEvenement{" + "id=" + id + ", titre=" + titre + ", image=" + image + ", description=" + description+ ", lieu=" +lieu+ ", capacite=" + capacite + ", prix=" + prix + ", date_debut=" + date_debut + ", date_fin=" + date_fin +", type=" + type + '}';
    }
       
       
       




}
