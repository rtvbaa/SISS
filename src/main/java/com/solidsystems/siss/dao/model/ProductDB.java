package com.solidsystems.siss.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Service
public class ProductDB {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
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
