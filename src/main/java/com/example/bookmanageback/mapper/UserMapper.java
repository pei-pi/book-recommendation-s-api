package com.example.bookmanageback.mapper;

import com.example.bookmanageback.entity.Administrator;
import com.example.bookmanageback.entity.User;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
public interface UserMapper {
//  查找所有用户
    @Select("select * from user")
    public List<User> getAll();

    //查询用户数量
    @Select("select Count(*) from user")
    public int getUserCount();

//  根据id查找用户
    @Select("select * from user where userId = #{userId}")
    public User findById(int userId);
//  删除用户
    @Delete("delete from user where userId = #{userId}" )
    public int deleteUserById(int userId);
//  插入用户
    @Insert("insert into user (userId,username,userPassword) VALUES (#{userId}, #{username}, #{userPassword})")
    public int insertUser(User user);
//  修改用户信息
    @Update("update user set username=#{username},userPassword=#{userPassword},score=#{score} where userId = #{userId}")
    public int updataUser(User user);
//批量删除
//    @Delete("delete from user where userId in (#{userIds})")

    @Delete("<script>DELETE FROM user WHERE userId IN <foreach item='id' collection='userIds' open='(' separator=',' close=')'>#{id}</foreach></script>")
    public int delete(@Param("userIds") List<Integer> userIds);

    //  查找所有管理员用户
    @Select("select * from administrator")
    public List<Administrator> getAllAdmin();
}
