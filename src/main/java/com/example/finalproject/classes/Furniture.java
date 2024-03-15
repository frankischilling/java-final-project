package com.example.finalproject;

public class Furniture extends Item {
    private String material;
    private String color;

    public Furniture(String name, int quantity, double price, String material, String color) {
        super(name, quantity, price);
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return super.toString() + ", Material: " + material + ", Color: " + color;
    }

    @Override
    public String getType() {
        return "Furniture";
    }
}