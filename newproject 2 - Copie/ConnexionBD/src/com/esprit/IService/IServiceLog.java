/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IServiceLog<T> {
    void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
    void update(T t) throws SQLException;
   // void rechercher(T t) throws SQLException;
    List<T> trier() throws SQLException;
    List<T> rechercherLieu(String lieuu) throws SQLException;
    List<T> readAll() throws SQLException;
}
