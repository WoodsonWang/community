package com.woodson.community.community.mapper;

import com.woodson.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
//    #{name}自动提取出user中的name
    @Insert("insert into USER(NAME,account_id,token,gmt_create,gmt_modified,head) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{head})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findUserByID(@Param("id") Integer creator);
}
