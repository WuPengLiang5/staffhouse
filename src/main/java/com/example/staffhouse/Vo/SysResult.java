package com.example.staffhouse.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysResult implements Serializable {
    private static final long serialVersionUID = 1957897089174098972L;
    private Integer code;//200成功 201失败
    private String msg;//服务器返回提示信息
    private Object data;//服务器返回提示信息
    public static  SysResult fail(){
        return new SysResult(201,"服务器执行失败",null);
    }
    public static  SysResult fail(String msg){
        return new SysResult(201,msg,null);
    }
    public static  SysResult fail(Integer code,String msg){
        return new SysResult(code,msg,null);
    }
    public static SysResult success(Integer code,String msg,Object data){

        return new SysResult(code,msg,data);
    }
    public static SysResult success(String msg,Object data){

        return new SysResult(20000,msg,data);
    }

    public static SysResult nullParam(){
        return new SysResult(405,"参数不能为空",null);
    }

}
