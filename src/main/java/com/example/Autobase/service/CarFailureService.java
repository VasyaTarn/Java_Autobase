package com.example.Autobase.service;

import com.example.Autobase.model.Car;
import com.example.Autobase.model.Driver;
import com.example.Autobase.model.Flight;
import com.example.Autobase.model.Order;
import com.example.Autobase.service.carService.CarService;
import com.example.Autobase.service.driverService.DriverService;
import com.example.Autobase.service.flightService.FlightService;
import com.example.Autobase.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Random;

@Service
public class CarFailureService {
    private final Random random = new Random();

    @Autowired
    private FlightService flightService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HistoryRecorderService historyRecorderService;


    public void carBrokerDown(int idFlight)
    {
        Optional<Flight> flightOptional = flightService.findById(idFlight);

        if(flightOptional.isPresent())
        {
            Flight flight = flightOptional.get();

            Order order = flight.getOrder();
            Driver driver = flight.getDriver();
            Car car = flight.getCar();

            historyRecorderService.recordToHistory(order, driver, car, flight, true);

            /*flightService.delete(flight);
            orderService.delete(order);*/

            int timeToRepair = random.nextInt(1, 3);
            car.setTimeToRepair(timeToRepair);
            car.setBroke(true);
            /*car.setFree(false);*/
            carService.update(car);

            /*driver.setFree(true);
            driverService.update(driver);*/

            System.out.println("Car broke down");
        }
    }
}
