package Restaurant.utilis;





        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import  java.sql.*;
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Salma
     */
    public class connexionDB {
        String url = "jdbc:mysql://localhost:3306/esprit";
        String login = "root";
        String pwd = "";
        public  static connexionDB db;
        public Connection con;
        private connexionDB() {
            try {

                con=DriverManager.getConnection(url, login, pwd);
                System.out.println("connexion etablie");
            } catch (SQLException  ex) {
                System.out.println(ex);
            }
        }

        public Connection  getConnection()
        {
            return con;
        }
        public static connexionDB getInstance()
        {if(db==null)
            db=new connexionDB();
            return db;
        }




    }



