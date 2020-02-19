/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author nature
 */
public class ReservationGuideEvent {
    private int id_reservation_event;
    private int id_guide;
    private int id_event;
    private String reference_res_event;

    @Override
    public String toString() {
        return "ServiceReservationGuideEvent{" + "id_reservation_event=" + id_reservation_event + ", id_guide=" + id_guide + ", id_event=" + id_event + ", reference_res_event=" + reference_res_event + '}';
    }

    public ReservationGuideEvent(int id_guide, int id_event, String reference_res_event) {
        this.id_guide = id_guide;
        this.id_event = id_event;
        this.reference_res_event = reference_res_event;
    }

    public ReservationGuideEvent(int id_reservation_event, int id_guide, int id_event, String reference_res_event) {
        this.id_reservation_event = id_reservation_event;
        this.id_guide = id_guide;
        this.id_event = id_event;
        this.reference_res_event = reference_res_event;
    }

    public void setId_reservation_event(int id_reservation_event) {
        this.id_reservation_event = id_reservation_event;
    }

    public void setId_guide(int id_guide) {
        this.id_guide = id_guide;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setReference_res_event(String reference_res_event) {
        this.reference_res_event = reference_res_event;
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

    public String getReference_res_event() {
        return reference_res_event;
    }
    
}
