/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;


import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IServiceResLog<T> {
    void ajouterResLog(T t) throws SQLException;
    void deleteResLog(T t) throws SQLException;
    void updateResLog(T t) throws SQLException;
    int sommeChamb(int idLogg, String dateAA, String dateDD) throws SQLException;
    int nbrChambRestant(int idResLogg, int idLogg, String dateAA, String dateDD) throws SQLException;
   // void rechercher(T t) throws SQLException;
    List<T> trierResLog() throws SQLException;
    List<T> rechercherResLogDateA(String dateAA) throws SQLException;
    List<T> readAllResLog() throws SQLException;
    List<T> readAllAllResLog() throws SQLException;   
    List<T> PdfResLog() throws SQLException, DocumentException, FileNotFoundException;
}
