package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Electronics extends Item {
    // new fields
    private String brand;
    // new field
    private String modelId;
    // new field
    private String subGroup;

    // new constructor parameter
    public Electronics(String name, int quantity, double price, String brand, String modelId, String subGroup) {
        super(name, quantity, price);
        this.brand = brand;
        this.modelId = modelId;
        this.subGroup = subGroup;
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
    public String getModelId() {
        return modelId;
    }
    // new getter and setter
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
    // override toString
    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand + ", Model ID: " + modelId;
    }
    // new getter and setter
    public String getSubGroup() {
        return subGroup;
    }
    // new getter and setter
    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    // override getType
    @Override
    public String getType() {
        return "Electronics";
    }
}