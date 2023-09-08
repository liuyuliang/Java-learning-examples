package org.example.elasticsearch.service;


import org.example.elasticsearch.repository.BookRepository;
import org.example.elasticsearch.vo.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ClassName: D
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 13:56
 */
@Service("bookService")
public class BookServiceImpl   implements BookService{

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    public Optional<BookBean> findById(String id) {
        //CrudRepository中的方法
        return bookRepository.findById(id);
    }

    @Override
    public BookBean save(BookBean book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(BookBean book) {
        bookRepository.delete(book);
    }

    @Override
    public Optional<BookBean> findOne(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BookBean> findAll() {
        return (List<BookBean>) bookRepository.findAll();
    }

    @Override
    public Page<BookBean> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    @Override
    public Page<BookBean> findByTitle(String title, PageRequest pageRequest) {
        return bookRepository.findByTitle(title, pageRequest);
    }
}