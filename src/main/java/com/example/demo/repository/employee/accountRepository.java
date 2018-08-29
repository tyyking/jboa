package com.example.demo.repository.employee;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.dataobjece.bizClaimVoucher;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zcp on 2018/7/12.
 */
@Mapper
public interface accountRepository {
    /**
     * 默认员工查询报销单
     * @param sn
     * @return
     */
    @Select({"SELECT  biz_claim_voucher.`id` bId,\n"+
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n"+
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)   \n"+
            "AS nexSn, \n"+
            "biz_claim_voucher.`create_time` bTime, \n"+
            "sys_employee.`NAME` eName, \n"+
            "biz_claim_voucher.`total_account` bAccount, \n"+
            "biz_claim_voucher.`STATUS` bStatus \n"+
            "FROM \n"+
            "biz_claim_voucher ,sys_employee,sys_department \n"+
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n"+
            "sys_department.`id`=sys_employee.`department_id`\n"+
            " AND biz_claim_voucher.`create_sn`=#{sn} AND\n"+
            " biz_claim_voucher.`STATUS` IN ('已打回','新创建','已拒绝','拒绝','已付款') ORDER BY  \n"+
            "biz_claim_voucher.`id` DESC "})
    List<findAllExpenseDto> empFindALL(@Param("sn") String sn);

    /**
     * 按报销单状态查询
     * @param sn
     * @param status
     * @return
     */
    @Select({"SELECT  biz_claim_voucher.`id` bId,\n"+
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n"+
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)   \n"+
            "AS nexSn, \n"+
            "biz_claim_voucher.`create_time` bTime, \n"+
            "sys_employee.`NAME` eName, \n"+
            "biz_claim_voucher.`total_account` bAccount, \n"+
            "biz_claim_voucher.`STATUS` bStatus \n"+
            "FROM \n"+
            "biz_claim_voucher ,sys_employee,sys_department \n"+
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n"+
            "sys_department.`id`=sys_employee.`department_id`\n"+
            " AND biz_claim_voucher.`create_sn`=#{sn} AND\n"+
            " biz_claim_voucher.`STATUS`=#{status} ORDER BY  \n"+
            "biz_claim_voucher.`id` DESC "})
    List<findAllExpenseDto> empFindALLByStatus(@Param("sn") String sn,@Param("status") String status);

    /**
     * 按时间家状态查询报销单
     * @param sn
     * @param status
     * @param createTime
     * @param endTime
     * @return
     */
    @Select({"         \n" +
            "            SELECT  biz_claim_voucher.`id` bId,\n" +
            "            (SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "            WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId) \n" +
            "            AS nexSn, \n" +
            "            biz_claim_voucher.`create_time` bTime, \n" +
            "            sys_employee.`NAME` eName, \n" +
            "            biz_claim_voucher.`total_account` bAccount, \n" +
            "            biz_claim_voucher.`STATUS` bStatus \n" +
            "            FROM \n" +
            "            biz_claim_voucher ,sys_employee,sys_department\n" +
            "            WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n" +
            "            sys_department.`id`=sys_employee.`department_id`\n" +
            "             AND biz_claim_voucher.`create_sn`=#{sn} AND\n" +
            "             biz_claim_voucher.`STATUS` LIKE '%${status}%'\n" +
            "            AND biz_claim_voucher.`create_time`>=#{createTime} AND biz_claim_voucher.`create_time`<=#{endTime}\n" +
            "             ORDER BY biz_claim_voucher.`id` DESC "})
    List<findAllExpenseDto> empFindALLBytime(@Param("sn") String sn,@Param("status") String status,@Param("createTime")String createTime,@Param("endTime")String endTime);

    /**
     * 删除报销单
     * @param id
     * @return
     */
    @Delete({"DELETE FROM biz_claim_voucher WHERE id=#{id}"})
    int delAccount(@Param("id") Integer id);

    /**
     *
     * @param id
     * @return
     */
    @Select({"SELECT id FROM biz_claim_voucher_detail WHERE biz_claim_voucher_detail.`main_id`=#{id}"})
    List<Integer> findResult(@Param("id") Integer id);
    /**
     * 删除报销单结果集
     * @param id
     * @return
     */
    @Delete({"DELETE FROM biz_claim_voucher_detail WHERE id=#{id}"})
    int delResult(@Param("id") Integer id);

    /**
     * 修改报销单状态
     * @param id
     * @param status
     * @return
     */
    @Update({"UPDATE biz_claim_voucher SET `status`=#{status},next_deal_sn=#{sn} WHERE id=#{id}"})
    int updAccount(@Param("id") Integer id,@Param("status") String status,@Param("sn") String sn);

    /**
     * 查询员工编号
     * @param pName
     * @param dName
     * @return
     */
    @Select({" SELECT sys_employee.`sn` FROM sys_employee,sys_position,sys_department \n" +
            "   WHERE sys_employee.`posiyion_id`=sys_position.`id` AND sys_employee.`department_id`= sys_department.`id`\n" +
            "   AND sys_position.`name_cn`=#{pName} AND sys_department.`NAME`=#{dName}"})
    String findSn(@Param("pName") String pName,@Param("dName") String dName);

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    @Select({"SELECT  biz_claim_voucher.`id` bId,\n" +
            "(SELECT `sys_employee`.`NAME` FROM `sys_employee`,biz_claim_voucher\n" +
            "WHERE biz_claim_voucher.next_deal_sn=sys_employee.sn AND `biz_claim_voucher`.`id`=bId)   \n" +
            "AS nexSn, \n" +
            "biz_claim_voucher.`create_time` bTime, \n" +
            "sys_employee.`NAME` eName, \n" +
            "biz_claim_voucher.`total_account` bAccount, \n" +
            "biz_claim_voucher.`STATUS` bStatus \n" +
            "FROM \n" +
            "biz_claim_voucher ,sys_employee,sys_department \n" +
            "WHERE biz_claim_voucher.`create_sn`=sys_employee.`sn` AND \n" +
            "sys_department.`id`=sys_employee.`department_id`\n" +
            "AND biz_claim_voucher.`id`=#{id}"})
    findAllExpenseDto showExpenseDto(@Param("id") Integer id);

    /**
     * 查看当前保险单的项
     * @param id
     * @return
     */
    @Select({"SELECT main_id as mainId,item,account,des FROM biz_claim_voucher_detail WHERE main_id=#{id}"})
    List<bizClaimVoucherDetail> findExpenseItem(@Param("id") Integer id);

    /**
     * 添加报销单
     * @param next_deal_sn
     * @param create_sn
     * @param EVENT
     * @param total_account
     * @param STATUS
     * @return
     */
    @Insert({"INSERT  INTO `biz_claim_voucher`(`next_deal_sn`,`create_sn`,`EVENT`,`total_account`,`STATUS`) VALUES \n" +
            "(#{nextSn},#{sn},#{EVENT},#{taccount},#{STATUS})"})
    int addExpense(@Param("nextSn") String next_deal_sn,@Param("sn") String create_sn,@Param("EVENT") String EVENT,
                   @Param("taccount") Double total_account,@Param("STATUS") String STATUS);

    /**
     * 查询当前用户最后添加的报销单Id
     * @param sn
     * @return
     */
    @Select({"SELECT id FROM biz_claim_voucher WHERE biz_claim_voucher.`create_sn`=#{sn} ORDER BY biz_claim_voucher.`create_time` DESC LIMIT 1"})
    Integer findExpenseById(@Param("sn") String sn);

    /**
     * 添加报销单项
     * @param main_id
     * @param item
     * @param account
     * @param des
     * @return
     */
    @Insert({"INSERT  INTO `biz_claim_voucher_detail`(`main_id`,`item`,`account`,`des`) VALUES " +
            "(#{id},#{item},#{account},#{des})"})
    int addItems(@Param("id") Integer main_id,@Param("item") String item,@Param("account") Double account,@Param("des") String des);

    /**
     * 删除项
     * @param id
     * @return
     */
    @Delete({"DELETE FROM biz_claim_voucher_detail WHERE id=#{id};"})
    int del(@Param("id") Integer id);

    /**
     * 修改事由
     * @param event
     * @param id
     * @return
     */
    @Update({"UPDATE biz_claim_voucher SET `event`=#{event} WHERE  id=#{id}"})
    int updatevent(@Param("event") String event,@Param("id") Integer id);


    @Update({"UPDATE `biz_claim_voucher` SET biz_claim_voucher.`total_account`=#{account} WHERE biz_claim_voucher.`id`=#{id}"})
    int updateVoucher(@Param("account") double account,@Param("id") Integer id);

    @Select({"SELECT `biz_claim_voucher`.`STATUS` FROM `biz_claim_voucher` WHERE `biz_claim_voucher`.`id`=#{id}"})
    String queryStatusById(@Param("id") Integer id);

    @Select({"SELECT next_deal_sn as nexSn,create_sn as eName,`EVENT` as EVENT,total_account as bAccount,`STATUS` as bStatus FROM `biz_claim_voucher` WHERE `biz_claim_voucher`.`id`=#{id}"})
    bizClaimVoucher queryVoucherById(@Param("id") Integer id);

    @Insert({"INSERT INTO biz_claim_voucher(next_deal_sn,create_sn,`EVENT`,total_account,`STATUS`) VALUES(#{nexSn},#{eName},#{EVENT},#{bAccount},#{bStatus})"})
    int add(bizClaimVoucher bizClaimVoucher);

    @Select({"        SELECT biz_check_result.id,biz_check_result.claim_id AS claimId,biz_check_result.checker_sn AS checkerSn,biz_check_result.result AS result,biz_check_result.comm comm,sys_employee.`name` AS `name`,sys_position.`name_cn`  AS nameCn,`biz_check_result`.`CreateTime` AS createTime  FROM   `sys_position` LEFT JOIN sys_employee ON sys_position.`id`= sys_employee.`posiyion_id` LEFT JOIN biz_check_result ON biz_check_result.`checker_sn`=sys_employee.`sn`\n" +
            "          WHERE biz_check_result.claim_id=#{id}"})
List<reslut> qeuryAllReslutById(Integer id);

    @Select({" SELECT biz_check_result.id,biz_check_result.claim_id AS claimId,biz_check_result.checker_sn AS checkerSn,biz_check_result.result AS result,biz_check_result.comm comm,sys_employee.`name` AS `name`,sys_position.`name_cn`  AS nameCn,`biz_check_result`.`CreateTime` AS createTime  FROM   `sys_position` LEFT JOIN sys_employee ON sys_position.`id`= sys_employee.`posiyion_id` LEFT JOIN biz_check_result ON biz_check_result.`checker_sn`=sys_employee.`sn`\n" +
            "       WHERE biz_check_result.claim_id=#{id} AND biz_check_result" +
            ".`checker_sn` NOT IN(SELECT `sys_employee`.`sn` FROM `biz_check_result`,`sys_employee` WHERE biz_check_result.`checker_sn`=sys_employee.`sn` AND sys_employee.`posiyion_id`=3)"})
    List<reslut> qeuryAllReslutByIdTwo(Integer id);

    @Select({"SELECT id,main_id as mainId,item,account,des FROM `biz_claim_voucher_detail` WHERE main_id=#{id}"})
    List<bizClaimVoucherDetail> queryAllBizClaimVoucherDetail(@Param("id")Integer id);
}