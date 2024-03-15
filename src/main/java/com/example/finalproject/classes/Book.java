package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Book extends Item {
    // new field
    private String author;
    // new constructor parameter
    public Book(String name, int quantity, double price, String author) {
        super(name, quantity, price);
        this.author = author;
    }
    // new getter and setter
    public String getAuthor() {
        return author;
    }
    // new getter and setter
    public void setAuthor(String author) {
        this.author = author;
    }
    // override toString
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
    // override getType
    @Override
    public String getType() {
        return "Book";
    }
}