package com.example.finalproject;

public abstract class Item {
    // new field
    private static int nextId = 1;
    private String id;
    private String name;
    private int quantity;
    private double price;
    // new constructor parameter
    public Item(String name, int quantity, double price) {
        this.id = "ITEM" + nextId++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    // new getter
    public String getId() {
        return id;
    }
    // new getter
    public String getName() {
        return name;
    }
    // new getter
    public int getQuantity() {
        return quantity;
    }
    // new getter
    public double getPrice() {
        return price;
    }
    // new setter
    public void setId(String id) {
        this.id = id;
    }
    // new setter
    public void setName(String name) {
        this.name = name;
    }
    // new setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // new setter
    public void setPrice(double price) {
        this.price = price;
    }
    // override toString
    public String toString() {
        return "ID: " + id + ", Item: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }
    // override equals
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return id.equals(item.id) && name.equals(item.name) && quantity == item.quantity && price == item.price;
    }
    // override hashCode
    public abstract String getType();
}