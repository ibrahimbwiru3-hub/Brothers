package com.example.brothers.ServiceImpl;

import com.example.brothers.Entity.Restaurant;
import com.example.brothers.Repository.RestaurantRepository;
import com.example.brothers.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {

        restaurant.setCreatedAt(LocalDateTime.now());
        restaurant.setIsOpen(true);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getOpenRestaurants() {
        return restaurantRepository.findByIsOpenTrue();
    }

    @Override
    public List<Restaurant> getRestaurantsByOwner(Long ownerId) {
        return restaurantRepository.findByOwnerId(ownerId);
    }
}