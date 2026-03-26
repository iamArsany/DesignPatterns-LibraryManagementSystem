package com.library;

import com.library.adapter.ExternalBookAdapter;
import com.library.decorator.PremiumBookDecorator;
import com.library.factory.BookFactory;
import com.library.model.Book;
import com.library.model.User;
import com.library.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        // 1. Factory Method: Create different types of books
        Book physicalBook = BookFactory.createBook("PHYSICAL", "Effective Java");
        Book eBook = BookFactory.createBook("EBOOK", "Java Concurrency in Practice");

        // 2. Decorator Pattern: Add premium feature (+10 days limit) to a book
        Book premiumEBook = new PremiumBookDecorator(eBook);

        // 3. Adapter Pattern: Convert JSON input to a Book entity
        String jsonInput = "{ \"bookTitle\": \"Design Patterns\", \"isBorrowable\": true, \"authorName\": \"Erich Gamma\", \"year\": 1994 }";
        ExternalBookAdapter adapter = new ExternalBookAdapter();
        Book adaptedBook = adapter.convertJsonToBook(jsonInput);

        // Add books to the system
        library.addBook(physicalBook);
        library.addBook(premiumEBook);
        library.addBook(adaptedBook);

        // 4. Observer Pattern: Register users for notifications
        User alice = new User("Alice");
        User bob = new User("Bob");
        library.registerUser(alice);
        library.registerUser(bob);

        // Show all books
        library.showAllBooks();

        // 5. Facade & Chain of Responsibility: Borrow books with approval flow
        System.out.println("--- Borrowing Operations ---");
        library.borrowBook("Effective Java", alice, 5); // Librarian (<= 7 days)
        library.borrowBook("Design Patterns", bob, 12); // Manager (<= 14 days)
        library.borrowBook("Java Concurrency in Practice", alice, 20); // Director (> 14 days)

        System.out.println("\n--- Return and Notification ---");
        // 6. Observer Pattern: Notifications when book becomes available
        library.returnBook("Effective Java");
    }
}
