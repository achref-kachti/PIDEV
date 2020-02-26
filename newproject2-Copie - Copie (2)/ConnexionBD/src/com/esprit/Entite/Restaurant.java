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
public class Restaurant {
    private int idRest;
    private String nomRest;
    private String lieuRest;
    private String descriptionRest;
    private int nbrTTplace;
    private String imgRest;

    public Restaurant(int idRest, String nomRest, String lieuRest, String descriptionRest, int nbrTTplace, String imgRest) {
        this.idRest = idRest;
        this.nomRest = nomRest;
        this.lieuRest = lieuRest;
        this.descriptionRest = descriptionRest;
        this.nbrTTplace = nbrTTplace;
        this.imgRest = imgRest;
    }

    public Restaurant(String nomRest, String lieuRest, String descriptionRest, int nbrTTplace, String imgRest) {
        this.nomRest = nomRest;
        this.lieuRest = lieuRest;
        this.descriptionRest = descriptionRest;
        this.nbrTTplace = nbrTTplace;
        this.imgRest = imgRest;
    }
    
    public Restaurant(int idRest) {
        this.idRest = idRest;
    }

    public int getIdRest() { 
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public String getNomRest() {
        return nomRest;
    }

    public void setNomRest(String nomRest) {
        this.nomRest = nomRest;
    }

    public String getLieuRest() {
        return lieuRest;
    }

    public void setLieuRest(String lieuRest) {
        this.lieuRest = lieuRest;
    }

    public String getDescRest() {
        return descriptionRest;
    }

    public void setDescRest(String descriptionRest) {
        this.descriptionRest = descriptionRest;
    }
    
    public int getNbrTTplace() {
        return nbrTTplace;
    }

    public void setNbrTTplace(int nbrTTplace) {
        this.nbrTTplace = nbrTTplace;
    }
    
    public String getImgRest() {
        return imgRest;
    }

    public void setImgRest(String imgRest) {
        this.imgRest = imgRest;
    }

    @Override
    public String toString() {
        return "\nRestaurant{" + "idRestaurant=" + idRest + ", nomRest=" + nomRest + ", lieuRest=" + lieuRest + ", descriptionRest=" + descriptionRest 
                + ", nbrTTplace=" + nbrTTplace + ", imageRest=" + imgRest + '}';
    }
    
}
