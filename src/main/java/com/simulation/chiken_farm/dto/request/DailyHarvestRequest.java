package com.simulation.chiken_farm.dto.request;

import lombok.Data;

@Data
public class DailyHarvestRequest {
    private Integer lotsOfEggs;
    private Integer latestPrices;
}
