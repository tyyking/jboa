package com.example.demo.service.finance;

import com.example.demo.DTO.findAllExpenseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
public interface financeService {
    /*查询财务待处理的信息*/
    List<findAllExpenseDto> findExpense();
    /*按时间条件查询*/
    List<findAllExpenseDto> findExpenseByTime(String status,String startTime, String endTime);
    /*按状态条件查询*/
    List<findAllExpenseDto> findExpenseByStatus(String status);
    //查看报销单详情
    Map<String,Object> findAccountById(Integer id);
    /*财务审批报销单*/
    int updateBizClaim(Integer id, String chesn, String result, String comm,String status);
}
