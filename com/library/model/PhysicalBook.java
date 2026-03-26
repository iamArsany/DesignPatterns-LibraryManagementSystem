package com.library.model;

public class PhysicalBook extends Book {
    public PhysicalBook(String title) {
        super(title);
        this.borrowLimitDays = 14; // Physical books have a default 14-day limit
    }

    @Override
    public void displayInfo() {
        System.out.println("[Physical Book] Title: " + title + ", Borrow Limit: " + borrowLimitDays + " days");
    }
}
