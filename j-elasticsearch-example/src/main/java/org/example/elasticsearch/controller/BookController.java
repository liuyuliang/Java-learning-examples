package org.example.elasticsearch.controller;

import org.example.elasticsearch.service.BookService;
import org.example.elasticsearch.vo.Book;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: C
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 10:20
 */


@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public Map<String,String> addBook(@RequestBody Book book){
        bookService.addBook(book);
        Map<String,String> map = new HashMap<>();
        map.put("msg","ok");
        return map;
    }

    @GetMapping("/book/search")
    public SearchHits<Book> search(String key){
        return bookService.searchBook1(key);
    }
}

