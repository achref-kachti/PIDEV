package Restaurant.service;

import Restaurant.Entity.Restaurant;
import Restaurant.utilis.connexionDB;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantService implements IRestaurantService {
    Connection myConnex;
    Statement ste;

    public RestaurantService() {

            myConnex = connexionDB.getInstance().getConnection();

    }

    @Override
    public void ajouterRestaurant(Restaurant r) {
        try {
            String req = "INSERT INTO restaurant (`id`, `nom`, `lieu`, `rate`) " + "Values (NULL, '" + r.getNom() + "', '" + r.getLieu()+ "', '" + r.getRate() + "');";
        } catch (Exception e) {
            Logger.getLogger( RestaurantService.class.getName() ).log( Level.SEVERE, null, e );
        }
    }

    @Override
    public void modifierRestaurant(Restaurant r) {
        try {
            String req =
                    "update  INTO restaurant"
                            + " "
                            + "";

            ste.executeUpdate( req );
        } catch (SQLException e) {
            Logger.getLogger( RestaurantService.class.getName() ).log( Level.SEVERE, null, e );
        }
    }



    @Override
    public void supprimerRestaurant(Restaurant r) {

        try {
            String req2 = "delete from restaurant where id=?";
            PreparedStatement ps = myConnex.prepareStatement( req2 );
            ps.setInt( 1, r.getId() );
            ps.executeQuery();
        } catch (Exception e) {
            Logger.getLogger( RestaurantService.class.getName() ).log( Level.SEVERE, null, e );
        }
    }



    @Override
    public List<Restaurant> afficherRestaurant(Restaurant r) {
        try {
            String req3 = "select * from restaurant";
            ResultSet res = ste.executeQuery( req3 );
            while (res.next()) {
                r.toString();
            }
        } catch (SQLException e) {
            Logger.getLogger( RestaurantService.class.getName() ).log( Level.SEVERE, null, e );
        }
        return null;
    }
}