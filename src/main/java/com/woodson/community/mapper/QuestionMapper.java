package com.woodson.community.mapper;

import com.woodson.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void insert(Question question);
    @Select({"select * from question limit #{index},#{size}"})
    List<Question> getQuestions(@Param("index") int index,
                                @Param("size") Integer size);
    @Select("select count(1) from question")
    Integer getPageCount();

    @Select("select * from question where id = #{id}")
    Question getQuestionById(@Param("id") Integer id);
}
