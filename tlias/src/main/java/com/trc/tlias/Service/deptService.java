package com.trc.tlias.Service;

import com.trc.tlias.pojo.Dept;

import java.util.List;

public interface deptService {
    public List<Dept> list();

    public void deptDel(Integer id) throws Exception;

    public void deptIns(Dept dept);

    public void deptUpdate(Dept dept);

    public Dept deptSelect(Integer ids);
}
