/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author House
 */
public class ResLogement {
    private int idReservationLog;
    private int idLog;
    private String dateA;
    private String dateD;
    private int nbrChamb;
    private int id;
    private String nom;
    private String lieu;
    private int prixNuite;
    private int nbrTTchamb;

    public ResLogement(int idReservationLog, int idLog, String dateA, String dateD, int nbrChamb) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
    }

    public ResLogement(int idLog, String dateA, String dateD, int nbrChamb) {
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
    }
    
    public ResLogement(String dateA, String dateD, int nbrChamb) {
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
    }
    
    public ResLogement(int idReservationLog) {
        this.idReservationLog = idReservationLog;
    }
    
    public ResLogement(int idReservationLog, int idLog) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
    }
    
    public ResLogement(int idLog, String dateA, String dateD) {
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
    }
    
    public ResLogement(int idReservationLog, int idLog, String dateA, String dateD, int nbrChamb, String nom, String lieu, int prixNuite) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.nom = nom;
        this.lieu = lieu;
        this.prixNuite = prixNuite;
    }
    
    public ResLogement(int idReservationLog, int idLog, String dateA, String dateD, int nbrChamb, int id) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.id = id;
    }
    
    
    public ResLogement(int idLog, String dateA, String dateD, int nbrChamb, int id) {
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.id = id;
    }
    
    public ResLogement(String dateA, String dateD, int nbrChamb, int id) {
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.id = id;
    }
    
    
    
    public ResLogement(int idReservationLog, int idLog, int id) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
        this.id = id;
    }
    
    
    
    public ResLogement(int idReservationLog, int idLog, String dateA, String dateD, int nbrChamb, String nom, String lieu, int prixNuite, int id) {
        this.idReservationLog = idReservationLog;
        this.idLog = idLog;
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.nom = nom;
        this.lieu = lieu;
        this.prixNuite = prixNuite;
        this.id = id;
    }
    public ResLogement(String dateA, String dateD, int nbrChamb, String nom, String lieu, int prixNuite) {
       
        this.dateA = dateA;
        this.dateD = dateD;
        this.nbrChamb = nbrChamb;
        this.nom = nom;
        this.lieu = lieu;
        this.prixNuite = prixNuite;
    }

    public ResLogement() {
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

    public int getPrixNuite() {
        return prixNuite;
    }

    public void setPrixNuite(int prixNuite) {
        this.prixNuite = prixNuite;
    }

    public int getNbrTTchamb() {
        return nbrTTchamb;
    }

    public int getIdResLog() {
    return idReservationLog;
    }
    public void setIdResLog(int idReservationLog) {
    this.idReservationLog = idReservationLog;
    }
    public int getIdLog() {
    return idLog;
    }
    public void setIdLog(int idLog) {
    this.idLog = idLog;
    }
    public String getDateA() {
    return dateA;
    }
    public void setDateA(String dateA) {
    this.dateA = dateA;
    }
    public String getDateD() {
    return dateD;
    }
    public void setDateD(String dateD) {
    this.dateD = dateD;
    }
    public int getNbrChamb() {
    return nbrChamb;
    }
    public void setNbrChamb(int nbrChamb) {
    this.nbrChamb = nbrChamb;
    }
    public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }
    /*  public int getNbrTTchamb() {
    return nbrTTchamb;
    }
    public void setNbrTTChamb(int nbrTTchamb) {
    this.nbrTTchamb = nbrTTchamb;
    }*/
    public void setNbrTTchamb(int nbrTTchamb) {
        this.nbrTTchamb = nbrTTchamb;
    }

    @Override
    public String toString() {
        return "\nLes Reservations des Logements {" + "idReservationLog=" + idReservationLog + ",idLog=" + idLog + ", dateArrivee=" + dateA + ", dateDepart=" + dateD + ", Nbr Chambre reservé=" + nbrChamb + ", Nom du logement=" + nom + ", Lieu du logement=" + lieu + ", Prix d une Nuite=" + prixNuite + ",id=" + id + '}';
    }
    
}
