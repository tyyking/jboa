package com.example.demo.utils;

import com.example.demo.dataobjece.Result;

/**
 * Created by 朱昌鹏 on 2018/6/3.
 */


public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }
    public static Result success(Object object,int i) {
        Result result = new Result();
        result.setCode(0);
        if (i==5){
            result.setCode(5);

        }
        result.setMsg("ok");
        result.setData(object);
        return result;
    }
    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        return success(null);
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("error");
        return result;
    }
}
