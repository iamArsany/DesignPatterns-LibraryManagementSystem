package com.library.service;

import com.library.approval.*;
import com.library.model.Book;
import com.library.model.User;
import com.library.observer.AvailabilityNotifier;
import com.library.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private AvailabilityNotifier notifier = new AvailabilityNotifier();
    private BaseApprover approvalChain;

    public LibraryService() {
        // Initialize the Chain of Responsibility
        Librarian librarian = new Librarian();
        Manager manager = new Manager();
        Director director = new Director();

        librarian.setNext(manager);
        manager.setNext(director);

        this.approvalChain = librarian;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void registerUser(User user) {
        notifier.attach(user);
    }

    public void borrowBook(String title, User user, int requestedDays) {
        Book book = findBook(title);
        if (book != null && book.isAvailable()) {
            System.out.println("Approval process for borrowing '" + title + "' by " + user.getName() + ":");
            approvalChain.approve(requestedDays);
            book.setAvailable(false);
            System.out.println("Book '" + title + "' is now borrowed by " + user.getName() + ".");
        } else if (book != null) {
            System.out.println("Book '" + title + "' is not available.");
        } else {
            System.out.println("Book '" + title + "' not found.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.setAvailable(true);
            System.out.println("Book '" + title + "' has been returned.");
            notifier.notifyObservers("The book '" + title + "' is now available for borrowing!");
        } else {
            System.out.println("Book '" + title + "' not found.");
        }
    }

    private Book findBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void showAllBooks() {
        System.out.println("\n--- Current Library Collection ---");
        for (Book book : books) {
            book.displayInfo();
        }
        System.out.println("----------------------------------\n");
    }
}
