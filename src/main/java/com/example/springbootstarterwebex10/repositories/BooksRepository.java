package com.example.springbootstarterwebex10.repositories;

import com.example.springbootstarterwebex10.entity.Book;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book,Long> {
//    returning all books with a specific title
    List<Book> findAllByTitle(String title);
    List<Book> findBookByISBN(String title);

    List<Book> findAllByISBN(String isbn);


    List<Book> findTop3ByAuthorOrderByPagesNumAsc(String author);

    List<Book> findAllByTitleStartingWith(String title);


    List<Book> findAllByPagesNumBetween(Integer min, Integer max);

//    @Query(value = "SELECT * from books where pages_num >= :min",nativeQuery = true)
    @Query(value = "SELECT b from BOOKS b where b.pagesNum >= :min",nativeQuery = false)
    List<Book> findWherePagesNumIsGreaterThanX(@Param("min") Integer min);
}
