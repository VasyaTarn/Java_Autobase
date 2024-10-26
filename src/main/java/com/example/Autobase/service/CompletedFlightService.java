package com.example.Autobase.service;

import com.example.Autobase.model.Car;
import com.example.Autobase.model.Driver;
import com.example.Autobase.model.Flight;
import com.example.Autobase.model.Order;
import com.example.Autobase.service.carService.CarService;
import com.example.Autobase.service.flightService.FlightService;
import com.example.Autobase.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Autobase.service.driverService.DriverService;

@Service
public class CompletedFlightService {
    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HistoryRecorderService historyRecorderService;

    public void completeFlight(Flight flight)
    {
        if (flightService.isFlightCompleted(flight))
        {
            Order order = flight.getOrder();
            Driver driver = flight.getDriver();
            Car car = flight.getCar();

            float sumFlight = orderService.getTotalPrice(order);
            System.out.println("Sum: " + sumFlight);
            driverService.accrualOfMoney(driver, sumFlight);

            driver.setFree(true);
            driverService.update(driver);

            car.setFree(true);
            carService.update(car);

            historyRecorderService.recordToHistory(order, driver, car, flight, false);

            flightService.delete(flight);
            orderService.delete(order);
        }
    }
}
