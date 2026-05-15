package com.example.brothers.Service;

import com.example.brothers.Entity.Restaurant;
import java.util.List;

public interface RestaurantService {

    Restaurant createRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getOpenRestaurants();

    List<Restaurant> getRestaurantsByOwner(Long ownerId);
}