package com.library.adapter;

import com.library.model.Book;
import com.library.model.PhysicalBook;

public class ExternalBookAdapter {
    public Book convertJsonToBook(String json) {
        // Simple manual parsing for: { "bookTitle": "...", "isBorrowable": ..., "authorName": "...", "year": ... }
        String title = extractValue(json, "bookTitle");
        String author = extractValue(json, "authorName");
        int year = Integer.parseInt(extractValue(json, "year"));
        boolean isAvailable = Boolean.parseBoolean(extractValue(json, "isBorrowable"));

        Book book = new PhysicalBook(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setAvailable(isAvailable);
        return book;
    }

    private String extractValue(String json, String key) {
        String pattern = "\"" + key + "\": ";
        int start = json.indexOf(pattern) + pattern.length();
        if (json.charAt(start) == '\"') {
            start++;
            int end = json.indexOf("\"", start);
            return json.substring(start, end);
        } else {
            int end = json.indexOf(",", start);
            if (end == -1) end = json.indexOf("}", start);
            return json.substring(start, end).trim();
        }
    }
}
