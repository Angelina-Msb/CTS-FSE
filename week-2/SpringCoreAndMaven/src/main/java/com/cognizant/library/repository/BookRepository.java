package com.cognizant.library.repository;

public class BookRepository {
    
    public void saveBook(String bookTitle) {
        System.out.println("Repository: Successfully saved '" + bookTitle + "' to the database.");
    }
}