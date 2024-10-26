package com.example.Autobase.DAO;

import com.example.Autobase.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.carrying >= :carrying AND c.isFree = true")
    List<Car> findFreeCarsByCarrying(@Param("carrying") float carrying);

    Optional<Car> findCarById(int id);
}
