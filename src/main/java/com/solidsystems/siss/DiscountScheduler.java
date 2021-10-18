package com.solidsystems.siss;

import com.solidsystems.siss.dao.DiscountRepository;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.SaleRepository;
import com.solidsystems.siss.dao.StatisticsRepository;
import com.solidsystems.siss.dao.model.DiscountEntity;
import com.solidsystems.siss.dao.model.StatisticsEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class DiscountScheduler {

    private final DiscountRepository discountRepository;

    private final StatisticsRepository statisticsRepository;

    private final ProductRepository productRepository;

    private final SaleRepository saleRepository;

    public DiscountScheduler(DiscountRepository discountRepository, StatisticsRepository statisticsRepository, ProductRepository productRepository, SaleRepository saleRepository) {
        this.discountRepository = discountRepository;
        this.statisticsRepository = statisticsRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }

    private static final String CRON = "0 0 * * * *";

    Date date = new Date();

    @Scheduled(cron = CRON)
    public void addProductToDiscount() {
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setProductId(getRandomProduct());
        discountEntity.setDiscountPercentage((int) (Math.random() * ((10 - 5) + 1)) + 5);
        discountEntity.setDiscountDate(date);
        discountRepository.saveAndFlush(discountEntity);
    }

    private long getRandomProduct() {
        return (long) ((Math.random() * ((productRepository.count() - 1) + 1)) + 1);
    }

    @Scheduled(cron = CRON)
    public void addStatistics() {
        StatisticsEntity statisticsEntity = new StatisticsEntity();
        statisticsEntity.setStatisticsDate(date);
        statisticsEntity.setNumberOfReceipts(saleRepository.count());
        statisticsRepository.saveAndFlush(statisticsEntity);
    }
}

