package com.example.bookmanageback.mapper;
import com.example.bookmanageback.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
@Transactional
public interface ActivityMapper {
    /*插入用户行为信息*/
    @Insert("insert into useractivities (userId,bookId,activityType,timestamp) VALUES (#{userId}, #{bookId}, #{activityType}, #{timestamp})")
    public void insertActivity(Integer userId, Integer bookId, Integer activityType, Timestamp timestamp);
    /*查找借阅和收藏书籍信息*/
    @Select("SELECT *, borrow_count*3+collect_count*2 as score FROM ( " +
            "SELECT bookId,\n" +
            "    SUM(CASE WHEN activityType = 3 THEN 1 ELSE 0 END) AS borrow_count,\n" +
            "    SUM(CASE WHEN activityType = 2 THEN 1 ELSE 0 END) AS collect_count\n" +
            "FROM useractivities\n" +
            "GROUP BY bookId) AS subquery order by score desc;")
    public List<Activity> findActivity();
}
