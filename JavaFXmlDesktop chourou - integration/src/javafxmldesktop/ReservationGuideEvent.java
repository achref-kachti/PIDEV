/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.util.Objects;

/**
 *
 * @author nature
 */
public class ReservationGuideEvent {
    private int id_reservation_event;
    private int id_guide;
    private int id_event;
    private String titre ="";
    private String nom="";
    private String description="";
    private String type="";
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id_reservation_event;
        hash = 47 * hash + this.id_event;
        hash = 47 * hash + Objects.hashCode(this.titre);
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
        final ReservationGuideEvent other = (ReservationGuideEvent) obj;
        return true;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return "ReservationGuideEvent{" + "id_reservation_event=" + id_reservation_event + ", id_guide=" + id_guide + ", id_event=" + id_event + ", titre=" + titre + '}';
    }
   

   
    
    public ReservationGuideEvent(int id_guide, int id_event) {
        this.id_guide = id_guide;
        this.id_event = id_event;
       
    }
     public ReservationGuideEvent(String titre) {
        this.titre = titre;
       
       
    }
     public ReservationGuideEvent(String titre ,String type ) {
        this.titre = titre;
       this.type =type;
       
    }
    public ReservationGuideEvent(int id_reservation_event, int id_event, String titre) {
        this.id_reservation_event = id_reservation_event;
        this.id_event = id_event;
         this.titre = titre;
       
    }
     public ReservationGuideEvent(String nom, String description, String titre) {
        this.nom = nom;
        this.description = description;
         this.titre = titre;
       
    }
     

  //  public ReservationGuideEvent(int id_reservation_event, int id_guide, int id_event) {
       /* this.id_reservation_event = id_reservation_event;
        this.id_guide = id_guide;
        this.id_event = id_event;*/
       
   /* }*/
    

    public void setId_reservation_event(int id_reservation_event) {
        this.id_reservation_event = id_reservation_event;
    }

    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }


    public int getId_reservation_event() {
        return id_reservation_event;
    }

    public int getId_guide() {
        return id_guide;
    }

    public int getId_event() {
        return id_event;
    }

  
    
}
