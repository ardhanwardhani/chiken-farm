package com.simulation.chiken_farm.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class DailyHarvestResponse {
    private Date harvestDate;
    private Integer dailyIncome;
}
