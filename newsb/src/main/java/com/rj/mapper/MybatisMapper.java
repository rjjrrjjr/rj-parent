package com.rj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rj.domain.User;

/**
 * Created by 10064028 on 2018/3/13.
 */
public interface MybatisMapper {

    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO t_USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
