package com.simulation.chiken_farm.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class SummaryResponse {
    private Date startDate;
    private Date endDate;
    private Integer totalDays;
    private Integer totalEggs;
    private Integer averageEggsPerDay;
    private Integer totalIncome;
    private Integer averageIncomePerDay;
}
