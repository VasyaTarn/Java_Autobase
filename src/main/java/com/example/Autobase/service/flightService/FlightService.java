package com.example.Autobase.service.flightService;

import com.example.Autobase.DTO.FlightDTO;
import com.example.Autobase.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    void save(Flight flight);
    int[] saveFlightsList(List<Flight> flights);
    void update(Flight flight);
    void delete(Flight flight);
    List<Flight> findAll();
    void deleteAll();

    Optional<Flight> findById(int id);
    List<FlightDTO> findAllDto();
    int decrementOneDayWay(Flight flight);
    boolean isFlightCompleted(Flight flight);
}
