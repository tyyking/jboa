package com.example.demo.controller.department;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.Result;
import com.example.demo.service.department.departmentvoucherService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/26.
 */
@Controller
@RequestMapping("departmentvoucher")
public class departmentvoucherController {
    @Autowired
    private departmentvoucherService departmentvoucherService;

    /**
     * 查看部门经理报销单
     * @return
     */
    @GetMapping("deparShowVoucher")
    @ResponseBody
    public Result deparShowVoucher(HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<findAllExpenseDto> expenseBygeder = departmentvoucherService.findExpenseBygeder(sn);
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(expenseBygeder,5);
        }else {
            return ResultUtil.success(expenseBygeder);
        }
    }

    /**
     * 安状态查询报销单
     * @param
     * @return
     */
    @GetMapping("deparShowVoucherByStatus/{bStatus}")
    @ResponseBody
    public Result deparShowVoucherByStatus(@PathVariable("bStatus") String bStatus,HttpSession httpSession,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<findAllExpenseDto> expenseByStatus = departmentvoucherService.findExpenseBygederByStatus(sn,bStatus);
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(expenseByStatus,5);
        }else {
            return ResultUtil.success(expenseByStatus);
        }
    }

    /**
     * 安状态和时间查询报销单
     * @param status
     * @param createTime
     * @param endTime
     * @return
     */
    @GetMapping("deparShowVoucherByTime/{status}/{createTime}/{endTime}")
    @ResponseBody
    public Result deparShowVoucherByTime(@PathVariable("status") String status,@PathVariable("createTime") String createTime,@PathVariable("endTime") String endTime,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        if (status.equals("1")){
            status="";
        }
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<findAllExpenseDto> expenseBygeder = departmentvoucherService.findExpenseBygederByStime(sn,status,createTime,endTime);
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(expenseBygeder,5);
        }else {
            return ResultUtil.success(expenseBygeder);
        }
    }

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    @GetMapping("deparShowbouche/{id}")
    @ResponseBody
    public Result deparShowbouche(@PathVariable("id") Integer id,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String, Object> accountById = departmentvoucherService.findAccountById(id);
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(accountById,5);
        }else {
            return ResultUtil.success(accountById);
        }
    }
    /*修改报销单*/
    @PostMapping("updatebizvo/{id}/{result}/{comm}/{status}")
    @ResponseBody
    public Result deparShowbouche(@PathVariable("id") Integer id,@PathVariable("result") String result,@PathVariable("comm") String comm,@PathVariable("status") String status,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        int accountById = departmentvoucherService.updateBizClaim(id, sn, result, comm, status);
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(accountById,5);
        }else {
            return ResultUtil.success(accountById);
        }
    }
}
