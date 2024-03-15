package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Book extends Item {
    // new field
    private String author;
    // new field
    private String subGroup;
    // new constructor parameter
    public Book(String name, int quantity, double price, String author, String subGroup) {
        super(name, quantity, price);
        this.author = author;
        this.subGroup = subGroup;
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
    // override toString
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Sub Group: " + subGroup; // include the new field
    }
    // override getType
    @Override
    public String getType() {
        return "Book";
    }
}