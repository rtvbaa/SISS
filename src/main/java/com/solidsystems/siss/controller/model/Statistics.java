package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Statistics {
    @Setter
    @Getter
    @JsonProperty("id")
    private Long id;

    @Getter
    @Setter
    Date statisticsDate;

    @Setter
    @Getter
    Long numberOfReceipts;

    @Setter
    @Getter
    Integer totalCostOfReceipts;

    @Setter
    @Getter
    Integer theCostOfAnAverageCheck;

    @Setter
    @Getter
    Integer theAmountOfDiscounts;

    @Setter
    @Getter
    Integer theTotalCostOfReceiptsIncludingDiscounts;

    @Setter
    @Getter
    Integer theCostOfAnAverageReceiptIncludingDiscounts;

    public Statistics(Date statisticsDate, Long numberOfReceipts, Integer totalCostOfReceipts,
                      Integer theCostOfAnAverageCheck, Integer theAmountOfDiscounts,
                      Integer theTotalCostOfReceiptsIncludingDiscounts,
                      Integer theCostOfAnAverageReceiptIncludingDiscounts,
                      Integer theIncreaseInTheAverageCheckToThePreviousHour) {
        this.statisticsDate = statisticsDate;
        this.numberOfReceipts = numberOfReceipts;
        this.totalCostOfReceipts = totalCostOfReceipts;
        this.theCostOfAnAverageCheck = theCostOfAnAverageCheck;
        this.theAmountOfDiscounts = theAmountOfDiscounts;
        this.theTotalCostOfReceiptsIncludingDiscounts = theTotalCostOfReceiptsIncludingDiscounts;
        this.theCostOfAnAverageReceiptIncludingDiscounts = theCostOfAnAverageReceiptIncludingDiscounts;
        this.theIncreaseInTheAverageCheckToThePreviousHour = theIncreaseInTheAverageCheckToThePreviousHour;
    }

    @Setter
    @Getter
    Integer theIncreaseInTheAverageCheckToThePreviousHour;
}
