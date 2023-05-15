//package com.speproject.majorproject.service;
//
//import com.speproject.majorproject.entity.Book;
//import com.speproject.majorproject.repository.BookRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//
//@SpringBootTest
//class BookServiceTest {
//
//    @Autowired
//    public BookService bookService;
//
//    @MockBean
//    private BookRepository bookRepository;
//
//    @BeforeEach
//    void setUp(){
//        Book book = Book.builder()
//                .bookId(1L)
//                .genre("comedy")
//                .title("Laugh Out")
//                .author("Steve Harvey")
//                .price(16.00)
//                .image("soruce.img")
//                .availableForRent(false)
//                .availableForSale(false)
//                .description("book about Laugh club")
//                .build();
//
//        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.ofNullable(book));
//        Mockito.when(bookRepository.findByTitleIgnoreCase("Laugh Out")).thenReturn(book);
//    }
//
//    @Test
//    public void whenValidId_thenBookShouldFound(){
//            long bookId = 1;
//            Book found = bookService.getBookById(bookId);
//            assertEquals(bookId,found.getBookId());
//    }
//
//    @Test
//    public void whenValidAuthor_thenBookShouldFound(){
//
//        String title = "Laugh Out";
//        Book found = bookService.getBooksByTitle(title);
//        assertEquals(title,found.getTitle());
//    }
//    @Configuration
//    @Import(Book.class)
//    static class TestConfig {
//        @Bean
//        BookRepository bookRepository() {
//            return mock(BookRepository.class);
//        }
//    }
//}