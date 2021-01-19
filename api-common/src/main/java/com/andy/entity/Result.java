package com.andy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result ok(int code,String message,Object data){
        return new Result(code,message,data);
    }

    public static Result error(int code,String message){
        return new Result(code,message);
    }
}
