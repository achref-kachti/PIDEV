package Restaurant.service;

import Restaurant.Entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    public void ajouterRestaurant(Restaurant r);
    public void modifierRestaurant(Restaurant r);
    public void supprimerRestaurant(Restaurant r);
    public List<Restaurant> afficherRestaurant(Restaurant r);


}
