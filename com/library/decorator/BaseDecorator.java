package com.library.decorator;

import com.library.model.Book;

public abstract class BaseDecorator extends Book {
    protected Book wrappedBook;

    public BaseDecorator(Book book) {
        super(book.getTitle());
        this.wrappedBook = book;
    }

    @Override
    public String getTitle() { return wrappedBook.getTitle(); }
    @Override
    public boolean isAvailable() { return wrappedBook.isAvailable(); }
    @Override
    public void setAvailable(boolean available) { wrappedBook.setAvailable(available); }
    @Override
    public int getBorrowLimitDays() { return wrappedBook.getBorrowLimitDays(); }
    @Override
    public void setBorrowLimitDays(int borrowLimitDays) { wrappedBook.setBorrowLimitDays(borrowLimitDays); }
    @Override
    public void displayInfo() { wrappedBook.displayInfo(); }
}
