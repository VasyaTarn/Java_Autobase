package com.example.Autobase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutobaseInitializer {
    @Autowired
    private AutobaseDbInitializer autobaseDbInitializer;

    public void autoBaseInitialize()
    {
        autobaseDbInitializer.deleteAllRows();
        autobaseDbInitializer.createCities();
        autobaseDbInitializer.createCars();
        autobaseDbInitializer.createDrivers();
        autobaseDbInitializer.createCargoTypes();

        System.out.println("Database initialized successfully");
    }
}
