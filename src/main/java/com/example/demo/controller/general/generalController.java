package com.example.demo.controller.general;

import com.example.demo.DTO.findAllExpenseDto;
import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.Result;
import com.example.demo.service.general.generalService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
@Controller
@RequestMapping("generalList")
public class generalController {
    @Autowired
    private generalService generalService;

    /**
     * 查看全部信息
     *
     * @return
     */
    @GetMapping("ShowList")
    @ResponseBody
    public Result financeShowList(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<findAllExpenseDto> expense = generalService.generalExpense();
        return ResultUtil.success(expense);
    }

    /**
     * 按状态查询
     */
    @GetMapping("ShowListByBstatus/{bStatus}")
    @ResponseBody
    public Result ShowListByBstatus(@PathVariable("bStatus") String bStatus,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<findAllExpenseDto> expenseByTerm = generalService.generalExpenseByStatus(bStatus);
        return ResultUtil.success(expenseByTerm);
    }

    /**
     * 按状态查询
     */
    @GetMapping("ShowListByBstatusbyTime/{bStatus}/{startTime}/{endTime}")
    @ResponseBody
    public Result ShowListByBstatusbyTime(@PathVariable("bStatus") String bStatus, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        if (bStatus.equals("1")){
            bStatus="";
        }
        List<findAllExpenseDto> expenseByTerm = generalService.generalExpenseByTime(bStatus, startTime, endTime);
        return ResultUtil.success(expenseByTerm);

    }

    /*查询当前报销单信息*/
    @GetMapping("findgenerExpenseById/{id}")
    @ResponseBody
    public Result findExpenseById(@PathVariable("id") Integer id,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String, Object> accountById = generalService.findgeneraAccountById(id);
        return ResultUtil.success(accountById);
    }

    /*查询当前报销单信息*/
    @PostMapping("updatebizvo/{id}/{result}/{comm}/{status}")
    @ResponseBody
    public Result updatebizvo(@PathVariable("id") Integer id, @PathVariable("result") String result, @PathVariable("comm") String comm,@PathVariable("status") String status, HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding = (lodingDTO)session.getAttribute("loding");
        String sn = loding.getEsn();
        if (generalService.updateBizClaim(id, sn, result, comm,status) == 1) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error();
        }
    }
}
