package com.example.Autobase.DAO;

import com.example.Autobase.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("SELECT d FROM Driver d WHERE d.experience >= :experience AND d.isFree = true")
    List<Driver> findFreeDriversByExperience(@Param("experience") int experience);

    Optional<Driver> findById(int driverId);
}
