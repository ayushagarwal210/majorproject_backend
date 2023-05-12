package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LogManager.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/addBooks")
    public Book addBook(@RequestBody Book book) {
        logger.info("Adding book: {}", book);
        return bookService.addBooks(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookByGenre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre) {
        logger.info("Getting books by genre: {}", genre);
        return bookService.getBooksByGenre(genre);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable("id") Long bookId, @RequestBody Book book) {

        return  bookService.updateBook(bookId,book);
    }
    @GetMapping("/getBookByAuthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable("author") String author) {
        logger.info("Getting books by author: {}", author);
        return bookService.getBooksByAuthor(author);
    }
    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return "Department deleted successfully";
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable("id") Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/getBookByTitle/{title}")
    public List<Book> getBooksByTitle(@PathVariable("title") String title) {
        logger.info("Getting books by title: {}", title);
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/getAllGenre")
    public List getAllGenre() {
        logger.info("Getting all genres");
        List genreList = bookService.getAllGenre();
        return genreList;
    }

}
