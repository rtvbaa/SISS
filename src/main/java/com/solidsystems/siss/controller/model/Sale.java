package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

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
    private Collection<Product> products;

    public Sale() {
    }

    public Sale(Long id, Date saleDate, long discountId) {
        this.id = id;
        this.saleDate = saleDate;
        this.discountId = discountId;
    }

    public Sale(Long id, Date saleDate, long discountId, Collection<Product> products) {
        this.id = id;
        this.saleDate = saleDate;
        this.discountId = discountId;
        this.products = products;
    }
}
