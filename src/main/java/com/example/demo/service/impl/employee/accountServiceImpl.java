package com.example.demo.service.impl.employee;
import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.dataobjece.bizClaimVoucher;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import com.example.demo.repository.employee.accountRepository;
import com.example.demo.service.employee.accountService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/12.
 */
@Service
public class accountServiceImpl implements accountService {
    @Autowired
    private accountRepository accountRepository;

    /**
     * 默认
     *
     * @param sn
     * @return
     */
    @Override
    public List<findAllExpenseDto> empFindALL(String sn) {
        PageHelper.startPage(2, 1);
        return accountRepository.empFindALL(sn);
    }

    /**
     * 状态
     *
     * @param sn
     * @param status
     * @return
     */

    @Override
    public List<findAllExpenseDto> empFindALLByStatus(String sn, String status) {
        return accountRepository.empFindALLByStatus(sn, status);
    }

    /**
     * 状态+时间
     *
     * @param sn
     * @param status
     * @param createTime
     * @param endTime
     * @return
     */
    @Override
    public List<findAllExpenseDto> empFindALLBytime(String sn, String status, String createTime, String endTime) {
        return accountRepository.empFindALLBytime(sn, status, createTime, endTime);
    }

    @Override
    public int updateVoucher(double account, Integer id) {
        return accountRepository.updateVoucher(account,id);
    }

    /**
     * 删除报销单
     *
     * @param id
     * @return
     */
    @Override
    public int delAcount(Integer id) {
            List<Integer> result = accountRepository.findResult(id);
            for (int i = 0; i < result.size(); i++) {
                int i1 = accountRepository.delResult(result.get(i));
            }
            if (accountRepository.findResult(id).size() == 0) {
                int i = accountRepository.delAccount(id);
                return i;
        }

        return 0;
    }

    /**
     * 提交报销单
     * @param id
     * @param status
     * @return
     */
    @Override
    public int updAccount(Integer id, String status,String pName,String dName) {
        String sn = accountRepository.findSn(pName, dName);
       return accountRepository.updAccount(id,status,sn);
    }

    @Override
    public List<bizClaimVoucherDetail> findExpenseItem(Integer id) {
        return accountRepository.findExpenseItem(id);
    }

    /***
     * 查看报销单详情
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> findExpenShow(Integer id) {
        findAllExpenseDto findAllExpenseDto = accountRepository.showExpenseDto(id);
        List<bizClaimVoucherDetail> expenseItem = accountRepository.queryAllBizClaimVoucherDetail(id);
        System.out.println(expenseItem.size());
        List<reslut>  list=accountRepository.qeuryAllReslutById(id);
        Map<String,Object> map=new HashMap<>();
        map.put("findAllExpenseDto",findAllExpenseDto);
        map.put("expenseItem",expenseItem);
        map.put("reslut",list);
        map.put("dName","平台研发部");
        map.put("pName","员工");
        return map;
    }
    @Override
    public Map<String, Object> findExpenShow2(Integer id) {
        findAllExpenseDto findAllExpenseDto = accountRepository.showExpenseDto(id);
        List<bizClaimVoucherDetail> expenseItem = accountRepository.queryAllBizClaimVoucherDetail(id);
        System.out.println(expenseItem.size());
        List<reslut>  list=accountRepository.qeuryAllReslutByIdTwo(id);
        Map<String,Object> map=new HashMap<>();
        map.put("findAllExpenseDto",findAllExpenseDto);
        map.put("expenseItem",expenseItem);
        map.put("reslut",list);
        map.put("dName","平台研发部");
        map.put("pName","员工");
        return map;
    }

    @Override
    public List<bizClaimVoucherDetail> queryAllBizClaimVoucherDetail(Integer id) {
        return accountRepository.queryAllBizClaimVoucherDetail(id);
    }

    /**
     * 添加报销单
     * @param next_deal_sn
     * @param create_sn
     * @param EVENT
     * @param total_account
     * @param STATUS
     * @return
     */
    @Override
    public int addExpen(String next_deal_sn, String create_sn, String EVENT, Double total_account, String STATUS) {
        return accountRepository.addExpense(next_deal_sn,create_sn,EVENT,total_account,STATUS);
    }

    @Override
    public Integer findExpenseById(String sn) {
        return accountRepository.findExpenseById(sn);
    }

    @Override
    public int addItems(Integer main_id, String item, Double account, String des) {
        return accountRepository.addItems(main_id,item,account,des);
    }

    @Override
    public String queryStatusById(Integer id) {
        return accountRepository.queryStatusById(id);
    }

    @Override
    public int add(bizClaimVoucher bizClaimVoucher) {
        return accountRepository.add(bizClaimVoucher);
    }

    @Override
    public List<reslut> qeuryAllReslutById(Integer id) {
        return accountRepository.qeuryAllReslutById(id);
    }

    @Override
    public bizClaimVoucher queryVoucherById(Integer id) {
        return accountRepository.queryVoucherById(id);
    }

    @Override
    public int del(Integer id) {
        return accountRepository.del(id);
    }

    @Override
    public int updatevent(String event, Integer id) {
        return accountRepository.updatevent(event,id);
    }
}

