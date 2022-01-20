package com.example.MusicStore;

import javax.persistence.*;

@Entity
public class Instrument {

    public Instrument() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instId;
    private String instType;
    private String subType;
    private String brand;
    private String model;
    private int price;

    public Instrument(String instType, String subType, String brand, String model, int price) {
        this.instType = instType;
        this.subType = subType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Instrument (int price){
        this.price = price;
    }

    public Long getInstId() {
        return instId;
    }

    public void setInstId(Long instId) {
        this.instId = instId;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
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
