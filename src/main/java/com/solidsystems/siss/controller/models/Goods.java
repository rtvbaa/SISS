package com.solidsystems.siss.controller.models;

public class Goods {
    int id;
    String name;
    String productDescription;

    public Goods() {
    }

    public Goods(int id, String name, String productDescription) {
        this.id = id;
        this.name = name;
        this.productDescription = productDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
