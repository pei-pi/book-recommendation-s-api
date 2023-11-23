package com.example.bookmanageback.controller;
import com.example.bookmanageback.entity.Administrator;
import com.example.bookmanageback.utils.Result;
import com.example.bookmanageback.entity.User;
import com.example.bookmanageback.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookmanageback.utils.JwtUtils;

import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation("登录校验")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        System.out.println(user);
        String token = JwtUtils.generateToken(user.getUsername());

        return Result.ok().data("token",token);

    }

    @ApiOperation("登录校验查询用户姓名")
    @GetMapping("/info")
    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        System.out.println(username);
        return Result.ok().data("name",username);
    }

    @ApiOperation("查询所有管理员用户")
    @GetMapping("/administrator")
    public Result queryAdministrator(){
        List<Administrator> administrator = userMapper.getAllAdmin();
        System.out.println(administrator);
        return Result.ok().data("administrator",administrator);
    }

    @ApiOperation("查询用户数量")
    @GetMapping("/userCount")
    public int getUserCount(){
        int count = userMapper.getUserCount();
        return count;
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/user")
    public Result query(){
        List<User> user = userMapper.getAll();
        System.out.println(user);
        return Result.ok().data("user",user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping ("/deleteUserById")
    public String deleteUser(int userId){
        int i = userMapper.deleteUserById(userId);
        if(i>0){
            return "用户删除成功";
        } else {
          return "用户删除失败";
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/insertUser")
    public Result insertUser(User user){
//        System.out.println(user);
        int i = userMapper.insertUser(user);
        if(i>0){
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/updateUser")
    public String updateUser(User user){
        int i = userMapper.updataUser(user);
        if(i>0){
            return "用户更新成功";
        }else{
            return "用户更新失败";
        }
    }

    @ApiOperation("根据id查询用户信息")
    @GetMapping("/selectUserById")
    public User selectUserById(int userId){
        User user = userMapper.findById(userId);
        return user;
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping  ("/delete")
    public String delete(@RequestBody List<Integer> userIds){

        System.out.println(userIds);
        int i = userMapper.delete(userIds);
        if(i>0){
            return "批量删除成功";
        }else{
            return "批量删除失败";
        }
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }
}
