package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.Book;
import com.example.bookmanageback.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface BookMapper {
    //查询所有图书的相关信息
    @Select("select * from books")
    public List<Book> getAllBook();
    @Select("select * from books where id = #{bookId}")
    public Book findById(int bookId);
    //查询图书数目
    @Select("select Count(*) from books")
    public int getCount();

    //查询借阅中的图书数量
    @Select("select Count(*) from borrowBooks where state=0")
    public int getBorrowCount();
    // 删除图书
    @Delete("delete from books where id = #{bookId}" )
    public int deleteBookById(Integer bookId);
    // 批量删除图书
    @Delete("<script>DELETE FROM books WHERE id IN <foreach item='id' collection='bookIds' open='(' separator=',' close=')'>#{id}</foreach></script>")
    public int bantchDelete(@Param("bookIds") List<Integer> bookIds);
    // 编辑图书
    @Update("update books set bookTitle=#{bookTitle},bookAuthor=#{bookAuthor},bookTags=#{bookTags},bookContent=#{bookContent},bookSrc=#{bookSrc},bookCategory=#{bookCategory},bookDetailCategory=#{bookDetailCategory},store=#{store} where id = #{id}")
    public int updataBook(Book book);

}
