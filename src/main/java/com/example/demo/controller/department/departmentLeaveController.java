package com.example.demo.controller.department;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.Result;
import com.example.demo.service.department.departmentLeaveService;
import com.example.demo.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcp on 2018/7/25.
 */
@Controller
@RequestMapping("departmentLeave")
public class departmentLeaveController {
    @Autowired
    private departmentLeaveService departmentLeaveService;
    @GetMapping("findBySn")
    @ResponseBody
    public Result findBySn(HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
/*
        在session中获取当前用户编号
*/
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = departmentLeaveService.deFindLeveaTwo(sn);
    /*    PageHelper.startPage(2,1);
        PageInfo<leaveDTO> pageInfo = new PageInfo<leaveDTO>(leaveDTOS);*/
        if (httpSession.getAttribute("dname").equals("人事部")){
            return ResultUtil.success(leaveDTOS,5);
        }else {
            return ResultUtil.success(leaveDTOS);
        }
    }
    @GetMapping("findBySnByTime/{createTime}/{endTime}")
    @ResponseBody
    public Result findBySnByTime(@PathVariable("createTime")String createTime,@PathVariable("endTime")String endTime,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = departmentLeaveService.deFindLeveaBytime(sn,createTime,endTime);
        return ResultUtil.success(leaveDTOS);
    }
    @GetMapping("findBySnByEvent/{EVENT}")
    @ResponseBody
    public Result findBySnByEvent(@PathVariable("EVENT")String EVENT,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = departmentLeaveService.deFindLeveaByStatus(sn,EVENT);
        return ResultUtil.success(leaveDTOS);
    }
    @GetMapping("findBySnByEventAndTime/{EVENT}/{createTime}/{endTime}")
    @ResponseBody
    public Result findBySnByEventAndTime(@PathVariable("createTime")String createTime,@PathVariable("endTime")String endTime,@PathVariable("EVENT")String EVENT,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        if (EVENT.equals("1")){
            EVENT="";
        }
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = departmentLeaveService.deFindLeveaByStatusAndtime(sn,EVENT,createTime,endTime);
        return ResultUtil.success(leaveDTOS);
    }


    /**
     * 查看请假单详情
     * @PathVariable id
     * @return
     */
    @GetMapping("deFindLeveaShow/{id}")
    @ResponseBody
    public Result deFindLeveaShow(@PathVariable("id") Integer id,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        leaveShowDTO leaveShow = departmentLeaveService.deFindLeveaShow(id);
        return ResultUtil.success(leaveShow);
    }

    /**
     * 修改请假单
     * @param id
     * @param status
     * @param approveOpinion
     * @return
     */
    @PostMapping("updateLevea/{id}/{status}/{approveOpinion}")
    @ResponseBody
    public Result updateLevea(@PathVariable("id") Integer id,@PathVariable("status") String status,@PathVariable("approveOpinion") String approveOpinion,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        int accotion = departmentLeaveService.accotion(id, status, approveOpinion);
        return ResultUtil.success();
    }
}
