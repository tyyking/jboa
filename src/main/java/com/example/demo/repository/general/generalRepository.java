package com.example.demo.repository.general;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.resultDTO;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zcp on 2018/7/22.
 */
@Mapper
public interface generalRepository {
    /*处理已审批的报销单*/
    @Select({" SELECT  biz_claim_voucher.`id` bId,\n" +
            "        (SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "        WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId) " +
            "AS nexSn,\n" +
            "        biz_claim_voucher.`create_time` bTime,\n" +
            "        sys_employee.`NAME` eName,\n" +
            "        biz_claim_voucher.`total_account` bAccount,\n" +
            "        biz_claim_voucher.`STATUS` bStatus\n" +
            "        FROM\n" +
            "        biz_claim_voucher ,sys_employee,sys_department\n" +
            "        WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND\n" +
            "        sys_department.`id`=sys_employee.`department_id` AND\n" +
            "        biz_claim_voucher.`STATUS`  IN('通过') order by"+
            "        biz_claim_voucher.`id` DESC"})
    List<findAllExpenseDto> generalExpense();
    /*按状态查询*/
    @Select({" SELECT  biz_claim_voucher.`id` bId, \n"+
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher \n"+
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)  \n"+
            "AS nexSn, \n"+
            "biz_claim_voucher.`create_time` bTime, \n"+
            "sys_employee.`NAME` eName, \n"+
            "biz_claim_voucher.`total_account` bAccount, \n"+
            "biz_claim_voucher.`STATUS` bStatus \n"+
            "FROM \n"+
            "biz_claim_voucher ,sys_employee,sys_department \n"+
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n"+
            "sys_department.`id`=sys_employee.`department_id` AND \n"+
            "biz_claim_voucher.`STATUS` =#{status}\n"+
            "ORDER BY\n"+
            "biz_claim_voucher.`id` DESC"})
    List<findAllExpenseDto> generalExpenseByStatus(String status);
     /*按时间范围查询+状态*/
     @Select({" SELECT  biz_claim_voucher.`id` bId, \n"+
             "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher \n"+
             "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)  \n"+
             "AS nexSn, \n"+
             "biz_claim_voucher.`create_time` bTime, \n"+
             "sys_employee.`NAME` eName, \n"+
             "biz_claim_voucher.`total_account` bAccount, \n"+
             "biz_claim_voucher.`STATUS` bStatus \n"+
             "FROM \n"+
             "biz_claim_voucher ,sys_employee,sys_department \n"+
             "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n"+
             "sys_department.`id`=sys_employee.`department_id` AND \n"+
             "biz_claim_voucher.`STATUS` like '%${bStatus}%' AND\n" +
             "biz_claim_voucher.`create_time`<#{endTime} AND\n" +
             "biz_claim_voucher.`create_time`>#{startTime}"+
             "ORDER BY\n"+
             "biz_claim_voucher.`id` DESC"
     })
     List<findAllExpenseDto> generalExpenseByTime(@Param("bStatus") String status, @Param("startTime") String startTime, @Param("endTime") String endTime);
    /**
     * 按编号查看报销单信息
     *
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
            "biz_claim_voucher.`id`=#{id}\n" +
            " ORDER BY\n" +
            "biz_claim_voucher.`id` DESC"})
    findAllExpenseDto findgenerExpenseById(@Param("id") Integer id);
    /**
     * 查看当前结果项
     * @return
     */
    @Select({"SELECT id,main_id mainId,item,account,des  FROM biz_claim_voucher_detail WHERE main_id=#{id}"})
    List<bizClaimVoucherDetail> findgenerBizClaimVoucherDetail(@Param("id") Integer id);

    /**
     * 按编号和领导意见查询领导意见
     * @param
     * @return
     */
    @Select({"SELECT id,claim_id,checker_sn chesn,\n"+
            "(SELECT `NAME` FROM sys_employee WHERE  sys_employee.`sn`=chesn ) eName,\n"+
            "(SELECT sys_position.`name_cn` FROM sys_position,sys_employee WHERE sys_position.`id`\n"+
            "=sys_employee.`posiyion_id` AND sys_employee.`sn`=chesn ) poName,\n"+
            "result,comm,biz_check_result.`check_time`,CreateTime FROM biz_check_result " +
            "WHERE claim_id=#{id}\n"+
            "AND checker_sn=#{chesn};"})
    resultDTO findgenerComm(@Param("id") Integer cId, @Param("chesn") String chesn);

    /**
     * 查看员工编号
     * @param name_cn
     * @return
     */
    @Select({"SELECT sn FROM sys_employee,sys_position WHERE \n" +
            "sys_position.`id`=sys_employee.`posiyion_id`\n" +
            "AND sys_position.`name_cn`=#{namecn};"})
    String findgenerEmployeeId(@Param("namecn") String name_cn);

    /**
     * 查看部门经理编号
     * @param name_cn
     * @return
     */
    @Select({"SELECT sn FROM sys_employee,sys_position,sys_department WHERE \n" +
            "sys_position.`id`=sys_employee.`posiyion_id`AND\n" +
            "sys_department.`id`=sys_employee.`department_id`\n" +
            "AND sys_position.`name_cn`=#{namecn} AND \n" +
            "sys_department.`NAME`=#{deName}"})
    String findgenerdepartmentId(@Param("namecn") String name_cn,@Param("deName") String deName);
    /**
     * 修改报销单待处理人
     * @param id
     * @param chesn
     * @return
     */
    @Update({"UPDATE biz_claim_voucher SET next_deal_sn=#{chesn},biz_claim_voucher.`STATUS`=#{status} WHERE id=#{id}"})
    int updateBizClaimVoucher(@Param("id") Integer id,@Param("chesn") String chesn,@Param("status") String status);


    /**
     * 添加审批结果
     * @param id
     * @param chesn
     * @param comm
     * @return
     */
    @Insert({"INSERT INTO biz_check_result (claim_id,checker_sn,result,comm) VALUES(#{id},#{chesn},#{result},#{comm})"})
    int addResult(@Param("id") Integer id,@Param("chesn") String chesn,@Param("result") String result,@Param("comm") String comm);

}
