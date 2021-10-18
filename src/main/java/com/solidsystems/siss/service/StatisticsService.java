package com.solidsystems.siss.service;

import com.solidsystems.siss.controller.model.Statistics;
import com.solidsystems.siss.dao.StatisticsRepository;
import com.solidsystems.siss.dao.model.StatisticsEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public List<Statistics> getHourlyStatistics(){
        List<Statistics> statisticsList = new ArrayList<>();
        for (StatisticsEntity statisticsEntity: statisticsRepository.findAll()) {
            statisticsList.add(new Statistics(statisticsEntity.getStatisticsDate(),
                    statisticsEntity.getNumberOfReceipts(), statisticsEntity.getTotalCostOfReceipts(),
                    statisticsEntity.getTheCostOfAnAverageCheck(), statisticsEntity.getTheAmountOfDiscounts(),
                    statisticsEntity.getTheTotalCostOfReceiptsIncludingDiscounts(),
                    statisticsEntity.getTheCostOfAnAverageReceiptIncludingDiscounts(),
                    statisticsEntity.getTheIncreaseInTheAverageCheckToThePreviousHour()));
        }
        return statisticsList;
    }
}
