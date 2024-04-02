package com.example.bookmanageback.mapper;
import com.example.bookmanageback.controller.CollectionController;
import com.example.bookmanageback.entity.BorrowMessage;
import com.example.bookmanageback.entity.UserBorrow;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Transactional
public interface BorrowMapper {
    /*查询是否有借阅记录*/
    @Select("select count(*) from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public int isBorrow(Integer bookId,Integer userId);
    /*查询归还时间*/
    @Select("select endTime from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public String findEndTime(Integer bookId,Integer userId);
    @Select("select borrowState from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public int borrowState(Integer bookId,Integer userId);
    /*插入借阅信息*/
    @Insert("insert into borrowbooks (bookId,userId,borrowTime,endTime,borrowState) values (#{bookId},#{userId},#{borrowTime},#{endTime},#{borrowState}) ")
    public int insertBorrow(Integer bookId, Integer userId, Timestamp borrowTime,Timestamp endTime,Integer borrowState);
    /*审核借阅信息*/
    @Update("update borrowbooks set borrowState=2 where id=#{id}")
    public int checkBorrow(Integer id);
    /*归还图书*/
    @Update("update borrowbooks set borrowState=#{borrowState},returnTime=#{returnTime} where userId=#{userId} and bookId=#{bookId}")
    public void back(Integer borrowState, Timestamp returnTime,Integer userId,Integer bookId);
    /*审核归还信息*/
    @Update("update borrowbooks set borrowState=4 where id=#{id}")
    public int checkBack(Integer id);

    /*查询需要审核的借阅信息*/
    @Select("select borrowbooks.id,username,score,bookTitle,borrowTime,endTime from books,user,borrowbooks where borrowbooks.borrowState=1 and borrowbooks.bookId=books.id and borrowbooks.userId=user.userId")
    public List<BorrowMessage> findBorrowMessage();
    /*查询需要审核的归还信息*/
    @Select("select borrowbooks.id,username,score,bookTitle,borrowTime,endTime from books,user,borrowbooks where borrowbooks.borrowState=3 and borrowbooks.bookId=books.id and borrowbooks.userId=user.userId")
    public List<BorrowMessage> findBackMessage();

    @Select("select borrowbooks.bookId,bookTitle,bookAuthor,bookSrc,borrowState from books,borrowbooks where userId=#{userId} and borrowbooks.bookId=books.id")
    public List<UserBorrow> userBorrowbooks(Integer userId);
    /*查询历史是否存在借阅信息*/
    @Select("select count(*) from borrowbooks where bookId=#{bookId} and userId=#{userId}")
    public int findByBookId(Integer bookId,Integer userId);
    /*更新借阅信息*/
    @Update("update borrowbooks set borrowTime=#{borrowTime},endTime=#{endTime},borrowState=#{borrowState},borrowTimes=borrowTimes+1 where bookId=#{bookId} and userId=#{userId}")
    public int updateBorrow(Timestamp borrowTime,Timestamp endTime,Integer borrowState,Integer bookId,Integer userId);
    @Update("update borrowbooks set endTime=#{endTime} where bookId=#{bookId} and userId=#{userId}")
    public int updateEndTime(Timestamp endTime,Integer bookId,Integer userId);
}
