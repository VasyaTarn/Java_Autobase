package com.example.Autobase.controller;

import com.example.Autobase.model.Driver;
import com.example.Autobase.model.Flight;
import com.example.Autobase.service.driverService.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public String showDriver(Model model)
    {
        List<Driver> drivers = driverService.findAll();
        model.addAttribute("drivers", drivers);
        return "drivers";
    }

    @GetMapping("/create-driver")
    public String showDriverForm(Model model)
    {
        model.addAttribute("driver", new Driver());
        return "create-driver";
    }

    @PostMapping("/create-driver")
    public String createDriver(@ModelAttribute("driver") Driver driver)
    {
        driverService.save(driver);
        return "redirect:/drivers";
    }
}
