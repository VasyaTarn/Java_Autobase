package com.example.Autobase.service.carService;

import com.example.Autobase.DAO.CarRepository;
import com.example.Autobase.model.Car;
import com.example.Autobase.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(Car car)
    {
        carRepository.save(car);
    }

    @Override
    public int[] saveCarsList(List<Car> cars)
    {
        carRepository.saveAll(cars);
        return new int[0];
    }

    @Override
    public void update(Car car)
    {
        carRepository.save(car);
    }

    @Override
    public void delete(Car car)
    {
        carRepository.delete(car);
    }

    @Override
    public List<Car> findAll()
    {
        return carRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        carRepository.deleteAll();
    }

    @Override
    public Optional<Car> findCarById(int id)
    {
        return carRepository.findCarById(id);
    }

    @Override
    public Optional<Car> findFreeCarByCarrying(float carrying)
    {
        return carRepository.findFreeCarsByCarrying(carrying)
                .stream()
                .min(Comparator.comparing(Car::getCarrying));
    }

    @Override
    public int decrementOneRepairDay(Car car)
    {
        int curDay = car.getTimeToRepair();
        if (curDay > 0)
        {
            car.setTimeToRepair(curDay - 1);
            carRepository.save(car);
            return curDay - 1;
        }

        return 0;
    }
}
