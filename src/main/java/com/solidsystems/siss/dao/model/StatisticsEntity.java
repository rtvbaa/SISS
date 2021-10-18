package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class StatisticsEntity extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
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

    @Setter
    @Getter
    Integer theIncreaseInTheAverageCheckToThePreviousHour;
}
