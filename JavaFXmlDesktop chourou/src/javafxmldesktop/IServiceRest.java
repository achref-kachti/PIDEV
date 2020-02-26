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
 * @author House
 */
public interface IServiceRest<T> {
    void ajouterRest(T t) throws SQLException;
    void deleteRest(T t) throws SQLException;
    void updateRest(T t) throws SQLException;
   // void rechercher(T t) throws SQLException;
    List<T> trierRestPlace() throws SQLException;
    List<T> rechercherRestLieu(String lieuu) throws SQLException;
    List<T> readAllRest() throws SQLException;
}

