/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author House
 */
public class Logement {
    private int idLog;
    private String nom;
    private String lieu;
    private String description;
    private int nbrTTchamb;
    private int prixNuite;
    private String img;

    public Logement(int idLog, String nom, String lieu, String description, int nbrTTchamb, int prixNuite, String img) {
        this.idLog = idLog;
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.nbrTTchamb = nbrTTchamb;
        this.prixNuite = prixNuite;
        this.img = img;
    }

    public Logement(String nom, String lieu, String description, int nbrTTchamb, int prixNuite, String img) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.nbrTTchamb = nbrTTchamb;
        this.prixNuite = prixNuite;
        this.img = img;
    }
    
    public Logement(int idLog, String nom, String lieu, String description, int nbrTTchamb, int prixNuite) {
        this.idLog = idLog;
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
        this.nbrTTchamb = nbrTTchamb;
        this.prixNuite = prixNuite;
    }
    
    public Logement(String nom, String lieu, String description) {
        this.nom = nom;
        this.lieu = lieu;
        this.description = description;
    }
    
    public Logement(int idLog) {
        this.idLog = idLog;
    }

    public int getIdLog() { 
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDesc() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getNbrTTchamb() {
        return nbrTTchamb;
    }

    public void setNbrTTchamb(int nbrTTchamb) {
        this.nbrTTchamb = nbrTTchamb;
    }
    
    public int getPrixNuite() {
        return prixNuite;
    }

    public void setPrixNuite(int prixNuite) {
        this.prixNuite = prixNuite;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "\nLogement{" + "idLogement=" + idLog + ", nom=" + nom + ", lieu=" + lieu + ", description=" + description 
                + ", nbrTTchamb=" + nbrTTchamb + ", prixNuite=" + prixNuite + ", image=" + img + '}';
    }
    
}
