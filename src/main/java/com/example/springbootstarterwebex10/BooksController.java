package com.example.springbootstarterwebex10;

import com.example.springbootstarterwebex10.entity.Book;
import com.example.springbootstarterwebex10.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BooksController {
    private final BookService bookService;

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.getAllBooksByTitle(title);
    }
    @GetMapping("/isbn/{isbn}")
    public List<Book> findBookByISBN(@PathVariable String isbn){
        return bookService.getAllBooksByIsbn(isbn);
    }


    @GetMapping("/isbn/{isbn}/authors")
    public List<String> findAuthorsBookByISBN(@PathVariable String isbn){
        return bookService.getAuthorsBookByISBN(isbn);
    }
    @GetMapping("/author/{author}/top3")
    public List<Book> findTop3ByAuthorOrderByPagesNum(@PathVariable String author){
        return bookService.findTop3ByAuthorOrderByPagesNumDesc(author);
    }

    @GetMapping("/title/like/")
    public List<Book> booksWithTitleLike(@RequestParam String title){
        return bookService.booksWithTitleLike(title);
    }
    @GetMapping("/pages")
    public List<Book> booksBetweenTwoValues(@RequestParam Integer min, @RequestParam Integer max){
        return bookService.booksBetweenTwoValues(min,max);
    }

    @GetMapping("/pages/greaterThen")
    public List<Book> booksWithPagesGreaterThen(@RequestParam Integer min){
        return bookService.booksWithPagesGreaterThen(min);
    }
}
