package com.trc.tlias.Mapper;

import com.trc.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface deptMapper {
    //getmapping
    public List<Dept> selectList();
    public Dept deptSelect(Integer ids);
    //delmapping

    public void deptDel(Integer id);
    //postins
//    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")

    public void deptIns(Dept dept);

    public void deptUpdate(Dept dept);

    void empdeptIdDel(Integer id);
}
