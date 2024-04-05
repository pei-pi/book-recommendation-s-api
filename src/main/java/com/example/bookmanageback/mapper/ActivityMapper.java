package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Mapper
@Transactional
public interface ActivityMapper {
    @Insert("insert into useractivities (userId,bookId,activityType,timestamp) VALUES (#{userId}, #{bookId}, #{activityType}, #{timestamp})")
    public int insertActivity(Integer userId, Integer bookId, Integer activityType, Timestamp timestamp);
}
