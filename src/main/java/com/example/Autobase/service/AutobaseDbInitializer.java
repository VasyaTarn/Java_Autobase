package com.example.Autobase.service;

import com.example.Autobase.model.*;
import com.example.Autobase.service.carService.CarService;
import com.example.Autobase.service.cargoTypeService.CargoTypeService;
import com.example.Autobase.service.cityService.CityService;
import com.example.Autobase.service.driverService.DriverService;
import com.example.Autobase.service.flightService.FlightService;
import com.example.Autobase.service.historyAppService.HistoryAppService;
import com.example.Autobase.service.orderService.OrderService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutobaseDbInitializer {
    private final Random random = new Random();

    @Value("${data.cities}")
    private String dataCities;

    @Value("${data.cars}")
    private String dataCars;

    @Value("${data.lastnames}")
    private String dataFirstNames;

    @Value("${data.lastnames}")
    private String dataLastnames;

    @Value("${data.cargotypes}")
    private String dataCargoTypes;

    @Autowired
    private CargoTypeService cargoTypeService;

    @Autowired
    private CarService carService;

    @Autowired
    private CityService cityService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private HistoryAppService historyAppService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TextFileReader textFileReader;

    public void deleteAllRows()
    {
        flightService.deleteAll();
        orderService.deleteAll();
        historyAppService.deleteAll();
        cargoTypeService.deleteAll();
        carService.deleteAll();
        cityService.deleteAll();
        driverService.deleteAll();
    }

    public void createCars()
    {
        List<String> carNames = textFileReader.readTextFile(dataCars);

        List<Car> cars = carNames.stream()
                .map(carName -> {
                    float carrying = random.nextInt(1, 10) * 100;
                    return new Car(0, carName, carrying, true, false, 0);
                })
                .toList();
        carService.saveCarsList(cars);
    }

    public void createCargoTypes()
    {
        List<String> cargoTypeNames = textFileReader.readTextFile(dataCargoTypes);

        List<CargoType> cargoTypes = cargoTypeNames.stream()
                .map(cargoTypeName -> {
                    int driverExp = 1 + random.nextInt(10 - 1);
                    float price = random.nextInt(1, 20) * 10;
                    return new CargoType(0, cargoTypeName, driverExp, price);
                })
                .toList();

        cargoTypeService.saveCargoTypesList(cargoTypes);
    }

    public void createDrivers()
    {
        List<String> firstNames = textFileReader.readTextFile(dataFirstNames);
        List<String> lastNames = textFileReader.readTextFile(dataLastnames);

        List<Driver> drivers = firstNames.stream()
                .map(firstName -> {
                    String lastName = lastNames.get(random.nextInt(lastNames.size()));
                    String phone = "+123" + random.nextInt(10000000);
                    int experience = 1 + random.nextInt(30 - 1);
                    return new Driver(0, firstName, lastName, phone, experience, 0, true);
                })
                .toList();
        driverService.saveDriversList(drivers);
    }

    public void createCities()
    {
        List<String> citiesName = textFileReader.readTextFile(dataCities);

        List<City> cities = citiesName.stream()
                .map(cityName -> {
                    float destination = random.nextInt(1, 10) * 100;
                    return new City(0, cityName, destination);
                })
                .toList();
        cityService.saveCitiesList(cities);
    }

    public void createRandomOrders()
    {
        List<City> allCities = cityService.findAll();
        List<CargoType> allCargoTypes = cargoTypeService.findAll();

        List<Order> orders = new ArrayList<>();
        int numberOfOrders = random.nextInt(1, 10);

        for (int i = 0; i < numberOfOrders; i++) {
            float weight = random.nextInt(1, 10) * 100;
            City randomCity = allCities.get(random.nextInt(allCities.size()));
            CargoType randomCargoType = allCargoTypes.get(random.nextInt(allCargoTypes.size()));

            orders.add(new Order(0, randomCity, randomCargoType, weight, false));
        }

        orderService.saveOrdersList(orders);
    }
}
