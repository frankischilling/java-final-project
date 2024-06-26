package com.example.finalproject.classes;

import com.example.finalproject.Item;

import java.util.List;

public class Book extends Item {
    // new field
    private String author;

    private String publisher;
    // new field
    private String subGroup;
    // new field
    private List<Page> pages;
    // new constructor parameter
    public Book(String name, int quantity, double price, String author, String subGroup, List<Page> pages) {
        super(name, quantity, price);
        this.author = author;
        this.subGroup = subGroup;
        this.pages = pages;
    }
    // new getter and setter
    public String getAuthor() {
        return author;
    }
    // new getter and setter
    public void setAuthor(String author) {
        this.author = author;
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
        return "Book";
    }
    // new getter and setter
    public void setPublisher(String publisher) {
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null or empty.");
        }
        this.publisher = publisher;
    }
    // new getter and setter
    public String getPublisher() {
        return publisher;
    }
    @Override
    public String toString() {
        return "ID: " + getId() + ", Item: " + getName() + ", Quantity: " + getQuantity() + ", Price: " + getPrice() + ", Description: " + getDescription() + ", Type: " + getType() + ", Subgroup: " + getSubGroup() + (hasImage() ? " (Image Attached)" : "");
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        if (pages == null || pages.isEmpty()) {
            throw new IllegalArgumentException("Pages cannot be null or empty.");
        }
        this.pages = pages;
    }
}