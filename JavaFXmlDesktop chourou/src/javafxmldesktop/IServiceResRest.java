/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmldesktop;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IServiceResRest<T> {
    void ajouterResRest(T t) throws SQLException;
    void deleteResRest(T t) throws SQLException;
    void updateResRest(T t) throws SQLException;
    //int nbrChambRest(int idLog) throws SQLException;
   // void rechercher(T t) throws SQLException;
    List<T> trierResRest() throws SQLException;
    List<T> rechercherResRestDateR(String dateRR) throws SQLException;
    List<T> readAllResRest() throws SQLException;
    List<T> readAllAllResRest() throws SQLException;
}
