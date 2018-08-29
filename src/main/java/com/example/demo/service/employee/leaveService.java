package com.example.demo.service.employee;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.dataobjece.bizLeave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zcp on 2018/7/12.
 */
public interface leaveService {
    /**
     * 申请请假单
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
    int addLeaver(String emsn, String starttime,String endtime, Integer leaveday, String leavetype, String reason, String STATUS, String nextSn);

    /**
     * 查看部门经理编号
     * @param name_cn
     * @param deName
     * @return
     */
    String finddepartmentId(String name_cn,String deName);

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    leaveShowDTO empShowLeaver(Integer id);

    /**
     * 修改请假单
     * @param starttime
     * @param endtime
     * @param leaveday
     * @param leavetype
     * @param reason
     * @param id
     * @return
     */
    int UpdateLeaver(String starttime,String endtime,Integer leaveday,String leavetype,String reason,Integer id);
    List<leaveDTO> deFindLeveaBytime(@Param("sn") String sn, @Param("createTime") String createTime, @Param("endTime") String endTime);

    /**
     * 删除请假单
     * @param id
     * @return
     */
    int DeleteLeaver(int id);
    bizLeave qeuryBizLeaveById(@Param("id") Integer id);


    int add(bizLeave bizLeave);
    /**
     *
     * @param id
     * @param status
     * @return
     */
    int updleaver(Integer id,String status);
}
