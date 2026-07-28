package com.cognizant.junit.mockito;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import com.cognizant.junit.service.BookService;
import com.cognizant.junit.service.BookRepository;

public class Exercise2_VerifyInteractionTest {

    @Test
    public void testRepositoryInteractionVerification() {
        // 1. MOCK: Setup the dependency interface layer
        BookRepository mockRepo = mock(BookRepository.class);
        BookService service = new BookService(mockRepo);

        // 2. ACT: Call our execution logic code path
        service.fetchBookDetails(505);

        // 3. VERIFY: Confirm that our service internally called the method exactly once
        // with the parameter value 505
        verify(mockRepo, times(1)).getBookTitleById(505);
    }
}