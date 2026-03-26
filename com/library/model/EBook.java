package com.library.model;

public class EBook extends Book {
    public EBook(String title) {
        super(title);
        this.borrowLimitDays = 30; // EBooks have a default 30-day limit
    }

    @Override
    public void displayInfo() {
        System.out.println("[E-Book] Title: " + title + ", Borrow Limit: " + borrowLimitDays + " days");
    }
}
