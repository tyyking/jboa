package com.example.demo.publics.service;

import org.apache.ibatis.annotations.Param;

/**
 * Created by zcp on 2018/7/29.
 */
public interface publicService {
    String findEmpSn(String dName,String PNanem,String name);
}
