package com.example.Autobase.controller;

import com.example.Autobase.model.CargoType;
import com.example.Autobase.model.City;
import com.example.Autobase.service.cargoTypeService.CargoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CargoTypeController {
    @Autowired
    private CargoTypeService cargoTypeService;

    @GetMapping("/cargotypes")
    public String showCargoTypes(Model model) {
        List<CargoType> cargotypes = cargoTypeService.findAll();
        model.addAttribute("cargotypes", cargotypes);
        return "cargotypes";
    }
}
