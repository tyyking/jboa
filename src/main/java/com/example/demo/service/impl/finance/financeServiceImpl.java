package com.example.demo.service.impl.finance;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.DTO.resultDTO;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import com.example.demo.repository.employee.accountRepository;
import com.example.demo.repository.finance.financeRepository;
import com.example.demo.service.finance.financeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
@Service
public class financeServiceImpl implements financeService {
    @Autowired
    private financeRepository financeRepository;
    @Autowired
    private accountRepository accountRepository;
    @Override
    public List<findAllExpenseDto> findExpense() {
        return financeRepository.findExpense();
    }

    @Override
    public List<findAllExpenseDto> findExpenseByTime(String status, String startTime, String endTime) {

        return financeRepository.findExpenseByTime(status,startTime,endTime);
    }

    @Override
    public List<findAllExpenseDto> findExpenseByStatus(String status) {
        return financeRepository.findExpenseByStatus(status);
    }

    @Override
    public Map<String, Object> findAccountById(Integer id) {
        /*报销单详情*/
        findAllExpenseDto expenseById = financeRepository.findExpenseById(id);
        /*查看员工编号*/
        Map<String, Object> map=new HashMap<>();
        /*报销的项*/
        List<reslut>  list=accountRepository.qeuryAllReslutById(id);
        List<bizClaimVoucherDetail> bizClaimVoucherDetail = accountRepository.queryAllBizClaimVoucherDetail(id);
        /*查看总经理领导 */
         /*查看部门领导 */
        map.put("reslut",list);
        map.put("expenseById",expenseById);
        map.put("bizClaimVoucherDetail",bizClaimVoucherDetail);
        return map;
    }

    /**
     * 财务报销单
     * @param id
     * @param chesn
     * @return
     */
    @Override
    public int updateBizClaim(Integer id, String chesn, String result, String comm,String status) {
       /*修改报销单*/
        int i = financeRepository.updateBizClaimVoucher(id, chesn,status);
        /*添加审批结果*/
        int i1 = financeRepository.addResult(id, chesn, result, comm);
        if(i<0&&i1<0){
            return -1;
        }
        return 0;
    }

}
