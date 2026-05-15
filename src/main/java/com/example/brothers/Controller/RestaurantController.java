package com.example.brothers.Controller;

import com.example.brothers.Entity.Restaurant;
import com.example.brothers.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    // CREATE RESTAURANT
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    // GET ALL
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // GET OPEN RESTAURANTS
    @GetMapping("/open")
    public List<Restaurant> getOpenRestaurants() {
        return restaurantService.getOpenRestaurants();
    }

    // GET BY OWNER
    @GetMapping("/owner/{ownerId}")
    public List<Restaurant> getByOwner(@PathVariable Long ownerId) {
        return restaurantService.getRestaurantsByOwner(ownerId);
    }
}