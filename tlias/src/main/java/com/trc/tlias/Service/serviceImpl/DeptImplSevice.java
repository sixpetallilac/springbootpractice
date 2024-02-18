package com.trc.tlias.Service.serviceImpl;

import com.trc.tlias.Annotationpkg.Log;
import com.trc.tlias.Aop.PointcutAnnotation;
import com.trc.tlias.Mapper.deptMapper;
import com.trc.tlias.Mapper.empMapper;
import com.trc.tlias.Service.deptService;
import com.trc.tlias.pojo.Dept;
import com.trc.tlias.pojo.DeptLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class DeptImplSevice implements deptService {
    @Autowired
    private deptMapper dm;
    @Autowired
    private empMapper em;
    @Autowired
    private deptLogImplService ds;
    @Override
    public List<Dept> list() {
        return dm.selectList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override//Transactional事务传播test
    public void deptDel(Integer id) throws Exception {
        try {
            dm.deptDel(id);
//            if (true){
//               throw new Exception("testerror");
//            }
            em.empDeptIdDel(id);//del
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("删除id："+id);
            ds.deptLogFunction(deptLog);
        }


    }
    @PointcutAnnotation
    @Override
    public void deptIns(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        dm.deptIns(dept);
    }

    @Override
    public void deptUpdate(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dm.deptUpdate(dept);
    }
    @PointcutAnnotation
    @Override
    public Dept deptSelect(Integer ids) {
        Dept dept = dm.deptSelect(ids);
        return dept;
    }

}
