package com.example.Autobase.service.carService;

import com.example.Autobase.model.Car;
import com.example.Autobase.model.Flight;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void save(Car car);
    int[] saveCarsList(List<Car> cars);
    void update(Car car);
    void delete(Car car);
    List<Car> findAll();
    void deleteAll();

    Optional<Car> findCarById(int id);
    Optional<Car> findFreeCarByCarrying(float carrying);
    int decrementOneRepairDay(Car car);

}
