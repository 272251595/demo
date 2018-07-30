package com.panshi.demo.mapper;

import com.panshi.demo.domain.UserDao;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper {
	
   @Select("select * from category where id=#{id}")
   List<UserDao> query(@Param("id") int id);

   @Select("select * from category where name like '%${name}%' limit #{startId},#{limit}")
   List<UserDao> queryLick(@Param("startId") int startId,@Param("limit") int limit,@Param("name") String name);

    @Select("select count(*) from category where name like '%${name}%'")
    int queryAll(@Param("name") String name);

    @Insert("INSERT INTO category(NAME,sex,age)VALUES(#{u.name},#{u.sex},#{u.age})")
    void stuAdd(@Param("u") UserDao user);

    @Delete("delete from category where id in(${id})")
    void studelete(@Param("id") String id);

    
    @Update("update category set name=#{u.name},sex=#{u.sex},age=#{u.age} where id=#{u.id}")
	void updateUser(@Param("u") UserDao user);
   
}
