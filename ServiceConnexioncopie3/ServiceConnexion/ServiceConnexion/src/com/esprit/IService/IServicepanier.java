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
 * @param <T>
 */
public interface IServicepanier<T>{ 
    public boolean panierexiste(int  reference, int id) throws SQLException;
     void ajouterach(T t) throws SQLException;
    //void supprimerach(T t) throws SQLException;
    //int delete_mat(int refmat) throws SQLException;
    void modifierach(T t,int id) throws SQLException;
    List<T> afficherlisteach() throws SQLException;
  //  List<T> trierach() throws SQLException;
    List<T> rechercheach(String s) throws SQLException;
    double calcultotal(int id) throws SQLException;
    
}
