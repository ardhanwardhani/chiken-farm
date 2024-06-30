package com.simulation.chiken_farm.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class SummaryRequest {
    private Date startDate;
    private Date endDate;
}
