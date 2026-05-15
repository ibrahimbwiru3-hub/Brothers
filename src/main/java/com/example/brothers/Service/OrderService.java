package com.example.brothers.Service;

import com.example.brothers.Entity.Order;
import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);

    List<Order> getOrdersByUser(Long userId);

    List<Order> getOrdersByRestaurant(Long restaurantId);

    Order updateStatus(Long orderId, String status);
}