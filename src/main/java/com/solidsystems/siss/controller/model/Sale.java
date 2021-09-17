package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Product> products = new HashSet<>();
}
