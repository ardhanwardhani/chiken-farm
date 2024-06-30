package com.simulation.chiken_farm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "daily_harvest")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyHarvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lots_of_eggs", nullable = false)
    private Integer lotsOfEggs;

    @Column(name = "latest_prices", nullable = false)
    private Integer latestPrices;

    @Column(name = "daily_income", nullable = false)
    private Integer dailyIncome;

    @Column(name = "harvest_date", nullable = false)
    private Date harvestDate;
}
