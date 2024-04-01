package com.example.finalproject.classes;

import java.util.ArrayList;

public class Page {
    private int pageNumber;
    private String content;
    private ArrayList<Page> pages;

    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Page " + pageNumber + ": " + content;
    }
}