package com.cognizant.junit.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import com.cognizant.junit.service.BookService;
import com.cognizant.junit.service.BookRepository;

public class Exercise1_MockStubTest {

    @Test
    public void testExternalRepositoryWithMocking() {
        // 1. MOCK: Create a dummy instance of our BookRepository interface
        BookRepository mockRepo = mock(BookRepository.class);

        // 2. STUB: Define a mock rule (When ID 101 is requested, return "Java Deep Skilling")
        when(mockRepo.getBookTitleById(101)).thenReturn("Java Deep Skilling");

        // 3. ACT: Pass the mock into our production service
        BookService service = new BookService(mockRepo);
        String result = service.fetchBookDetails(101);

        // 4. ASSERT: Verify the service combined our stubbed data correctly
        assertEquals("Book Details: Java Deep Skilling", result);
    }
}