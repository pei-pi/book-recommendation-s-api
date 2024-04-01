package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.UserCollection;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Mapper
@Transactional
public interface CollectionMapper {
    @Select("select count(*) from collection where bookId=#{bookId} and userId=(select userId from user where username=#{username})")
    public int ifCollection(Integer bookId,String username);

    @Insert("insert into collection (bookId,userId,collectionTime) values (#{bookId},#{userId},#{collectionTime})")
    public int insertCollection(Integer bookId, Integer userId, Timestamp collectionTime);

    @Delete("delete from collection where bookId=#{bookId} and userId=#{userId}")
    public int deleteCollection(Integer bookId,Integer userId);

    /*查询某用户收藏的书籍*/
    @Select("select collection.bookId,bookTitle,bookAuthor,bookSrc from collection,books where userId=#{userId} and collection.bookId=books.id")
    public List<UserCollection> userCollection(Integer userId);

}
