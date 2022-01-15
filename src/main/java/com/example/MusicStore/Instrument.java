package com.example.MusicStore;

import javax.persistence.*;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String subType;
    private String brand;
    private String model;
    private int price;

    public Instrument(String type, String subType, String brand, String model, int price) {
        this.type = type;
        this.subType = subType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Instrument(String type, String subType, String brand, String model) {
        this.type = type;
        this.subType = subType;
        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
