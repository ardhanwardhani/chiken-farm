package com.simulation.chiken_farm.repository;

import com.simulation.chiken_farm.model.DailyHarvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DailyHarvestRepository extends JpaRepository<DailyHarvest, Long> {
    List<DailyHarvest> findByHarvestDateBetween(Date startDate, Date endDate);
}
