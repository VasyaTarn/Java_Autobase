package com.example.Autobase.controller;

import com.example.Autobase.model.CargoType;
import com.example.Autobase.model.City;
import com.example.Autobase.model.Order;
import com.example.Autobase.service.cargoTypeService.CargoTypeService;
import com.example.Autobase.service.cityService.CityService;
import com.example.Autobase.service.orderService.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CargoTypeService cargoTypeService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/create-order")
    public String showOrderForm(Model model)
    {
        List<City> cities = cityService.findAll();
        List<CargoType> cargoTypes = cargoTypeService.findAll();
        Order order = new Order();

        model.addAttribute("order", order);
        model.addAttribute("cities", cities);
        model.addAttribute("cargoTypes", cargoTypes);
        return "create-order";
    }

    @PostMapping("/create-order")
    public String createOrder(@ModelAttribute("order") Order order)
    {
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
