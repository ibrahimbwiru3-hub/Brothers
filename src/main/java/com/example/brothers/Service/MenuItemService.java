package com.example.brothers.Service;

import com.example.brothers.Entity.MenuItem;
import java.util.List;

public interface MenuItemService {

    MenuItem createMenuItem(MenuItem menuItem);

    List<MenuItem> getAllMenuItems();

    List<MenuItem> getByRestaurant(Long restaurantId);

    List<MenuItem> getAvailableItems();
}