/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGuide;

import entites.ReservationPersonnel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nature
 * @param <T>
 */
public interface IReservationPersonnel <T> {
    void ajouter(T t) throws SQLException;
    void supprimer (int reference) ;
    void update(ReservationPersonnel rp,int id_guide,String date_db_res, String date_fin_res,int referencez) ;
    List<T> readAll() throws SQLException;
    List<T> trier() throws SQLException;
    
}