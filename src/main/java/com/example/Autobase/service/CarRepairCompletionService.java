package com.example.Autobase.service;

import com.example.Autobase.model.Car;
import com.example.Autobase.service.carService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarRepairCompletionService {
    @Autowired
    private CarService carService;

    public void repairCompletion(int carId)
    {
        Optional<Car> carOptional = carService.findCarById(carId);

        if (carOptional.isPresent())
        {
            Car car = carOptional.get();

            /*car.setFree(true);*/
            car.setBroke(false);
            car.setTimeToRepair(0);

            carService.update(car);

            System.out.println("Car repair completed");
        }
    }
}
