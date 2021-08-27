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

    @Column(updatable = false)
    @Setter
    @Getter
    Long productId;
}
