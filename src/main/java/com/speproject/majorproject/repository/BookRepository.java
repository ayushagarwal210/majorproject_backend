package com.speproject.majorproject.repository;

import com.speproject.majorproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByGenreIgnoreCase(String genre);

    List<Book> findAllByAuthorIgnoreCase(String genre);

    List<Book> findAllByTitleIgnoreCase(String genre);
}
