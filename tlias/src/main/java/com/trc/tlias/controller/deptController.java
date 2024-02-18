package com.trc.tlias.controller;

import com.trc.tlias.Annotationpkg.Log;
import com.trc.tlias.Service.deptService;
import com.trc.tlias.pojo.Dept;
import com.trc.tlias.pojo.Emp;
import com.trc.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@Slf4j
@RestController
public class deptController {
    @Autowired
    private deptService deptService;

//    private static Logger log = LoggerFactory.getLogger(deptController.class);
//    @GetMapping("/depts")
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result Selectlist(){
        log.info("查询全部部门数据");
        List<Dept> deptlist = deptService.list();
        return Result.success(deptlist);
    }
    @GetMapping("/{id}")
    public Result SelectById(@PathVariable Integer id){
        log.info("查询指定ID数据");
        Dept dept = deptService.deptSelect(id);
        return Result.success(dept);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result DelFunction(@PathVariable Integer id) throws Exception {
        log.info("删除指定部门数据",id);
        deptService.deptDel(id);

        return Result.success();
    }
    @Log
    @PostMapping
    public Result InsertFunction(@RequestBody Dept dept){
        log.info("新增部门｛｝",dept);
        deptService.deptIns(dept);
        return Result.success();
    }
    @Log
    @PutMapping
    public Result UpdateFunction(@RequestBody Dept dept){
        log.info("条件修改部门｛｝",dept);
        deptService.deptUpdate(dept);
        return Result.success();
    }



}
