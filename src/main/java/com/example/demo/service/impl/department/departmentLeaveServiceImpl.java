package com.example.demo.service.impl.department;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.repository.department.departmentLeaveRepositoty;
import com.example.demo.service.department.departmentLeaveService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcp on 2018/7/25.
 */
@Service
public class departmentLeaveServiceImpl implements departmentLeaveService {
    @Autowired
    private departmentLeaveRepositoty departmentLeave;

    @Override
    public List<leaveDTO> deFindLeveaTwo(String sn) {
        return departmentLeave.deFindLeveaTwo(sn);
    }

    @Override
    public List<leaveDTO> deFindLeveaByStatusAndtime(String sn, String EVENT, String createTime, String endTime) {
        return departmentLeave.deFindLeveaByStatusAndtime(sn,EVENT,createTime,endTime);
    }

    /**
     * 部门经理查看请假
     * @param sn
     * @return
     */
    @Override
    public List<leaveDTO> deFindLevea(String sn) {
        return departmentLeave.deFindLevea(sn);
    }

    /***
     * 查看请假单详情
     * @param id
     * @return
     */
    @Override
    public leaveShowDTO deFindLeveaShow(Integer id) {
        return departmentLeave.deFindLeveaShow(id);
    }

    /**
     * 修改请假单
     * @param id
     * @param status
     * @param approveOpinion
     * @return
     */
    @Override
    public int accotion(Integer id, String status, String approveOpinion) {
        return departmentLeave.Updateaccotion(id,status,approveOpinion);
    }

    @Override
    public List<leaveDTO> deFindLeveaByStatus(String sn, String EVENT) {
        return departmentLeave.deFindLeveaByStatus(sn,EVENT);
    }

    @Override
    public List<leaveDTO> deFindLeveaBytime(String sn, String createTime, String endTime) {
        return departmentLeave.deFindLeveaBytime(sn,createTime,endTime);
    }
}
