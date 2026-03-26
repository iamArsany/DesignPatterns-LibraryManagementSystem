package com.library.decorator;

import com.library.model.Book;

public class PremiumBookDecorator extends BaseDecorator {
    public PremiumBookDecorator(Book book) {
        super(book);
    }

    @Override
    public int getBorrowLimitDays() {
        return wrappedBook.getBorrowLimitDays() + 10;
    }

    @Override
    public void displayInfo() {
        wrappedBook.displayInfo();
        System.out.println("  -> [Premium Feature] +10 days borrowing limit. Total: " + getBorrowLimitDays() + " days.");
    }
}
