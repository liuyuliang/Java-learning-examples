package org.example.elasticsearch.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.elasticsearch.service.BookService;
import org.example.elasticsearch.vo.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * ClassName: C
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/8 10:20
 */


/**
 * @author wx:深入技术架构
 */
@Slf4j
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public BookBean getBookById(@PathVariable String id){
        Optional<BookBean> opt =bookService.findById(id);
        log.info(opt.toString());
        BookBean book=opt.get();
        return book;
    }

    @RequestMapping("/book/save")
    @ResponseBody
    public void bookSave(){
        BookBean book=new BookBean("1","ES 入门教程","张三","2022-08-05");
        System.out.println(book);
        bookService.save(book);
    }

    @RequestMapping("/book/edit")
    @ResponseBody
    public void bookEdit(){
        BookBean book=new BookBean("1","ES 高级教程","李四","2022-08-05");
        System.out.println(book);
        bookService.save(book);
    }
}
