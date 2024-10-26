package com.example.Autobase.controller;

import com.example.Autobase.model.Car;
import com.example.Autobase.model.Driver;
import com.example.Autobase.model.Flight;
import com.example.Autobase.service.carService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/create-car")
    public String showCarForm(Model model)
    {
        model.addAttribute("car", new Car());
        return "create-car";
    }

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute("car") Car car)
    {
        carService.save(car);
        return "redirect:/cars";
    }
}
