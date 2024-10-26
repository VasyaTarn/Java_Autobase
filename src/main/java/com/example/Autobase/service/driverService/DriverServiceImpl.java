package com.example.Autobase.service.driverService;

import com.example.Autobase.DAO.DriverRepository;
import com.example.Autobase.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;


    @Override
    public void save(Driver driver)
    {
        driverRepository.save(driver);
    }

    @Override
    public int[] saveDriversList(List<Driver> drivers)
    {
        driverRepository.saveAll(drivers);
        return new int[0];
    }

    @Override
    public void update(Driver driver)
    {
        driverRepository.save(driver);
    }

    @Override
    public void delete(Driver driver)
    {
        driverRepository.delete(driver);
    }

    @Override
    public List<Driver> findAll()
    {
        return driverRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        driverRepository.deleteAll();
    }


    @Override
    public Optional<Driver> findFreeDriverByExperience(int experience)
    {
        return driverRepository.findFreeDriversByExperience(experience)
                .stream()
                .min(Comparator.comparing(Driver::getExperience));
    }

    @Override
    public void accrualOfMoney(Driver driver, float money)
    {
        if (money <= 0) {
            System.err.println("Money must be greater than zero...");
            return;
        }
        driver.setTotalSum(driver.getTotalSum() + money);
        driverRepository.save(driver);
    }
}
