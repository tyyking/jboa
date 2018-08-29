package com.example.demo.service.department;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zcp on 2018/7/25.
 */
public interface departmentLeaveService {
    /*部门经理查看请假单*/
    List<leaveDTO> deFindLevea(String sn);
    List<leaveDTO> deFindLeveaTwo(String sn);

    /*部门经理查看请假单详情*/
    leaveShowDTO deFindLeveaShow(Integer id);
    /*修改请假单*/
    int accotion(Integer id,String status,String approveOpinion);
    /*部门经理查看请假单*/
    List<leaveDTO> deFindLeveaBytime( String sn,String createTime, String endTime);

    List<leaveDTO> deFindLeveaByStatus(@Param("sn") String sn, @Param("EVENT") String EVENT);
    List<leaveDTO> deFindLeveaByStatusAndtime(@Param("sn") String sn,@Param("EVENT") String EVENT,@Param("createTime") String createTime,@Param("endTime") String endTime);


}

