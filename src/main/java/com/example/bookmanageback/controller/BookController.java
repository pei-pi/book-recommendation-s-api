package com.example.bookmanageback.controller;

import com.example.bookmanageback.entity.Book;
import com.example.bookmanageback.mapper.BookMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @GetMapping("/getAllBook")
    public List<Book> query(){
        List<Book> book = bookMapper.getAllBook();
        return book;
    }

    @ApiOperation("查询图书数目")
    @GetMapping("/getBooksCount")
    public int getCount(){
        int sum = bookMapper.getCount();
        return sum;
    }

    @ApiOperation("查询借阅中的图书数量")
    @GetMapping("/getBorrowBooksCount")
    public int getBorrowCount(){
        int count = bookMapper.getBorrowCount();
        return count;
    }
}
