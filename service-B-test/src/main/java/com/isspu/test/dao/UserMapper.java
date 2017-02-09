package com.isspu.test.dao;

import com.isspu.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by linwx on 2017/2/9.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User ")
    List<User> findAll();

    @Insert("INSERT INTO User(name, gender) VALUES(#{name}, #{gender})")
    Integer insert(@Param("name") String name, @Param("gender") Boolean gender);
}
