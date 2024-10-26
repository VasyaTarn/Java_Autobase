package com.example.Autobase.service.flightService;

import com.example.Autobase.DAO.FlightRepository;
import com.example.Autobase.DTO.FlightDTO;
import com.example.Autobase.converter.DTOConverter;
import com.example.Autobase.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private DTOConverter dtoConverter;


    @Override
    public void save(Flight flight)
    {
        flightRepository.save(flight);
    }

    @Override
    public int[] saveFlightsList(List<Flight> flights)
    {
        flightRepository.saveAll(flights);
        return new int[0];
    }

    @Override
    public void update(Flight flight)
    {
        flightRepository.save(flight);
    }

    @Override
    public void delete(Flight flight)
    {
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> findAll()
    {
        return flightRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        flightRepository.deleteAll();
    }


    @Override
    public Optional<Flight> findById(int id)
    {
        return flightRepository.findById(id);
    }

    @Override
    public List<FlightDTO> findAllDto()
    {
        return getFlightsDto(flightRepository.findAll());
    }

    @Override
    public int decrementOneDayWay(Flight flight)
    {
        int curDay = flight.getCountDayWay();
        if (curDay > 0)
        {
            flight.setCountDayWay(curDay - 1);
            flightRepository.save(flight);
            return curDay - 1;
        }

        return 0;
    }

    @Override
    public boolean isFlightCompleted(Flight flight)
    {
        return flight.getCountDayWay() <= 0;
    }


    private List<FlightDTO> getFlightsDto(List<Flight> flights)
    {
        return flights.stream()
                .map(dtoConverter::convertToFlightDTO)
                .collect(Collectors.toList());
    }
}
