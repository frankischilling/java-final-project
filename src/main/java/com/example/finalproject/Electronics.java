package com.example.finalproject;

public class Electronics extends Item {
    private String brand;


    public Electronics(String name, int quantity, double price, String brand) {
        super(name, quantity, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}