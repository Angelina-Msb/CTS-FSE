package com.cognizant.library.service;

import com.cognizant.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerNewBook(String title) {
        System.out.println("Service: Processing registration rules for book: " + title);
        bookRepository.saveBook(title);
    }
}