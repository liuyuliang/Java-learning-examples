package org.example.elasticsearch.service;

/**
 * ClassName: E
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 10:12
 */


import org.example.elasticsearch.vo.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;


/**
 * @author geng
 * 2020/12/19
 */

public interface BookService {

    Optional<BookBean> findById(String id);

    BookBean save(BookBean book);

    void delete(BookBean book);

    Optional<BookBean> findOne(String id);

    List<BookBean> findAll();

    Page<BookBean> findByAuthor(String author, PageRequest pageRequest);

    Page<BookBean> findByTitle(String title, PageRequest pageRequest);
}
