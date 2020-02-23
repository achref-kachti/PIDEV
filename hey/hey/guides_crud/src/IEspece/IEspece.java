package IEspece;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.itextpdf.text.DocumentException;
import entites.Espece;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author nature
 * @param <E>
 * @param <T>
 */
public interface IEspece<E> {
    void ajouter(E e) throws SQLException;
    void supprimer (String nomm) ;
      List<E> readAll() throws SQLException;
      List<E> RECHERCHER(String nomm) throws SQLException;
      void update(String nomm,String type, String mode,String lieu,String saison,String Description) ;
       List<E> PdfResLog() throws SQLException, DocumentException, FileNotFoundException ;

 /*   List<T> trier() throws SQLException;
 
*/
}
