package com.example.Autobase.DAO;

import com.example.Autobase.model.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CargoTypeRepository extends JpaRepository<CargoType, Integer> {
    Optional<CargoType> findById(int id);
}
