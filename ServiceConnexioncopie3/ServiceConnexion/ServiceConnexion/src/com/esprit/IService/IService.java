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
 * @author sarah
 */
public interface IService<T> {
    void ajoutermat(T t) throws SQLException;
    void supprimermat(T t) throws SQLException;
    int delete_mat(int refmat) throws SQLException;
    void modifiermat(T t,int id) throws SQLException;
    List<T> afficherlistemat() throws SQLException;
    List<T> triermat() throws SQLException;
    List<T> recherchemat(String s) throws SQLException;
    
}
