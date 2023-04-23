package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBooks")
    public Book addBook(@RequestBody Book book){
        return bookService.addBooks(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookByGenre/{id}")
    public List<Book> getBooksByGenre(@PathVariable("id") String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/getBookByAuthor/{id}")
    public List<Book> getBooksByAuthor(@PathVariable("id") String author){
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/getBookByTitle/{id}")
    public List<Book> getBooksByTitle(@PathVariable("id") String title){
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/getAllGenre")
    public List getAllGenre(){
        List genreList = bookService.getAllGenre();
        return genreList;
    }

}
