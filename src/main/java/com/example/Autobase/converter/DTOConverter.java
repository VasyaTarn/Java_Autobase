package com.example.Autobase.converter;

import com.example.Autobase.DTO.FlightDTO;
import com.example.Autobase.DTO.OrderDTO;
import com.example.Autobase.model.*;
import org.springframework.stereotype.Service;

@Service
public class DTOConverter {
    public OrderDTO convertToOrderDTO(Order order)
    {
        City city = order.getCity();
        CargoType cargoType = order.getCargoType();

        return new OrderDTO(order.getId(), city.getName(), city.getDestination(), cargoType.getName(), cargoType.getPrice(), order.getWeight(), order.getIsFlight());
    }

    public FlightDTO convertToFlightDTO(Flight flight) {
        Order order = flight.getOrder();
        City city = order.getCity();
        Car car = flight.getCar();
        Driver driver = flight.getDriver();
        CargoType cargoType = order.getCargoType();

        return new FlightDTO(flight.getId(), city.getName(), city.getDestination(), cargoType.getName(), order.getWeight(), driver.getName() + " " + driver.getSurname(), car.getName(), flight.getCountDayWay());
    }
}
