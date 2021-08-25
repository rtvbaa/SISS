package com.solidsystems.siss.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Sale {
    @Setter
    @Getter
    @JsonProperty("id")
    private Long id;

}
