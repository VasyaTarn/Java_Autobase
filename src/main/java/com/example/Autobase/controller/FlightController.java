package com.example.Autobase.controller;

import com.example.Autobase.model.Flight;
import com.example.Autobase.model.Order;
import com.example.Autobase.service.flightService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public String showFlights(Model model) {
        List<Flight> flights = flightService.findAll();
        model.addAttribute("flights", flights);
        return "flights";
    }
}
