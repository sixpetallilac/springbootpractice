package com.trc.tlias.Service;

import com.trc.tlias.pojo.Emp;
import com.trc.tlias.pojo.PageBean;

import java.time.LocalDateTime;

public interface empService {
    public PageBean empSelectlim(Integer page, Integer pageSize, String name, Short gender, LocalDateTime begin, LocalDateTime end);

    public void empIns(Emp emp);

    public void empUpdate(Emp emp);

    Emp getById(Integer id);

    Emp login(Emp emp);
}
