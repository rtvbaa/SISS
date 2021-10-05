package com.solidsystems.siss.dao.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class SaleEntity extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    Date saleDate;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "SALE_PRODUCTS",
            joinColumns = @JoinColumn(name = "SALE_ID"),
            inverseJoinColumns = @JoinColumn(name = "Product_ID")
    )
    private Collection<ProductEntity> products;

    @Getter
    @Setter
    long discountId;

    public SaleEntity() {
    }

    public SaleEntity(Date saleDate, long discountId) {
        this.saleDate = saleDate;
        this.discountId = discountId;
    }

    public SaleEntity(Date saleDate, Collection<ProductEntity> products, long discountId) {
        this.saleDate = saleDate;
        this.products = products;
        this.discountId = discountId;
    }
}
