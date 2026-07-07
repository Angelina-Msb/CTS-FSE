package com.cognizant.junit.service;

// 1. This represents our external API or Database layer
interface BookRepository {
    String getBookTitleById(int id);
}

// 2. This is the main application service logic we want to test
public class BookService {
    private BookRepository bookRepository;

    // Constructor injection allows us to pass a mocked repository later
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String fetchBookDetails(int id) {
        String title = bookRepository.getBookTitleById(id);
        if (title == null) {
            return "Book Not Found";
        }
        return "Book Details: " + title;
    }
}