package com.solidsystems.siss;

import com.solidsystems.siss.dao.DiscountRepository;
import com.solidsystems.siss.dao.ProductRepository;
import com.solidsystems.siss.dao.model.DiscountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class DiscountScheduler {

    @Autowired
    public DiscountRepository discountRepository;

    @Autowired
    public ProductRepository productRepository;

        private static final String CRON = "0 0 * * * *";

    @Scheduled(cron = CRON)
    public void addProductToDiscount() {
        Date date = new Date();
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setProductId(getRandomProduct());
        discountEntity.setDiscountPercentage((int) (Math.random() * ((10 - 5) + 1)) + 5);
        discountEntity.setDiscountDate(date);
        discountRepository.saveAndFlush(discountEntity);
    }

    private long getRandomProduct() {
        return productRepository.count();
    }
}

