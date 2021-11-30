package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.ProductEntity;
import com.solidsystems.siss.dao.model.SaleEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class ProductConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository, SaleRepository saleRepository){
        return  args -> {
            productRepository.saveAll(List.of(new ProductEntity("Coffee", 150)));
            productRepository.saveAll(List.of(new ProductEntity("Tea", 200)));
            productRepository.saveAll(List.of(new ProductEntity("Milk", 250)));

            saleRepository.saveAll(List.of(new SaleEntity(new Date(), List.of(new ProductEntity("Cookies", 100)), 1)));
        };
    }
}
