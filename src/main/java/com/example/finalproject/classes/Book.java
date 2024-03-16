package com.example.finalproject.classes;

import com.example.finalproject.Item;
import java.util.List;
import java.util.stream.Collectors;

public class Book extends Item {
    private String author;
    private String subGroup;
    private List<Page> pages;

    public Book(String name, int quantity, double price, String author, String subGroup, List<Page> pages) {
        super(name, quantity, price);
        this.author = author;
        this.subGroup = subGroup;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    @Override
    public String toString() {
        int totalPages = pages.size();
        return super.toString() + ", Author: " + author + ", Sub Group: " + subGroup + ", Pages: " + totalPages;
    }

    @Override
    public String getType() {
        return "Book";
    }
}