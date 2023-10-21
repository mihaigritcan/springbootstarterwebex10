package com.example.springbootstarterwebex10.services;

import com.example.springbootstarterwebex10.entity.Book;
import com.example.springbootstarterwebex10.repositories.BooksRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BooksRepository booksRepository;

    public List<Book> getAllBooksByTitle(String title){
        return booksRepository.findAllByTitle(title);
    }

    public List<Book> getAllBooksByIsbn(String isbn) {
        return booksRepository.findBookByISBN(isbn);
    }

    public List<String> getAuthorsBookByISBN(String isbn) {
        return booksRepository.findAllByISBN(isbn).stream().map(Book::getAuthor).toList();
    }

    public List<Book> findTop3ByAuthorOrderByPagesNumDesc(String author) {
        return booksRepository.findTop3ByAuthorOrderByPagesNumAsc(author);
    }

    public List<Book> booksWithTitleLike(String pattern) {
        return booksRepository.findAllByTitleStartingWith(pattern);
    }

    public List<Book> booksBetweenTwoValues(Integer min,Integer max) {
        return booksRepository.findAllByPagesNumBetween(min,max);
    }

    public List<Book> booksWithPagesGreaterThen(Integer min) {
        return booksRepository.findWherePagesNumIsGreaterThanX(min);
    }

}
