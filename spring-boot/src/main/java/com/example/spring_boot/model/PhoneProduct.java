package com.example.spring_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PhoneProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PhoneBrand;
    private String PhoneModel;
    private String Color;
    private double Price;
    private int storage;

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return Price;
    }

    public int getStorage() {
        return storage;
    }

    public String getColor() {
        return Color;
    }

    public String getPhoneBrand() {
        return PhoneBrand;
    }

    public String getPhoneModel() {
        return PhoneModel;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setPhoneBrand(String phoneBrand) {
        PhoneBrand = phoneBrand;
    }

    public void setPhoneModel(String phoneModel) {
        PhoneModel = phoneModel;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
