package com.cognizant.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.library.service.BookService;

public class LibraryApplication {
    public static void main(String[] args) {
        // Load the Spring container context configurations
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Fetch the wired service bean instance
        BookService service = context.getBean("bookService", BookService.class);

        // Run application workflow execution
        service.registerNewBook("Spring Framework Architecture Guide");
    }
}