package com.simulation.chiken_farm.service;

import com.simulation.chiken_farm.dto.request.DailyHarvestRequest;
import com.simulation.chiken_farm.dto.request.SummaryRequest;
import com.simulation.chiken_farm.dto.response.DailyHarvestResponse;
import com.simulation.chiken_farm.dto.response.SummaryResponse;
import com.simulation.chiken_farm.model.DailyHarvest;
import com.simulation.chiken_farm.repository.DailyHarvestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HarvestService {
    private final DailyHarvestRepository dailyHarvestRepository;

    public HarvestService(DailyHarvestRepository dailyHarvestRepository){
        this.dailyHarvestRepository = dailyHarvestRepository;
    }

    public DailyHarvestResponse inputDailyHarvest(DailyHarvestRequest request){
        DailyHarvest dailyHarvest = new DailyHarvest();
        dailyHarvest.setHarvestDate(new Date());
        dailyHarvest.setLotsOfEggs(request.getLotsOfEggs());
        dailyHarvest.setLatestPrices(request.getLatestPrices());
        dailyHarvest.setDailyIncome(request.getLotsOfEggs() * request.getLatestPrices());
        DailyHarvest savedDailyHarvest =  dailyHarvestRepository.save(dailyHarvest);

        DailyHarvestResponse response = new DailyHarvestResponse();
        response.setHarvestDate(savedDailyHarvest.getHarvestDate());
        response.setDailyIncome(savedDailyHarvest.getDailyIncome());
        return response;
    }

    public SummaryResponse getSummaryHarvest(SummaryRequest request){
        Date startDate = request.getStartDate();
        Date endDate = request.getEndDate();

        List<DailyHarvest> harvests = dailyHarvestRepository.findByHarvestDateBetween(startDate, endDate);

        Map<Date, List<DailyHarvest>> groupedByDate = harvests.stream()
                .collect(Collectors.groupingBy(DailyHarvest::getHarvestDate));

        Integer totalDays = groupedByDate.size();
        Integer totalEggs = groupedByDate.values().stream()
                .flatMap(List::stream)
                .mapToInt(DailyHarvest::getLotsOfEggs)
                .sum();

        Integer totalIncome = groupedByDate.values().stream()
                .flatMap(List::stream)
                .mapToInt(DailyHarvest::getDailyIncome)
                .sum();

        Integer averageEggsPerDay = totalDays == 0 ? 0 : totalEggs / totalDays;
        Integer averageIncomePerDay = totalDays == 0 ? 0 : totalIncome / totalDays;

        SummaryResponse response = new SummaryResponse();
        response.setStartDate(startDate);
        response.setEndDate(endDate);
        response.setTotalDays(totalDays);
        response.setTotalEggs(totalEggs);
        response.setAverageEggsPerDay(averageEggsPerDay);
        response.setTotalIncome(totalIncome);
        response.setAverageIncomePerDay(averageIncomePerDay);

        return response;
    }
}
