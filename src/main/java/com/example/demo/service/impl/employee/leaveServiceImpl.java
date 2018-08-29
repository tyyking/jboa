package com.example.demo.service.impl.employee;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.dataobjece.bizLeave;
import com.example.demo.repository.employee.leaveRepository;
import com.example.demo.service.employee.leaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcp on 2018/7/12.
 */
@Service
public class leaveServiceImpl implements leaveService {
    @Autowired
    private leaveRepository leaveRepository;

    /**
     * 添加报销单
     * @param emsn
     * @param starttime
     * @param endtime
     * @param leaveday
     * @param leavetype
     * @param reason
     * @param STATUS
     * @param nextSn
     * @return
     */
    @Override
    public int addLeaver(String emsn, String starttime, String endtime, Integer leaveday, String leavetype, String reason, String STATUS, String nextSn) {
        return leaveRepository.addLeaver(emsn,starttime,endtime,leaveday,leavetype,reason,STATUS,nextSn);
    }

    /**
     * 查看部门经理编号
     * @param name_cn
     * @param deName
     * @return
     */
    @Override
    public String finddepartmentId(String name_cn, String deName) {
        return leaveRepository.finddepartmentId(name_cn,deName);
    }

    /**
     * 查看请假单详情
     * @param id
     * @return
     */
    @Override
    public leaveShowDTO empShowLeaver(Integer id) {
        return leaveRepository.empShowLeaver(id);
    }

    @Override
    public int UpdateLeaver(String starttime, String endtime, Integer leaveday, String leavetype, String reason, Integer id) {
        return leaveRepository.UpdateLeaver(starttime,endtime,leaveday,leavetype,reason,id);
    }

    @Override
    public int DeleteLeaver(int id) {
        return leaveRepository.DeleteLeaver(id);
    }

    @Override
    public List<leaveDTO> deFindLeveaBytime(String sn, String createTime, String endTime) {
        return leaveRepository.deFindLeveaBytime(sn,createTime,endTime);
    }

    @Override
    public bizLeave qeuryBizLeaveById(Integer id) {
        return leaveRepository.qeuryBizLeaveById(id);
    }

    @Override
    public int add(bizLeave bizLeave) {
        return leaveRepository.add(bizLeave);
    }

    @Override
    public int updleaver(Integer id, String status) {
        return leaveRepository.updleaver(id,status);
    }
}
