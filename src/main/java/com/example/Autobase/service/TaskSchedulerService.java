package com.example.Autobase.service;

import com.example.Autobase.model.Flight;
import com.example.Autobase.model.Order;
import com.example.Autobase.service.flightService.FlightService;
import com.example.Autobase.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskSchedulerService {
    private final Random random = new Random();
    private boolean initializationComplete = false;

    @Autowired
    private AutobaseDbInitializer autobaseDbInitializer;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightSenderService flightSenderService;

    @Autowired
    private DailyTripService dailyTripService;

    @Autowired
    private CarFailureService carFailureService;

    public void setInitializationComplete() {
        this.initializationComplete = true;
    }

    @Scheduled(fixedRate = 30000)
    public void simulateTask()
    {
        if (!initializationComplete) {
            System.out.println("Инициализация еще не завершена, пропуск задачи");
            return;
        }

        System.out.println("Выполнение задачи");

        if(random.nextBoolean())
        {
            autobaseDbInitializer.createRandomOrders();
        }

        for(Order order : orderService.findAll())
        {
            flightSenderService.sendFlight(order.getId());
        }

        for (Flight flight : flightService.findAll())
        {
            dailyTripService.decrementDayInTrip(flight.getId());
            if(random.nextInt(100) < 10)
            {
                carFailureService.carBrokerDown(flight.getId());
            }
        }
    }
}
