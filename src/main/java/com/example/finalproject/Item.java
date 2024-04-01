package com.example.finalproject;

import javafx.scene.image.Image;

public abstract class Item {
    // new field
    private boolean hasImage = false;
    private static int nextId = 1;
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String imagePath;
    private String description;
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

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public double discountPrice(double discountRate) {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("Discount rate must be between 0 and 1.");
        }
        return price * (1 - discountRate);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Item: " + name + ", Quantity: " + quantity + ", Price: " + price + ", Description: " + description + (hasImage ? " (Image Attached)" : "");
    }

    public abstract String getType();

    public boolean hasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Image getImage() {
        if (hasImage() && imagePath != null) {
            return new Image(imagePath);
        }
        return null;
    }
}