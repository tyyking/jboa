package com.example.demo.repository.department;

import com.example.demo.DTO.findAllExpenseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zcp on 2018/7/26.
 */
@Mapper
public interface departmentvoucherRepository {
    /*查看当前部门的报销单*/
    @Select({"    SELECT  biz_claim_voucher.`id` bId,\n" +
            "            (SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "            WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId) \n" +
            "            AS nexSn,\n" +
            "            biz_claim_voucher.`create_time` bTime,\n" +
            "            sys_employee.`NAME` eName,\n" +
            "            biz_claim_voucher.`total_account` bAccount,\n" +
            "            biz_claim_voucher.`STATUS` bStatus\n" +
            "            FROM\n" +
            "            biz_claim_voucher ,sys_employee,sys_department\n" +
            "            WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND\n" +
            "            sys_department.`id`=sys_employee.`department_id` AND\n" +
            "            biz_claim_voucher.`STATUS`  IN('已提交') AND (SELECT sys_employee.`department_id` FROM sys_employee WHERE sys_employee.`sn`=#{sn})IN (SELECT sys_employee.`department_id` FROM biz_claim_voucher,sys_employee WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND biz_claim_voucher.`next_deal_sn`=#{sn})  ORDER BY \n" +
            "            biz_claim_voucher.`id` DESC "})
    List<findAllExpenseDto> findExpenseBygeder(@Param("sn") String sn);
    /*查看当前部门的报销单+状态*/
    @Select({"SELECT  biz_claim_voucher.`id` bId,\n" +
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)  \n" +
            "AS nexSn,\n" +
            "biz_claim_voucher.`create_time` bTime,\n" +
            "sys_employee.`NAME` eName,\n" +
            "biz_claim_voucher.`total_account` bAccount,\n" +
            "biz_claim_voucher.`STATUS` bStatus\n" +
            "FROM\n" +
            "biz_claim_voucher ,sys_employee,sys_department\n" +
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND\n" +
            "sys_department.`id`=sys_employee.`department_id` AND\n" +
            "biz_claim_voucher.`STATUS` like '%${status}%'\n" +
            "AND biz_claim_voucher.`next_deal_sn`=#{sn} ORDER BY \n" +
            "biz_claim_voucher.`id` DESC  "})
    List<findAllExpenseDto> findExpenseBygederByStatus(@Param("sn") String sn,@Param("status") String status);
    /*查看当前部门的报销单+时间*/
    @Select({"SELECT  biz_claim_voucher.`id` bId,\n" +
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)  \n" +
            "AS nexSn,\n" +
            "biz_claim_voucher.`create_time` bTime,\n" +
            "sys_employee.`NAME` eName,\n" +
            "biz_claim_voucher.`total_account` bAccount,\n" +
            "biz_claim_voucher.`STATUS` bStatus\n" +
            "FROM\n" +
            "biz_claim_voucher ,sys_employee,sys_department\n" +
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND\n" +
            "sys_department.`id`=sys_employee.`department_id` AND\n" +
            "biz_claim_voucher.`STATUS` like '%${status}%' and \n" +
            "biz_claim_voucher.`create_time`<=#{endTime} AND\n" +
            "biz_claim_voucher.`create_time`>=#{startTime}" +
            "AND biz_claim_voucher.`next_deal_sn`=#{sn} ORDER BY \n" +
            "biz_claim_voucher.`id` DESC "})
    List<findAllExpenseDto> findExpenseBygederByStime(@Param("sn") String sn,@Param("status") String status,@Param("startTime") String startTime,@Param("endTime") String endTime);

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    @Select({"SELECT  biz_claim_voucher.`id` bId, \n" +
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher \n" +
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)  AS nexSn, \n" +
            "biz_claim_voucher.`create_time` bTime, \n" +
            "sys_employee.`NAME` eName, \n" +
            "biz_claim_voucher.`total_account` bAccount, \n" +
            "biz_claim_voucher.`STATUS` bStatus,\n" +
            "sys_department.`NAME` deName,\n" +
            "sys_position.`name_cn` poName\n" +
            "FROM \n" +
            "biz_claim_voucher ,sys_employee,sys_department,sys_position\n" +
            "\n" +
            "WHERE \n" +
            "sys_position.`id`=sys_employee.`posiyion_id`AND\n" +
            "biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n" +
            "sys_department.`id`=sys_employee.`department_id` AND \n" +
            "biz_claim_voucher.`id`=35\n" +
            " ORDER BY\n" +
            "biz_claim_voucher.`id` DESC"})
    findAllExpenseDto findExpenseById(@Param("id") Integer id);
}
