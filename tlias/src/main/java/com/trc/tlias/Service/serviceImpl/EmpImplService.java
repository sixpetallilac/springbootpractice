package com.trc.tlias.Service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trc.tlias.Mapper.empMapper;
import com.trc.tlias.Service.empService;
import com.trc.tlias.pojo.Emp;
import com.trc.tlias.pojo.PageBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpImplService implements empService {
    @Autowired
    private empMapper em;

    @Override
    public PageBean empSelectlim(Integer page, Integer pageSize, String name, Short gender, LocalDateTime begin, LocalDateTime end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = em.listplugin(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void empIns(Emp emp) {
        if (null == emp.getCreateTime()){
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
        }

        em.empIns(emp);
    }

    @Override
    public void empUpdate(Emp emp) {
        if (null == emp.getUpdateTime()){
            emp.setUpdateTime(LocalDateTime.now());
        }
        em.empUpdate(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return em.getById(id);
    }

    @Override
    public Emp login(Emp emp) {
        return em.getByUsernameAndPassword(emp);
    }
//    @Override
//    public PageBean empSelectlim(Integer page,Integer pageSize) {
//        List<Emp> list = em.list(page, pageSize);
//        Long count = em.count();
//        return new PageBean(count,list);
//    }

}
