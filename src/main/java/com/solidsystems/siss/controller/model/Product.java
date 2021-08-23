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
    @JsonProperty("name")
    String name;

    @Setter
    @Getter
    @JsonProperty("productDescription")
    String productDescription;

    public Product() {
    }

    public Product(Long id, String name, String productDescription) {
        this.id = id;
        this.name = name;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
