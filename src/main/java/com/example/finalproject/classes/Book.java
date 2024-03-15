package com.example.finalproject.classes;

import com.example.finalproject.Item;

public class Book extends Item {
    private String author;

    public Book(String name, int quantity, double price, String author) {
        super(name, quantity, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return super.toString() + ", Author: " + author;
    }

    @Override
    public String getType() {
        return "Book";
    }
}