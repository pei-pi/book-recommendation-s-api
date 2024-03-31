package com.example.bookmanageback.controller;
import com.example.bookmanageback.mapper.BorrowMapper;
import com.example.bookmanageback.mapper.UserMapper;
import com.example.bookmanageback.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RequestMapping("/borrow")
@RestController
public class BorrowController {
    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private UserMapper userMapper;
    @ApiOperation("查询借阅信息")
    @GetMapping("/isBorrow")
    public Result isBorrow(Integer bookId,String username){
        int userId = userMapper.findByUsername(username);
        int isBorrow = borrowMapper.isBorrow(bookId,userId);
        if(isBorrow == 1){
            int i = borrowMapper.borrowState(bookId,userId);
            return Result.ok().data("isBorrow",i);
        }else{
            return Result.ok().data("isBorrow",0);
        }
    }

    @ApiOperation("插入借阅信息")
    @GetMapping("/insertBorrow")
    public Result insertBorrow(Integer bookId, String username, Timestamp borrowTime,Timestamp endTime){
        int borrowState = 1;
        int userId = userMapper.findByUsername(username);
        int i = borrowMapper.insertBorrow(bookId,userId,borrowTime,endTime,borrowState);
        return Result.ok();
    }

    @ApiOperation("审核借阅信息")
    @GetMapping("/checkBorrow")
    public Result checkBorrow(Integer bookId, Integer userId){
        int i = borrowMapper.checkBorrow(bookId,userId);
        return Result.ok();
    }

    @ApiOperation("归还图书")
    @GetMapping("/back")
    public Result back(Integer bookId, String username){
        int userId = userMapper.findByUsername(username);
        java.util.Date date = new java.util.Date(); // 获取当前时间
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime()); // 转换为Timestamp
        borrowMapper.back(3,timestamp,userId,bookId);
        return Result.ok();
    }
    @ApiOperation("审核归还信息")
    @GetMapping("/checkBack")
    public Result checkBack(Integer bookId, Integer userId){
        int i = borrowMapper.checkBack(bookId,userId);
        return Result.ok();
    }

}
