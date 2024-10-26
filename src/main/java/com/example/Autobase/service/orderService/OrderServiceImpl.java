package com.example.Autobase.service.orderService;

import com.example.Autobase.DAO.OrderRepository;
import com.example.Autobase.DTO.OrderDTO;
import com.example.Autobase.converter.DTOConverter;
import com.example.Autobase.model.CargoType;
import com.example.Autobase.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DTOConverter dtoConverter;


    @Override
    public void save(Order order)
    {
        orderRepository.save(order);
    }

    @Override
    public int[] saveOrdersList(List<Order> orders)
    {
        orderRepository.saveAll(orders);
        return new int[0];
    }

    @Override
    public void update(Order order)
    {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order)
    {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findAll()
    {
        return orderRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        orderRepository.deleteAll();
    }


    @Override
    public Optional<Order> findById(int id)
    {
        return orderRepository.findById(id);
    }

    @Override
    public float getTotalPrice(Order order)
    {
        CargoType cargoType = order.getCargoType();
        if (cargoType == null) {
            return -1;
        }
        return cargoType.getPrice() * order.getWeight();
    }

    @Override
    public List<Order> findNewOrders()
    {
        return orderRepository.findByFlightIsFalse();
    }

    @Override
    public List<OrderDTO> findAllDto()
    {
        return getOrdersDto(orderRepository.findAll());
    }

    private List<OrderDTO> getOrdersDto(List<Order> orders)
    {
        return orders.stream()
                .map(dtoConverter::convertToOrderDTO)
                .collect(Collectors.toList());
    }
}
