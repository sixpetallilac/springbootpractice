package com.trc.tlias.Service.serviceImpl;

import com.trc.tlias.Mapper.deptLogMapper;
import com.trc.tlias.Service.deptLogService;
import com.trc.tlias.pojo.DeptLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class deptLogImplService implements deptLogService {
    @Autowired
    private deptLogMapper dlm;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deptLogFunction(DeptLog deptLog) {
        dlm.deptLogInsertFunction(deptLog);
    }
}
