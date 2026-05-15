package com.example.brothers.ServiceImpl;

import com.example.brothers.Entity.Order;
import com.example.brothers.Entity.OrderItem;
import com.example.brothers.Entity.OrderStatus;
import com.example.brothers.Repository.OrderRepository;
import com.example.brothers.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            item.setOrder(order);

            total += item.getPrice() * item.getQuantity();
        }

        order.setTotalPrice(total);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByRestaurant(Long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Order updateStatus(Long orderId, String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(OrderStatus.valueOf(status));

        return orderRepository.save(order);
    }
}