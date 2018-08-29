package com.example.demo.controller.employee;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.Result;
import com.example.demo.dataobjece.bizClaimVoucher;
import com.example.demo.dataobjece.bizClaimVoucherDetail;
import com.example.demo.publics.service.publicService;
import com.example.demo.repository.employee.accountRepository;
import com.example.demo.service.employee.accountService;
import com.example.demo.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/12.
 */
@Controller
@RequestMapping("empAccount")
public class accountController {
    @Autowired
    private accountService accountService;
    @Autowired
    private publicService publicService;
    /**
     * 默认查看报销单表
     * @return
     */
    @GetMapping("selectEmpAccount")
    @ResponseBody
    public Result selectEmpAccount(HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<findAllExpenseDto> findAllExpenseDto = accountService.empFindALL(sn);
        return ResultUtil.success(findAllExpenseDto);
    }

    /**
     * 按状态查看报销单
     * @param status
     * @return
     */
    @GetMapping("selectEmpAccountStatus/{status}")
    @ResponseBody
    public Result selectEmpAccountStatus(@PathVariable("status") String status,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<findAllExpenseDto> findAllExpenseDto = accountService.empFindALLByStatus(sn, status);
        return ResultUtil.success(findAllExpenseDto);
    }

    /**
     * 按时间查看报销单
     * @param status
     * @param createTime
     * @param endTime
     * @return
     */
    @GetMapping("selectEmpAccountTime/{status}/{createTime}/{endTime}")
    @ResponseBody
    public Result selectEmpAccountTime(@PathVariable("status") String status,@PathVariable("createTime") String createTime,@PathVariable("endTime")String endTime,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        if (status.equals("1")){
            status="";
        }
        List<findAllExpenseDto> findAllExpenseDto = accountService.empFindALLBytime(sn, status,createTime,endTime);
        return ResultUtil.success(findAllExpenseDto);
    }

    /**
     * 删除报销单
     * @param id
     * @return
     */
    @PostMapping("delAccount/{id}")
    @ResponseBody
    public Result delAccount(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int i = accountService.delAcount(id);
        if(i>0){
            return ResultUtil.success();
        }else {
            return  ResultUtil.error();
        }
    }
    /**
     * 提交报销单
     * @param id
     * @return
     */
    @PostMapping("updAccount/{id}")
    @ResponseBody
    public Result updAccount(@PathVariable("id") Integer id,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String dName=loding.getDname();
        int account = 0;
             account = accountService.updAccount(id, "已提交", "部门经理", dName);
        if(account>0){
            return  ResultUtil.success();
        }else {
            return  ResultUtil.error();
        }
    }

    /**
     * 查看报销单详情
     * @param id
     * @return
     */
    @GetMapping("findAllExpenseShow/{id}")
    @ResponseBody
    public Result findAllExpenseShow(@PathVariable("id") Integer id,HttpSession httpSessio,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        String loding = httpSessio.getAttribute("pname").toString();
        Map<String, Object> expenShow=null;
        if (loding.equals("员工")){
            expenShow=accountService.findExpenShow2(id);
        }else {
             expenShow = accountService.findExpenShow(id);

        }
       return ResultUtil.success(expenShow);
    }

    /**
     * 添加报销单
     * @param EVENT
     * @param total_account
     * @param STATUS
     * @return
     */
    @PostMapping("addExpent/{EVENT}/{taccount}/{STATUS}/{name}")
    @ResponseBody
    public Result addExpent(@PathVariable("EVENT") String EVENT, @PathVariable("taccount") Double total_account, @PathVariable("STATUS") String STATUS,@PathVariable("name") String name, HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding = (lodingDTO)session.getAttribute("loding");
        String ename = loding.getEsn();

        String empSn = publicService.findEmpSn(loding.getDname(), "员工",name);
        int i = accountService.addExpen(empSn,ename,EVENT, total_account, STATUS);
        if(i>0){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
    @PostMapping("updateVoucher/{account}/{id}")
    @ResponseBody
    public Result updateVoucher(@PathVariable("account") double account,@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Integer i=   accountService.updateVoucher(account,id);
        if(i>0){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
    /**
     * 添加报销单项
     * @param item
     * @param account
     * @param des
     * @param session
     * @return
     */
    @PostMapping("addExpentItem/{item}/{account}/{des}")
    @ResponseBody
    public Result addExpentItem(@PathVariable("item") String item,@PathVariable("account")Double account,
                                @PathVariable("des")String des,
                                HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding = (lodingDTO)session.getAttribute("loding");

        Integer expenseById = accountService.findExpenseById(loding.getEsn());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = accountService.addItems(expenseById, item, account, des);
        if(i>0){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    /**
     * 删除项
     * @param id
     * @return
     */
    @PostMapping("delItem/{id}")
    @ResponseBody
    public Result delItem(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int del = accountService.del(id);
        return ResultUtil.success();
    }
    /**
     * 修改报销单项
     * @param item
     * @param account
     * @param des
     * @param session
     * @return
     */
    @PostMapping("updExpentItem/{item}/{account}/{des}/{event}/{sid}")
    @ResponseBody
    public Result updExpentItem(@PathVariable("item") String item,@PathVariable("account")Double account,@PathVariable("des")String des,@PathVariable
            ("event") String event,@PathVariable("sid") Integer id, HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding = (lodingDTO)session.getAttribute("loding");
        Integer expenseById = accountService.findExpenseById(loding.getEsn());
        int i = accountService.addItems(expenseById, item, account, des);
        int updatevent = accountService.updatevent(event, id);
        if(i>0&&updatevent>0){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

}
