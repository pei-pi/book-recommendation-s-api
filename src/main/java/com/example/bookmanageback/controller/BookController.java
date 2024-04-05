package com.example.bookmanageback.controller;
import com.example.bookmanageback.entity.Book;
import com.example.bookmanageback.mapper.BookMapper;
import com.example.bookmanageback.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result getBookById(int bookId){
        Book book = bookMapper.findById(bookId);
        System.out.println(book);
        return Result.ok().data("book",book);
    }

    @ApiOperation("查询图书数目")
    @GetMapping("/getBooksCount")
    public Result getCount(){
        int sum = bookMapper.getCount();
        return Result.ok().data("sum",sum);
    }

    @ApiOperation("查询借阅中的图书数量")
    @GetMapping("/getBorrowBooksCount")
    public Result getBorrowCount(){
        int count = bookMapper.getBorrowCount();
        return Result.ok().data("count",count);
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

    @ApiOperation("根据详细分类查询图书")
    @GetMapping("/getBookByCategory")
    public Result getBookByCategory(String subCateName){
        List<Book> book = bookMapper.getBookByCategory(subCateName);
        return Result.ok().data("books",book);
    }

    @ApiOperation("按降序获取图书")
    @GetMapping("/getNewBook")
    public Result getNewBook(Integer begin,Integer num){
        List<Book> books = bookMapper.getNewBook(begin,num);
        return Result.ok().data("books",books);
    }



}
