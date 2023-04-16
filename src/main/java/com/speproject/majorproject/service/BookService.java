package com.speproject.majorproject.service;

import com.speproject.majorproject.entity.Book;

import java.util.List;


public interface BookService {

    Book addBooks(Book book);

    List<Book> getAllBooks();

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAuthor(String genre);

    List<Book> getBooksByTitle(String genre);
}
