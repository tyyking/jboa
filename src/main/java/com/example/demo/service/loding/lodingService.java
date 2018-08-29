package com.example.demo.service.loding;

import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.sysDepartment;

import java.util.List;

/**
 * Created by zcp on 2018/7/28.
 */
public interface lodingService {
    /**
     * 登录
     * @param sn
     * @param password
     * @param ename
     * @return
     */
    lodingDTO loding(String sn, String password, String ename);

    /**
     * 查看当前部门
     * @return
     */
    List<sysDepartment> findDepartment();
}
