package com.example.demo.service.department;

import com.example.demo.DTO.findAllExpenseDto;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/26.
 */
public interface departmentvoucherService {
    /*查看当前部门的报销单*/
    List<findAllExpenseDto> findExpenseBygeder(String sn);
    /*查看报销单详情*/
    //查看报销单详情
    Map<String,Object> findAccountById(Integer id);
    /*按状态查看报销单*/
    List<findAllExpenseDto> findExpenseBygederByStatus( String sn,String status);
    /*按状态+时间查询报销单*/
    List<findAllExpenseDto> findExpenseBygederByStime(String sn,String status,String startTime,String endTime);
    /*审批报销单*/
    int updateBizClaim(Integer id, String chesn, String result, String comm,String status);




}
