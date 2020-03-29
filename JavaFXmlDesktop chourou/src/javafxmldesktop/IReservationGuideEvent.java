/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;



import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nature
 * @param <T>
 */
public interface IReservationGuideEvent <T> {
    //void ajouter(T t) throws SQLException;
    public int ajout_reservation(ReservationGuideEvent r) throws SQLException;
    void supprimer (String reference) ;
    void update(ReservationGuideEvent g,String nom, String prenom) ;
    public List<ReservationGuideEvent> readAll() throws SQLException;
    List<T> trier() throws SQLException;
    
}
