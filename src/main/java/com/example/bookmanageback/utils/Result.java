package com.example.bookmanageback.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //成功静态方法
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(30000);
        r.setMessage("失败");
        return r;
    }
    public static Result noStore(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(30000);
        r.setMessage("图书暂无余量");
        return r;
    }

    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
