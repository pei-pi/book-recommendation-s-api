package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.Book;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface BookMapper {
    //查询所有图书的相关信息
    @Select("select * from books")
    public List<Book> getAllBook();
    /*根据书名查找id*/
    @Select("select id from books where bookTitle=#{bookTitle}")
    public Integer findByName(String bookTitle);

    @Select("select * from books where id = #{bookId}")
    public Book findById(int bookId);

    //查询图书数目
    @Select("select Count(*) from books")
    public int getCount();

    //查询借阅中的图书数量
    @Select("select Count(*) from borrowBooks where borrowState=2 or borrowState=1 or borrowState=3")
    public int getBorrowCount();

    // 删除图书
    @Delete("delete from books where id = #{bookId}" )
    public int deleteBookById(Integer bookId);

    // 批量删除图书
    @Delete("<script>DELETE FROM books WHERE id IN <foreach item='id' collection='bookIds' open='(' separator=',' close=')'>#{id}</foreach></script>")
    public int bantchDelete(@Param("bookIds") List<Integer> bookIds);

    //  编辑图书
    @Update("update books set bookTitle=#{bookTitle},bookAuthor=#{bookAuthor},bookTags=#{bookTags},bookContent=#{bookContent},bookSrc=#{bookSrc},bookCategory=#{bookCategory},bookDetailCategory=#{bookDetailCategory},store=#{store} where id = #{id}")
    public int updataBook(Book book);
    //   添加图书
    @Insert("insert into books (bookTitle,bookAuthor,bookTags,bookContent,bookSrc,bookCategory,bookDetailCategory,store) VALUES (#{bookTitle}, #{bookAuthor}, #{bookTags}, #{bookContent}, #{bookSrc} ,#{bookCategory}, #{bookDetailCategory}, #{store})")
    public int addBook(Book book);
    //   查询分类书籍数量
    @Select("select count(*) from books where bookCategory=#{cateName}")
    public int searchCateNum(String cateName);

    @Select("select * from books where bookDetailCategory=#{subCateName}")
    public List<Book> getBookByCategory(String subCateName);

    /*根据图书id查找余量*/
    @Select("select store from books where id=#{bookId}")
    public int store(Integer bookId);
    /*图书余量减一*/
    @Update("update books set store=store-1 where id=#{bookId}")
    public void decount(Integer bookId);
    /*图书余量加一*/
    @Update("update books set store=store+1 where id=(select bookId from borrowbooks where id=#{id})")
    public void addcount(Integer id);

    @Select("select * from books order by id desc limit #{begin},#{num}")
    public List<Book> getNewBook(Integer begin,Integer num);


}
