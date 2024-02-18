package com.trc.tlias.Exception;

import com.trc.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class exceptionhandlerTest {
    @ExceptionHandler(Exception.class)
    public Result ExceptionsResult(Exception exception){
        exception.printStackTrace();
        log.info("failed - - exceptionhandler procceed");
        return Result.failed("failed - - exceptionhandler procceed");
    }

}
