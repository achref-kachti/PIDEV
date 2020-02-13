/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IServiceResLog<T> {
    void ajouterRes(T t) throws SQLException;
    void deleteRes(T t) throws SQLException;
    void updateRes(T t) throws SQLException;
    //int nbrChambRest(int idLog) throws SQLException;
   // void rechercher(T t) throws SQLException;
    List<T> trierRes() throws SQLException;
    List<T> rechercherDateA(String dateAA) throws SQLException;
    List<T> readAllRes() throws SQLException;
}
