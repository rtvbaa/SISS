package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Getter
    @Setter
    private List<Sale> sales;

    public Product() {
    }

    public Product(Long id, String productName, Integer productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(Long id, String productName, Integer productPrice, List<Sale> sales) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.sales = sales;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", sales=" + sales +
                '}';
    }
}
