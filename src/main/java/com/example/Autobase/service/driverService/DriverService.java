package com.example.Autobase.service.driverService;

import com.example.Autobase.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    void save(Driver driver);
    int[] saveDriversList(List<Driver> drivers);
    void update(Driver driver);
    void delete(Driver driver);
    List<Driver> findAll();
    void deleteAll();

    Optional<Driver> findFreeDriverByExperience(int experience);
    void accrualOfMoney(Driver driver, float money);
}
