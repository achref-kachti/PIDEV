/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.sql.Date;

/**
 *
 * @author House
 */
public class ResRestaurant {
    private int idReservationRest;
    private int idRest;
    private String dateR;
    private int nbrPlace;
    private String nomRest="";
    private String lieuRest="";

    public ResRestaurant(int idReservationRest, int idRest, String dateR, int nbrPlace) {
        this.idReservationRest = idReservationRest;
        this.idRest = idRest;
        this.dateR = dateR;
        this.nbrPlace = nbrPlace;
    }

    public ResRestaurant(int idRest, String dateR, int nbrPlace) {
        this.idRest = idRest;
        this.dateR = dateR;
        this.nbrPlace = nbrPlace;
    }
    
    public ResRestaurant(String dateR, int nbrPlace) {
        this.dateR = dateR;
        this.nbrPlace = nbrPlace;
    }
    
    public ResRestaurant(int idReservationRest) {
        this.idReservationRest = idReservationRest;
    }
    
    public ResRestaurant(int idReservationRest, int idRest, String dateR, int nbrPlace, String nomRest, String lieuRest) {
        this.idReservationRest = idReservationRest;
        this.idRest = idRest;
        this.dateR = dateR;
        this.nbrPlace = nbrPlace;
        this.nomRest = nomRest;
        this.lieuRest = lieuRest;
    }
    
    

    public int getIdResRest() { 
        return idReservationRest;
    }

    public void setIdResRest(int idReservationRest) {
        this.idReservationRest = idReservationRest;
    }
    
    public int getIdRest() { 
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    @Override
    public String toString() {
        return "\nLes Reservations des Restaurants {" + "idReservationRest=" + idReservationRest + ",idRest=" + idRest + ", dateReservation=" + dateR + ", Nbr Place reservé=" + nbrPlace + ", Nom du Restaurant=" + nomRest + ", Lieu du Restaurant=" + lieuRest +'}';
    }
    
}
