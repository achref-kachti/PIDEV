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

public class Reservation
{

    int id_reservation;
    int id_user;

    
    String email;
    String nom;
    String prenom;
    int telephone;
    
    int id_evenement;
    String titre;
    String lieu;
    double prix;
    int capacite;
    java.sql.Date date_debut;
    java.sql.Date date_fin;
    
    

    public Reservation() {
    }

    public Reservation(int id_reservation, int id_evenement, int id_user) {
        this.id_reservation = id_reservation;
        this.id_evenement = id_evenement;
        this.id_user = id_user;
    }

    public Reservation(int id_reservation, int id_user, String email, String nom, String prenom, int telephone, int id_evenement, String titre, String lieu, double prix, int capacite, java.sql.Date date_debut, java.sql.Date date_fin) {
        this.id_reservation = id_reservation;
        this.id_user = id_user;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.id_evenement = id_evenement;
        this.titre = titre;
        this.lieu = lieu;
        this.prix = prix;
        this.capacite = capacite;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_reservation;
        return hash;
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
        final Reservation other = (Reservation) obj;
        if (this.id_reservation != other.id_reservation) {
            return false;
        }
        return true;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public java.sql.Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(java.sql.Date date_debut) {
        this.date_debut = date_debut;
    }

    public java.sql.Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(java.sql.Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "\nReservation{" + "id_reservation=" + id_reservation + ", id_user=" + id_user + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", id_evenement=" + id_evenement + ", titre=" + titre + ", lieu=" + lieu + ", prix=" + prix + ", capacite=" + capacite + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

    
  

  
   
    


}
