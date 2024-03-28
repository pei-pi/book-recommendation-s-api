package com.example.bookmanageback.mapper;
import com.example.bookmanageback.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Mapper
@Transactional
public interface CategoryMapper {
    //  查询分类
    @Select("select cateID,cateName from category group by cateID,cateName")
    public List<Map<Integer,String>> inquiryClassify();

    //  查询详细分类
    @Select("select cateId,subCateID,subCateName from category where cateId=#{cateId}")
    public List<Map<Integer,String>> inquiryDetailClassify(Integer cateId);

    //   查询分类信息、
    @Select("select cateID,cateName,subCateID,subCateName from category")
    public List<Map<Integer,String>> inquiryCategory();

    //    添加分类信息
    @Insert("insert into category (cateID,cateName,subCateID,subCateName) VALUES (#{cateID}, #{cateName}, #{subCateID}, #{subCateName})")
    public int addCategory(Category category);
}
