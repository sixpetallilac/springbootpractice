package com.trc.tlias.controller;

import com.trc.tlias.Service.empService;
import com.trc.tlias.Service.serviceImpl.EmpImplService;
import com.trc.tlias.pojo.Emp;
import com.trc.tlias.pojo.PageBean;
import com.trc.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/emps")
@Slf4j
@RestController
public class empController {
    @Autowired
    private empService es;
    @GetMapping
    public Result empSelectlim(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10")Integer pageSize, String name, Short gender, LocalDateTime begin,LocalDateTime end){
        log.info("分页查询员工{},{}",page,pageSize);
        PageBean pageBean = es.empSelectlim(page, pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result empIns(@RequestBody Emp emp){
        log.info("添加员工信息{}",emp);
        es.empIns(emp);
        return Result.success();
    }

    @PutMapping
    public Result empUpdate(@RequestBody Emp emp){
        log.info("修改员工信息{}",emp);
        es.empUpdate(emp);

        return Result.success();
    }
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        log.info("getById员工信息:{}",id);
        Emp byId = es.getById(id);
        return Result.success(byId);
    }

}
