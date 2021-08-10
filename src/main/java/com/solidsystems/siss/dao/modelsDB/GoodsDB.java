package com.solidsystems.siss.dao.modelsDB;

import javax.persistence.*;

@Entity
public class GoodsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String name;
    String productDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
