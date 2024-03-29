package com.example.bookmanageback.controller;
import com.example.bookmanageback.entity.Category;
import com.example.bookmanageback.entity.User;
import com.example.bookmanageback.mapper.BookMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bookmanageback.mapper.CategoryMapper;
import com.example.bookmanageback.utils.Result;

import java.util.List;
import java.util.Map;

@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @ApiOperation("查询图书分类")
    @GetMapping("inquiryClassify")
    public Result inquiryClassify(){
        List<Map<Integer,String>> classify = categoryMapper.inquiryClassify();
        return Result.ok().data("classify",classify);
    }

    @ApiOperation("查询图书详细分类")
    @GetMapping("inquiryDetailClassify")
    public Result inquiryDetailClassify(int cateId){
        List<Map<Integer,String>> detailClassify = categoryMapper.inquiryDetailClassify(cateId);
        return Result.ok().data("detailClassify",detailClassify);
    }
    @ApiOperation("统计图表")
    @GetMapping("/charts")
    public Result charts(){
        List<Map<Integer,String>> classify = categoryMapper.inquiryClassify();
        for(Map item : classify){
            int num = bookMapper.searchCateNum((String) item.get("cateName"));
            item.put("num",num);
        }
        return Result.ok().data("count",classify);
    }
    @ApiOperation("查询所有分类信息")
    @GetMapping("/inquiryCategory")
    public Result inquiryCategory(){
        List<Map<Integer,String>> category = categoryMapper.inquiryCategory();
        return Result.ok().data("category",category);
    }
    @ApiOperation("添加分类")
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody Category category){
        int i = categoryMapper.addCategory(category);
        System.out.println(i);
        if(i>0){
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}
