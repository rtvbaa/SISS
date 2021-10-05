package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class Product {

    @Setter
    @Getter
    @JsonProperty("id")
    private Long id;

    @Setter
    @Getter
    @JsonProperty("productName")
    String productName;

    @Setter
    @Getter
    @JsonProperty("productPrice")
    Integer productPrice;

    public Product() {
    }

    public Product(Long id, String productName, Integer productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
