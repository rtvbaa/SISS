package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DiscountEntity extends BaseEntity {

    @Setter
    @Getter
    Integer discountPercentage;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    Date discountDate;

    @Setter
    @Column(updatable = false)
    @Getter
    Long productId;

    public DiscountEntity() {
    }

    public DiscountEntity(Integer discountPercentage, Date discountDate, Long productId) {
        this.discountPercentage = discountPercentage;
        this.discountDate = discountDate;
        this.productId = productId;
    }
}
