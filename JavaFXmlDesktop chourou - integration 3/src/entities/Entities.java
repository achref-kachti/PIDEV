/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
 class Entities {
    
}

class users {
   
   private int id;
   private String nom;
   private String prenom;
   private String email;
   private String mot_de_passe;
   private java.sql.Date date_naissance;
   private int telephone;

    public users() {
    }

    public users(int id, String nom, String prenom, String email, String mot_de_passe, java.sql.Date date_naissance, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.date_naissance = date_naissance;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public java.sql.Date getDate_naissance() {
        return date_naissance;
    }

    public int getTelephone() {
        return telephone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final users other = (users) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nusers{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mot_de_passe=" + mot_de_passe + ", date_naissance=" + date_naissance + ", telephone=" + telephone + '}';
    }
  
      
}

 class Evenement
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


class Reservation
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

