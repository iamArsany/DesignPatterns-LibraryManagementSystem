package com.library.model;

import com.library.observer.Observer;

public abstract class Book {
    protected String title;
    protected String author;
    protected int year;
    protected boolean isAvailable;
    protected int borrowLimitDays;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
        this.borrowLimitDays = 0; // Base limit to be set by subclasses
    }

    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public int getBorrowLimitDays() { return borrowLimitDays; }
    public void setBorrowLimitDays(int borrowLimitDays) { this.borrowLimitDays = borrowLimitDays; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public abstract void displayInfo();
}
