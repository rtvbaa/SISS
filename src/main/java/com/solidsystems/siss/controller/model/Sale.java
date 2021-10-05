package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Sale {
    @Setter
    @Getter
    @JsonProperty("id")
    private Long id;

    @Getter
    @Setter
    Date saleDate;

    @Getter
    @Setter
    long discountId;

    @Getter
    @Setter
    private List<Product> products;

    public Sale() {
    }

    public Sale(Long id, Date saleDate, long discountId) {
        this.id = id;
        this.saleDate = saleDate;
        this.discountId = discountId;
    }

    public Sale(Long id, Date saleDate, long discountId, List<Product> products) {
        this.id = id;
        this.saleDate = saleDate;
        this.discountId = discountId;
        this.products = products;
    }
}
