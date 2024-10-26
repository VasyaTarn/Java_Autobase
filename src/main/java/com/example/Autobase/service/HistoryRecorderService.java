package com.example.Autobase.service;

import com.example.Autobase.model.*;
import com.example.Autobase.service.historyAppService.HistoryAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoryRecorderService {
    @Autowired
    private HistoryAppService historyAppService;

    public void recordToHistory(Order order, Driver driver, Car car, Flight flight, boolean carIsBroke)
    {
        CargoType cargoType = order.getCargoType();
        HistoryApp historyApp = new HistoryApp();
        historyApp.setDriverName(driver.getName());
        historyApp.setDriverNumTel(driver.getNumTel());
        historyApp.setCity(order.getCity());
        historyApp.setCargoDriverExp(cargoType.getDriverExp());
        historyApp.setCargoPrice(cargoType.getPrice());
        historyApp.setCargoWeight(order.getWeight());
        historyApp.setCarName(car.getName());
        historyApp.setCarCarrying(car.getCarrying());
        historyApp.setStartDate(flight.getStartDate());

        if(carIsBroke)
        {
            historyApp.setEndDate(null);
        }
        else
        {
            historyApp.setEndDate(LocalDateTime.now());
        }

        historyAppService.save(historyApp);

        System.out.println("History recorded");
    }
}
