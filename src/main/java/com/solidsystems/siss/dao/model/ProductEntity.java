package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(unique = true)
    @Setter
    @Getter
    String name;

    @Basic(fetch = FetchType.LAZY)
    @Setter
    @Getter
    String productDescription;
}
