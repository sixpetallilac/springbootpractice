package com.trc.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String msg;
    private Integer code;
    private Object data;
    //增删改成功
    public static Result success(){
        return new Result("success",1,null);
    }

    //查询成功
    public static Result success(Object obj){
        return new Result("success",1,obj);
    }

    public static Result failed(String msg){
        return new Result(msg,0,null);
    }

}
