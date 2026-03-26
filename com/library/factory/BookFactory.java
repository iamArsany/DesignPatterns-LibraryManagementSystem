package com.library.factory;

import com.library.model.Book;
import com.library.model.EBook;
import com.library.model.PhysicalBook;

public class BookFactory {
    public static Book createBook(String type, String title) {
        if (type.equalsIgnoreCase("EBOOK")) {
            return new EBook(title);
        } else if (type.equalsIgnoreCase("PHYSICAL")) {
            return new PhysicalBook(title);
        }
        throw new IllegalArgumentException("Unknown book type: " + type);
    }
}
