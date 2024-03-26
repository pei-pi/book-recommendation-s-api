package com.example.bookmanageback.controller;
import com.example.bookmanageback.entity.Book;
import com.example.bookmanageback.mapper.BookMapper;
import com.example.bookmanageback.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @GetMapping("/getAllBook")
    public Result query(){
        List<Book> book = bookMapper.getAllBook();
        return Result.ok().data("books",book);
    }

    @ApiOperation("根据id查找书籍")
    @GetMapping("/getBookById")
    public Book getBookById(int bookId){
        Book book = bookMapper.findById(bookId);
        System.out.println(book);
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

    @ApiOperation("删除图书")
    @DeleteMapping("/deleteBookById")
    public Result deleteBookById(Integer bookId){
        int i = bookMapper.deleteBookById(bookId);
        
        if(i>0){
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("批量删除图书")
    @DeleteMapping("/bantchDeleteBook")
    public Result bantchDeleteBook(@RequestBody List<Integer> bookIds){
        int i = bookMapper.bantchDelete(bookIds);
        if(i>0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }
    @ApiOperation("更新图书信息")
    @PostMapping("/updataBook")
    public Result updateBook(@RequestBody Book book){
        int i = bookMapper.updataBook(book);
        if(i>0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    @ApiOperation("查询图书分类")
    @GetMapping("inquiryClassify")
    public Result inquiryClassify(){
        List<Map<Integer,String>> classify = bookMapper.inquiryClassify();
        return Result.ok().data("classify",classify);
    }

    @ApiOperation("查询图书详细分类")
    @GetMapping("inquiryDetailClassify")
    public Result inquiryDetailClassify(int cateId){
        List<Map<Integer,String>> detailClassify = bookMapper.inquiryDetailClassify(cateId);
        return Result.ok().data("detailClassify",detailClassify);
    }

    @ApiOperation("添加图书")
    @PostMapping("/addBook")
    public Result addBook(@RequestBody Book book){
        int i = bookMapper.addBook(book);
        if(i>0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }
}
