package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBooks(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findAllByGenreIgnoreCase(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(String genre){
        return bookRepository.findAllByAuthorIgnoreCase(genre);
    }

    @Override
    public List<Book> getBooksByTitle(String genre){
        return bookRepository.findAllByTitleIgnoreCase(genre);
    }

}
