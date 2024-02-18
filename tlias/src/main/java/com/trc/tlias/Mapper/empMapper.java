package com.trc.tlias.Mapper;

import com.trc.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface empMapper {

//    @Select("select count(*) from emp")
//    public Long count();

//    @Select("select * from emp limit #{start},#{size}")
//    public List<Emp> list(Integer start,Integer size);


    public List<Emp> listplugin(String name, Short gender, LocalDateTime begin, LocalDateTime end);

    public void empIns(Emp emp);

    public void empUpdate(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);
//name = #{name} and
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);


    @Delete("delete from emp where id = #{id}")
    void empDeptIdDel(Integer id);
}
