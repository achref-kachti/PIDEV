/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;

/**
 *
 * @author nature
 */
public class ReservationPersonnel {
    private int id_reservation;
    private String date_db_res;
    private String date_fin_res;
    private int id_guide;
    private int reference;

    
    

    public ReservationPersonnel(int id_reservation, String date_db_res, String date_fin_res, int id_guide,int reference) {
        this.id_reservation = id_reservation;
        this.date_db_res = date_db_res;
        this.date_fin_res = date_fin_res;
        this.id_guide = id_guide;
        this.reference= reference;
        
    }

    public ReservationPersonnel(String date_db_res, String date_fin_res,int id_guide,int reference) {
         this.date_db_res = date_db_res;
        this.date_fin_res = date_fin_res;
        this.id_guide = id_guide;
        this.reference= reference;
    }

 
   
    public int getId() {
        return id_reservation;
    }

    public void setId(int id_reservation) {
        this.id_reservation= id_reservation;
    }
    public int getId_guide() {
        return id_guide;
    }

    public void setId_guide(int id_guide) {
        this.id_guide= id_guide;
    }
    public String getDatedb() {
        return date_db_res;
    }

    public void setDatedb(String date_db_res) {
        this.date_db_res= date_db_res;
    }

    public String getDatefin() {
        return date_db_res;
    }

    public void setDatefin(String date_fin_res) {
        this.date_fin_res= date_fin_res;
    }
     public void setReference(int reference) {
        this.reference = reference;
    }

    public int getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return "\nGuide{" + "id reservation =" + id_reservation + ", date de la début du reservation=" + date_fin_res + ", date de la fin du reservation =" + date_fin_res + ", Id du guide =" + id_guide + ", reference =" + reference + '}';
    }
    
}
