package com.solidsystems.siss.dao;

import com.solidsystems.siss.dao.model.ProductEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return  args -> {
            productRepository.saveAll(List.of(new ProductEntity("Coffee", 150)));
            productRepository.saveAll(List.of(new ProductEntity("Tea", 200)));
            productRepository.saveAll(List.of(new ProductEntity("Milk", 250)));
        };
    }
}
