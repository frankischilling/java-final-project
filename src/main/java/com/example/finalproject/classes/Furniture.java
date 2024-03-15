package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Furniture extends Item {
    // new field
    private String material;
    // new constructor parameter
    public Furniture(String name, int quantity, double price, String material) {
        super(name, quantity, price);
        this.material = material;
    }
    // new getter and setter
    public String getMaterial() {
        return material;
    }
    // new getter and setter
    public void setMaterial(String material) {
        this.material = material;
    }
    // override toString
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
    // override getType
    @Override
    public String getType() {
        return "Furniture";
    }
}