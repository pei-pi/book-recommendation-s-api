package com.example.bookmanageback.mapper;
import com.example.bookmanageback.entity.BorrowBooks;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;

@Mapper
@Transactional
public interface BorrowMapper {
    /*查询是否有借阅记录*/
    @Select("select count(*) from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public int isBorrow(Integer bookId,Integer userId);
    @Select("select borrowState from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public int borrowState(Integer bookId,Integer userId);
    /*插入借阅信息*/
    @Insert("insert into borrowbooks (bookId,userId,borrowTime,endTime,borrowState) values (#{bookId},#{userId},#{borrowTime},#{endTime},#{borrowState})")
    public int insertBorrow(Integer bookId, Integer userId, Timestamp borrowTime,Timestamp endTime,Integer borrowState);
    /*审核借阅信息*/
    @Update("update borrowbooks set borrowState=2 where bookId=#{bookId} and userId=#{userId}")
    public int checkBorrow(Integer bookId,Integer userId);
    /*归还图书*/
    @Update("update borrowbooks set borrowState=#{borrowState},returnTime=#{returnTime} where userId=#{userId} and bookId=#{bookId}")
    public void back(Integer borrowState, Timestamp returnTime,Integer userId,Integer bookId);
    /*审核归还信息*/
    @Update("update borrowbooks set borrowState=4 where bookId=#{bookId} and userId=#{userId}")
    public int checkBack(Integer bookId,Integer userId);
}
