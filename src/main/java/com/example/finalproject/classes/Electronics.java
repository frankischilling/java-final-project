package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Electronics extends Item {
    // new fields
    private String brand;
    // new field
    private String modelId;
    // new constructor parameter
    public Electronics(String name, int quantity, double price, String brand, String modelId) {
        super(name, quantity, price);
        this.brand = brand;
        this.modelId = modelId; // initialize the new field
    }
    // new getter and setter
    public String getBrand() {
        return brand;
    }
    // new getter and setter
    public void setBrand(String brand) {
        this.brand = brand;
    }
    // new getter and setter
    public String getModelId() { // getter for the new field
        return modelId;
    }
    // new getter and setter
    public void setModelId(String modelId) { // setter for the new field
        this.modelId = modelId;
    }
    // override toString
    public String toString() {
        return super.toString() + ", Brand: " + brand + ", Model ID: " + modelId; // include the new field
    }
    // override getType
    @Override
    public String getType() {
        return "Electronics";
    }
}