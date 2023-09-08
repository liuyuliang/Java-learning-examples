package org.example.elasticsearch.service;

/**
 * ClassName: E
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 10:12
 */

import org.example.elasticsearch.repository.ESBookRepository;
import org.example.elasticsearch.vo.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author geng
 * 2020/12/19
 */

@Service
public class BookService {
    private final ESBookRepository bookRepository;
    private final ESBookRepository esBookRepository;
    private final TransactionTemplate transactionTemplate;

    public BookService(ESBookRepository bookRepository,
                       ESBookRepository esBookRepository,
                       TransactionTemplate transactionTemplate) {
        this.bookRepository = bookRepository;
        this.esBookRepository = esBookRepository;
        this.transactionTemplate = transactionTemplate;
    }

    public void addBook(Book book) {
        final Book saveBook = transactionTemplate.execute((status) ->
                bookRepository.save(book)
        );
        final Book esBook = new Book();
        assert saveBook != null;
        BeanUtils.copyProperties(saveBook, esBook);
        esBook.setId(saveBook.getId() + "");
        try {
            esBookRepository.save(esBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchBook(String keyword) {
        return esBookRepository.findByTitleOrAuthor(keyword, keyword);
    }

    public SearchHits<Book> searchBook1(String keyword) {
        return esBookRepository.find(keyword);
    }
}
