package com.example.Autobase.service;

import com.example.Autobase.model.*;
import com.example.Autobase.service.carService.CarService;
import com.example.Autobase.service.driverService.DriverService;
import com.example.Autobase.service.flightService.FlightService;
import com.example.Autobase.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightSenderService {
    private final int averageCarSpeed = 70;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    public void sendFlight(int orderId)
    {
        Optional<Order> orderOptional = orderService.findById(orderId);

        if(orderOptional.isPresent())
        {
            Order order = orderOptional.get();

            CargoType cargoType = order.getCargoType();
            City city = order.getCity();

            Optional<Car> carOptional = carService.findFreeCarByCarrying(order.getWeight());
            if(carOptional.isPresent())
            {
                Car car = carOptional.get();

                Optional<Driver> driverOptional = driverService.findFreeDriverByExperience(cargoType.getDriverExp());
                if(driverOptional.isPresent())
                {
                    Driver driver = driverOptional.get();

                    int countDayWay = (int) Math.ceil(city.getDestination() / averageCarSpeed);

                    Flight flight = new Flight(0, order, car, driver, countDayWay, LocalDateTime.now());
                    flightService.save(flight);

                    driver.setFree(false);
                    driverService.update(driver);

                    car.setFree(false);
                    carService.update(car);

                    order.setFlight(true);
                    orderService.update(order);

                    System.out.println("Flight sent");
                }
            }

        }
    }
}
