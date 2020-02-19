package sample;

import Restaurant.Entity.Restaurant;
import Restaurant.service.RestaurantService;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Class.forName;

public class Main {



    public static void main(String[] args) throws ClassNotFoundException {
        forName("com.mysql.jdbc.Driver");

        RestaurantService serv = new RestaurantService();
Restaurant r =new Restaurant("ee","tunis", (float) 5.2 );
        serv.ajouterRestaurant(r);


    }
}
