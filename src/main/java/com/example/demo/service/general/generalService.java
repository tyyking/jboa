package com.example.demo.service.general;

import com.example.demo.DTO.findAllExpenseDto;

import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
public interface generalService {
    /*查询财务待处理的信息*/
    List<findAllExpenseDto> generalExpense();
    /*按时间条件查询*/
    List<findAllExpenseDto> generalExpenseByTime(String status, String startTime, String endTime);
    /*按状态条件查询*/
    List<findAllExpenseDto> generalExpenseByStatus(String status);
    //查看报销单详情
    Map<String,Object> findgeneraAccountById(Integer id);
    /*总经理审批报销单*/
    int updateBizClaim(Integer id, String chesn, String result, String comm,String status);
}
