package com.example.bookmanageback.controller;

import com.example.bookmanageback.entity.Book;
import com.example.bookmanageback.mapper.ActivityMapper;
import com.example.bookmanageback.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookmanageback.utils.Result;
import com.example.bookmanageback.entity.Activity;
import com.example.bookmanageback.entity.ActivityDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private BookMapper bookMapper;
    @GetMapping("/findActivity")
    public Result findActivity(){
        List<Activity> activity = activityMapper.findActivity();
        List<ActivityDTO> activityDTOList = activity.stream().map(item->{
            ActivityDTO activityDTO = new ActivityDTO();
            activityDTO.setBookId(item.getBookId());
            activityDTO.setBorrowCount(item.getborrowCount());
            activityDTO.setCollectCount(item.getcollectCount());
            activityDTO.setScore(item.getScore());
            Book book = bookMapper.findById(item.getBookId());
            activityDTO.setBookTitle(book.getBookTitle());
            activityDTO.setBookAuthor(book.getBookAuthor());
            activityDTO.setBookSrc(book.getBookSrc());
            return activityDTO;
        }).collect(Collectors.toList());
        return Result.ok().data("activity",activityDTOList);
    }
}
