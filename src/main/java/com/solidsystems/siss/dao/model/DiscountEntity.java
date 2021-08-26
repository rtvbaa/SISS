package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

}
