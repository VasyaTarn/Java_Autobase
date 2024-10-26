package com.example.Autobase.DAO;

import com.example.Autobase.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findById(int id);
}
