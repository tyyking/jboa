package com.example.demo.service.employee;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.reslut;
import com.example.demo.dataobjece.bizClaimVoucher;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/12.
 */
@Service
public interface accountService {
    /**
     * 默认
     * @param sn
     * @return
     */
    List<findAllExpenseDto> empFindALL(String sn);

    /**
     *状态
     * @param sn
     * @param status
     * @return
     */
    List<findAllExpenseDto> empFindALLByStatus(String sn,String status);

    /**
     * 状态+时间
     * @param sn
     * @param status
     * @param createTime
     * @param endTime
     * @return
     */
    List<findAllExpenseDto> empFindALLBytime(String sn, String status,String createTime,String endTime);

    /**
     * 删除报销单
     * @param id
     * @return
     */
    int delAcount(Integer id);
    List<bizClaimVoucherDetail> findExpenseItem(@Param("id") Integer id);

    /**
     * 提交报销单
     * @param id
     * @param status
     * @return
     */
    int updAccount(Integer id,String status,String pName,String dName);

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    Map<String,Object> findExpenShow(Integer id);
    List<reslut> qeuryAllReslutById(Integer id);
    List<bizClaimVoucherDetail> queryAllBizClaimVoucherDetail(@Param("id")Integer id);
    public Map<String, Object> findExpenShow2(Integer id);
    /**
     * 添加报销单
     * @return
     */
    int addExpen(String next_deal_sn, String create_sn, String EVENT,Double total_account,String STATUS);
    int updateVoucher(@Param("account") double account, @Param("id") Integer id);

    /**
     * 查寻最后的编号
     * @param sn
     * @return
     */
    Integer findExpenseById(String sn);
    String queryStatusById(@Param("id") Integer id);
    bizClaimVoucher queryVoucherById(@Param("id") Integer id);
    int add(bizClaimVoucher bizClaimVoucher);

    /**
     * 添加报销单项
     * @param main_id
     * @param item
     * @param account
     * @param des
     * @return
     */
    int addItems(Integer main_id, String item, Double account,String des);

    /**
     * 删除项
     * @param id
     * @return
     */
    int del(Integer id);

    /**
     * 修改事由
     * @param event
     * @param id
     * @return
     */
    int updatevent(String event,Integer id);
}
