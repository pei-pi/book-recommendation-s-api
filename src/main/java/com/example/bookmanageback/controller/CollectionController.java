package com.example.bookmanageback.controller;
import com.example.bookmanageback.entity.Collection;
import com.example.bookmanageback.mapper.CollectionMapper;
import com.example.bookmanageback.mapper.UserMapper;
import com.example.bookmanageback.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/collection")
@RestController
public class CollectionController {
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/ifCollection")
    public Result ifCollection(Integer bookId,String username){
        int i = collectionMapper.ifCollection(bookId,username);
        return Result.ok().data("isCollected",i);
    }
    @GetMapping("/insertCollection")
    public Result insertCollection(Integer bookId,String username){
        int userId = userMapper.findByUsername(username);
        java.util.Date date = new java.util.Date(); // 获取当前时间
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime()); // 转换为Timestamp
        int i = collectionMapper.insertCollection(bookId,userId,timestamp);
        if(i>0){
            return Result.ok();
        } else {
            return Result.error();
        }
    }

}