package com.example.demo.repository.department;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcp on 2018/7/25.
 */
@Mapper
public interface departmentLeaveRepositoty {
    /*部门经理查看报销单*/
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "WHERE biz_leave.`employee_sn`=#{sn} AND biz_leave.`STATUS` IN ('已打回','新创建','打回','通过') ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLevea(@Param("sn") String sn);
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "            CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "            WHERE    biz_leave.`STATUS` IN ('待审批') AND\n" +
            "            (SELECT department_id FROM sys_employee WHERE sn=#{sn})= (SELECT department_id FROM sys_employee WHERE sn IN (SELECT \n" +
            "            biz_leave.`employee_sn` FROM biz_leave  \n" +
            "            WHERE    biz_leave.`STATUS` IN ('待审批')ORDER BY CreateTime DESC)) ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLeveaTwo(@Param("sn") String sn);
    /*部门经理查看报销单+时间*/
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "WHERE biz_leave.`next_deal_sn`=#{sn}  AND biz_leave.`createtime`>=#{createTime} AND createtime<=#{endTime} ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLeveaBytime(@Param("sn") String sn,@Param("createTime") String createTime,@Param("endTime") String endTime);

    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "WHERE biz_leave.`next_deal_sn`=#{sn}  AND biz_leave.`EVENT`=#{EVENT} ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLeveaByStatus(@Param("sn") String sn,@Param("EVENT") String EVENT);
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "WHERE biz_leave.`next_deal_sn`=#{sn}  AND biz_leave.`EVENT`=#{EVENT} AND biz_leave.`createtime`<=#{createTime} AND endtime<=#{endTime} ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLeveaByStatusAndtime(@Param("sn") String sn,@Param("EVENT") String EVENT,@Param("createTime") String createTime,@Param("endTime") String endTime);
    /**
     * 部门经理查看请假单详情
     * @param id
     * @return
     */
    @Select({"SELECT employee_sn esn,\n"+
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=esn) eName,\n"+
            "(SELECT sys_department.`NAME` FROM sys_department,sys_employee WHERE sys_employee.`department_id`=sys_department.`id`\n"+
            "AND sys_employee.`sn`=esn ) deName,starttime,endtime,leaveday,leavetype,\n"+
            "reason,`status`,biz_leave.`approve_opinion`  FROM biz_leave WHERE id=#{id}"})
    leaveShowDTO deFindLeveaShow(@Param("id") Integer id);

    /**
     *审批请假单
     * @param id
     * @param status
     * @param approveOpinion
     * @return
     */
    @Update({"UPDATE biz_leave SET biz_leave.`STATUS`=#{status},next_deal_sn='',approve_opinion=#{approveOpinion} WHERE id=#{id}"})
    int Updateaccotion(@Param("id") Integer id,@Param("status") String status,@Param("approveOpinion") String approveOpinion);
}
