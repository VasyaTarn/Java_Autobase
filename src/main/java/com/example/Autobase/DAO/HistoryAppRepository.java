package com.example.Autobase.DAO;

import com.example.Autobase.model.HistoryApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HistoryAppRepository extends JpaRepository<HistoryApp, Integer> {

}
