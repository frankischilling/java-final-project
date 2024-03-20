package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Furniture extends Item {
    // new field
    private String material;
    // new field
    private String subGroup;

    private String dimensions;

    // new constructor parameter
    public Furniture(String name, int quantity, double price, String material, String subGroup) {
        super(name, quantity, price);
        this.material = material;
        this.subGroup = subGroup;
    }
    // new getter and setter
    public String getMaterial() {
        return material;
    }
    // new getter and setter
    public void setMaterial(String material) {
        this.material = material;
    }
    // new getter and setter
    public String getSubGroup() {
        return subGroup;
    }
    // new getter and setter
    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public void setDimensions(String dimensions) {
        if (dimensions == null || dimensions.isEmpty()) {
            throw new IllegalArgumentException("Dimensions cannot be null or empty.");
        }
        this.dimensions = dimensions;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material + ", Sub Group: " + subGroup + ", Dimensions: " + dimensions;
    }
    // override getType
    @Override
    public String getType() {
        return "Furniture";
    }
}