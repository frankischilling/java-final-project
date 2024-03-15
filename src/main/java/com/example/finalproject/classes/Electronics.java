package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Electronics extends Item {
    private String brand;
    private String modelId; // new field

    public Electronics(String name, int quantity, double price, String brand, String modelId) {
        super(name, quantity, price);
        this.brand = brand;
        this.modelId = modelId; // initialize the new field
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelId() { // getter for the new field
        return modelId;
    }

    public void setModelId(String modelId) { // setter for the new field
        this.modelId = modelId;
    }

    public String toString() {
        return super.toString() + ", Brand: " + brand + ", Model ID: " + modelId; // include the new field
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}