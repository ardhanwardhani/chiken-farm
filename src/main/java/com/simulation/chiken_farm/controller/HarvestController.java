package com.simulation.chiken_farm.controller;

import com.simulation.chiken_farm.dto.request.DailyHarvestRequest;
import com.simulation.chiken_farm.dto.request.SummaryRequest;
import com.simulation.chiken_farm.dto.response.DailyHarvestResponse;
import com.simulation.chiken_farm.dto.response.SummaryResponse;
import com.simulation.chiken_farm.service.HarvestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/harvest")
public class HarvestController {
    private final HarvestService harvestService;

    public HarvestController(HarvestService harvestService){
        this.harvestService = harvestService;
    }

    @PostMapping("/daily-harvest")
    public ResponseEntity<DailyHarvestResponse> inputDailyHarvest(@RequestBody DailyHarvestRequest request){
        DailyHarvestResponse response = harvestService.inputDailyHarvest(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/summary-harvest")
    public ResponseEntity<SummaryResponse> getSummaryResponse(@RequestBody SummaryRequest request){
        SummaryResponse response = harvestService.getSummaryHarvest(request);
        return ResponseEntity.ok(response);
    }
}
