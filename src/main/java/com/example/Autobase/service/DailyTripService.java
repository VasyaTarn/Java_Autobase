package com.example.Autobase.service;

import com.example.Autobase.model.Flight;
import com.example.Autobase.service.carService.CarService;
import com.example.Autobase.service.flightService.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DailyTripService {
    @Autowired
    private FlightService flightService;

    @Autowired
    private CompletedFlightService completedFlightService;

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepairCompletionService carRepairCompletionService;


    public void decrementDayInTrip(int idFlight)
    {
        Optional<Flight> flightOptional = flightService.findById(idFlight);

        if(flightOptional.isPresent())
        {
            Flight flight = flightOptional.get();

            int countLeftDayWay = 0;
            int countLeftRepairCarDayWay = 0;

            if(flight.getCar().getBroke())
            {
                countLeftRepairCarDayWay = carService.decrementOneRepairDay(flight.getCar());
            }
            else
            {
                countLeftDayWay = flightService.decrementOneDayWay(flight);
            }

            System.out.println("Decreases by day");

            if (countLeftDayWay <= 0)
            {
                System.out.println("Completed flight");
                completedFlightService.completeFlight(flight);
            }

            if(flight.getCar().getBroke() && countLeftRepairCarDayWay <= 0)
            {
                System.out.println("Completed repair car");
                carRepairCompletionService.repairCompletion(flight.getCar().getId());
            }
        }
    }


}
