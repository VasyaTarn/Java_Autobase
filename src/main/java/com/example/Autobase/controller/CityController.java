package com.example.Autobase.controller;

import com.example.Autobase.model.City;
import com.example.Autobase.model.Driver;
import com.example.Autobase.service.cityService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public String showCities(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "cities";
    }
}
