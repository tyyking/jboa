package com.example.demo.repository.employee;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.dataobjece.bizLeave;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zcp on 2018/7/12.
 */
@Mapper
public interface leaveRepository {
    /***
     * 添加请假单
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
    @Insert({"INSERT INTO biz_leave(employee_sn,starttime,endtime,leaveday,\n" +
            "leavetype,reason,`STATUS`,next_deal_sn,approve_opinion) VALUES (#{emsn},#{starttime},#{endtime},#{leaveday},#{leavetype},#{reason},#{STATUS},#{nextSn},'')"})
    int addLeaver(@Param("emsn") String emsn, @Param("starttime") String starttime, @Param("endtime") String endtime, @Param("leaveday") Integer leaveday, @Param("leavetype")
            String leavetype, @Param("reason") String reason, @Param("STATUS") String STATUS, @Param("nextSn") String nextSn);

    /**
     * 查看部门经理编号
     *
     * @param name_cn
     * @return
     */
    @Select({"SELECT sn FROM sys_employee,sys_position,sys_department WHERE \n" +
            "sys_position.`id`=sys_employee.`posiyion_id`AND\n" +
            "sys_department.`id`=sys_employee.`department_id`\n" +
            "AND sys_position.`name_cn`=#{namecn} AND \n" +
            "sys_department.`NAME`=#{deName}"})
    String finddepartmentId(@Param("namecn") String name_cn, @Param("deName") String deName);

    /**
     * 查看个人请假单
     *
     * @param sn
     * @return
     */
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave  \n" +
            "WHERE biz_leave.`employee_sn`=#{sn} ORDER BY CreateTime DESC"})
    List<leaveDTO> deFindLevea(@Param("sn") String sn);

    /**
     * 按时间段查询请假单
     *
     * @param sn
     * @param createTime
     * @param endTime
     * @return
     */
    @Select({"SELECT id,leaveday,employee_sn emsn,\n" +
            "\n" +
            "            (SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=emsn)eName,\n" +
            "            CreateTime,modifytime,approve_opinion approveOpinion,`status` FROM biz_leave \n" +
            "            WHERE biz_leave.`employee_sn`=#{sn}  AND #{createTime}<= biz_leave.`createtime` AND biz_leave.createtime<=#{endTime} ORDER BY CreateTime DESC\n"})
    List<leaveDTO> deFindLeveaBytime(@Param("sn") String sn, @Param("createTime") String createTime, @Param("endTime") String endTime);

    /**
     * 查看请教单详情
     * @param id
     * @return
     */
    @Select({" SELECT employee_sn esn,\n"+
            "(SELECT sys_employee.`NAME` FROM sys_employee WHERE sys_employee.`sn`=esn) eName, \n"+
            "(SELECT sys_department.`NAME` FROM sys_department,sys_employee WHERE sys_employee.`department_id`=sys_department.`id` \n"+
            " AND sys_employee.`sn`=esn ) deName,starttime,endtime,leaveday,leavetype,\n"+
            "reason,`status`,biz_leave.`approve_opinion` apperveOpinion FROM biz_leave WHERE id=#{id}"})
    leaveShowDTO empShowLeaver(@Param("id") Integer id);

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
  @Update({" UPDATE biz_leave SET starttime=#{starttime},endtime=#{endtime},leaveday=#{leaveday},leavetype=#{leavetype},reason=#{reason} WHERE id=#{id}"})
    int UpdateLeaver(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("leaveday") Integer leaveday,@Param("leavetype") String leavetype,@Param("reason") String reason,@Param("id") Integer id);

    /**
     * 删除请假单
     * @param id
     * @return
     */
  @Delete({" DELETE FROM biz_leave WHERE id=#{id}"})
  int DeleteLeaver(@Param("id") Integer id);

    /**
     * 审批请假单
     * @param id
     * @param status
     * @return
     */
  @Update({"UPDATE biz_leave SET biz_leave.`STATUS`=#{status} WHERE id=#{id}"})
int updleaver(@Param("id") Integer id,@Param("status") String status);
  @Select({"SELECT biz_leave.`employee_sn` as employee_Sn,biz_leave.`starttime` as starttime,biz_leave.`endtime` as endtime," +
          "biz_leave.`leaveday` as leaveday,biz_leave.`reason` as reason,biz_leave.`STATUS` as status,biz_leave.`leavetype` as leavetype," +
          "biz_leave.`next_deal_sn` as nextDealSn," +
          "biz_leave.`approve_opinion` as approve_Opinion,biz_leave.`createtime` as createtime," +
          "biz_leave.`modifytime` as modifytime FROM `biz_leave`  " +
          "WHERE biz_leave.`id`=#{id}"})
    bizLeave qeuryBizLeaveById(@Param("id") Integer id);

  @Insert({"INSERT INTO   biz_leave  VALUES(NULL,#{employee_Sn},#{starttime},#{endtime},#{leaveday},#{reason},#{status},#{leavetype}," +
          "#{nextDealSn},#{approve_Opinion},#{createtime},#{modifytime})               \n"})
  int add(bizLeave bizLeave);
    }
