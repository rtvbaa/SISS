package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ProductEntity extends BaseEntity {

    @Column(unique = true)
    @Getter
    @Setter
    String productName;

    @Basic(fetch = FetchType.LAZY)
    @Getter
    @Setter
    Integer productPrice;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "products")
    private Collection<SaleEntity> sales;

    public ProductEntity() {
    }

    public ProductEntity(String productName, Integer productPrice, Collection<SaleEntity> sales) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.sales = sales;
    }
}
