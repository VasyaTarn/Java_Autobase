package com.example.Autobase.DAO;

import com.example.Autobase.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findById(int id);
}
