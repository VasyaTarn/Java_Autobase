package com.example.Autobase.DAO;

import com.example.Autobase.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findById(int id);

    @Query("SELECT o FROM Order o WHERE o.isFlight = false")
    List<Order> findByFlightIsFalse();
}
