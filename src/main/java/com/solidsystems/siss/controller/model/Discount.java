package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Discount {
    @Setter
    @Getter
    @JsonProperty("id")
    private Long id;

    @Setter
    @Getter
    @JsonProperty("discountPercentage")
    private Integer discountPercentage;

    @Getter
    @Setter
    @JsonProperty("discountDate")
    Date discountDate;

    @Setter
    @Getter
    @JsonProperty("productId")
    Long productId;
}
