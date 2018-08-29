package com.example.demo.service.impl.department;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.DTO.resultDTO;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import com.example.demo.repository.department.departmentvoucherRepository;
import com.example.demo.repository.employee.accountRepository;
import com.example.demo.repository.finance.financeRepository;
import com.example.demo.service.department.departmentvoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/26.
 */
@Service
public class DepartmentvoucherServiceImpl implements departmentvoucherService {
    @Autowired
    private departmentvoucherRepository departmentvoucherRepository;
    @Autowired
    private com.example.demo.repository.employee.accountRepository accountRepository;
    @Autowired
    private com.example.demo.repository.finance.financeRepository financeRepository ;
    /*查看当前部门的报销单*/
   public List<findAllExpenseDto> findExpenseBygeder(String sn){
        return departmentvoucherRepository.findExpenseBygeder(sn);
    }
    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> findAccountById(Integer id) {
        /*报销单详情*/
        findAllExpenseDto expenseById = financeRepository.findExpenseById(id);
        Map<String, Object> map=new HashMap<>();
        /*报销的项*/
        List<bizClaimVoucherDetail> bizClaimVoucherDetail = accountRepository.queryAllBizClaimVoucherDetail(id);
        List<reslut>  list=accountRepository.qeuryAllReslutById(id);
        map.put("reslut",list);
        map.put("expenseById",expenseById);
        map.put("bizClaimVoucherDetail",bizClaimVoucherDetail);
        return map;
    }
    @Override
    public List<findAllExpenseDto> findExpenseBygederByStatus(String sn, String status) {
        return departmentvoucherRepository.findExpenseBygederByStatus(sn,status);
    }

    @Override
    public List<findAllExpenseDto> findExpenseBygederByStime(String sn, String status, String startTime, String endTime) {
        return departmentvoucherRepository.findExpenseBygederByStime(sn,status,startTime,endTime);
    }

    /**
     * 修改报销单
     * @param id
     * @param chesn
     * @param result
     * @param comm
     * @param status
     * @return
     */
    @Override
    public int updateBizClaim(Integer id, String chesn, String result, String comm, String status) {
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
