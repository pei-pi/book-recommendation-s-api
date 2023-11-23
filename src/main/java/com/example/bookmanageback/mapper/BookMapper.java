package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface BookMapper {
    //查询所有图书的相关信息
    @Select("select * from spiders_books")
    public List<Book> getAllBook();

    //查询图书数目
    @Select("select Count(*) from bookss")
    public int getCount();

    //查询借阅中的图书数量
    @Select("select Count(*) from borrowBooks where state=0")
    public int getBorrowCount();

}
