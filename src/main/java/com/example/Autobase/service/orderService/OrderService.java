package com.example.Autobase.service.orderService;

import com.example.Autobase.DTO.OrderDTO;
import com.example.Autobase.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void save(Order order);
    int[] saveOrdersList(List<Order> orders);
    void update(Order order);
    void delete(Order order);
    List<Order> findAll();
    void deleteAll();

    Optional<Order> findById(int id);
    float getTotalPrice(Order order);
    List<Order> findNewOrders();
    List<OrderDTO> findAllDto();
}
