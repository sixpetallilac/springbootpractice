package com.trc.tlias.Mapper;

import com.trc.tlias.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface deptLogMapper {
    @Insert("insert into dept_log (create_time, description) values (#{createTime},#{description})")
    void deptLogInsertFunction(DeptLog deptLog);

}
