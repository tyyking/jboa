package com.example.demo.service.impl.general;


import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.DTO.resultDTO;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import com.example.demo.repository.employee.accountRepository;
import com.example.demo.repository.general.generalRepository;
import com.example.demo.service.general.generalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
@Service
public class generalServiceImpl implements generalService {
    @Autowired
    private generalRepository generalRepository;
    @Autowired
    private com.example.demo.repository.employee.accountRepository accountRepository;
    @Override
    public List<findAllExpenseDto> generalExpense() {
        return generalRepository.generalExpense();
    }

    @Override
    public List<findAllExpenseDto> generalExpenseByTime(String status, String startTime, String endTime) {
        return generalRepository.generalExpenseByTime(status, startTime, endTime);
    }

    @Override
    public List<findAllExpenseDto> generalExpenseByStatus(String status) {
        return generalRepository.generalExpenseByStatus(status );
    }

    @Override
    public Map<String, Object> findgeneraAccountById(Integer id) {
        /*报销单详情*/
        findAllExpenseDto expenseById = generalRepository.findgenerExpenseById(id);
        /*查看员工编号*/
        Map<String, Object> map=new HashMap<>();
        List<reslut>  list=accountRepository.qeuryAllReslutById(id);

        /*报销的项*/
        List<bizClaimVoucherDetail> bizClaimVoucherDetail = generalRepository.findgenerBizClaimVoucherDetail(id);
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
        int i = generalRepository.updateBizClaimVoucher(id, chesn,status);
        /*添加审批结果*/
        int i1 = generalRepository.addResult(id, chesn, result, comm);
        if(i>0&&i1>0){
            return 1;
        }
        return 0;
    }
}
