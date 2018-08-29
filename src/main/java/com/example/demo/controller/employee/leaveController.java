package com.example.demo.controller.employee;

import com.example.demo.DTO.leaveDTO;
import com.example.demo.DTO.leaveShowDTO;
import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.Result;
import com.example.demo.dataobjece.bizLeave;
import com.example.demo.service.department.departmentLeaveService;
import com.example.demo.service.employee.leaveService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcp on 2018/7/12.
 */
@Controller
@RequestMapping("eLeave")
public class leaveController {
    @Autowired
    private leaveService leaveService;

    /**
     * 添加请假单
     * @param starttime
     * @param endtime
     * @param leaveday
     * @param leavetype
     * @param reason
     * @return
     */
    @PostMapping("addLeaver/{starttime}/{endtime}/{leaveday}/{leavetype}/{reason}")
    @ResponseBody
    public Result addLeaver(@PathVariable("starttime") String starttime,@PathVariable("endtime") String endtime,@PathVariable("leaveday") Integer leaveday,
                            @PathVariable("leavetype") String leavetype,@PathVariable("reason") String reason, HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding = (lodingDTO)session.getAttribute("loding");
        String ename = loding.getEsn();
        String namecn="部门经理";
        String dename=loding.getDname();
        String nextSn = leaveService.finddepartmentId(namecn, dename);
        leaveService.addLeaver (ename,starttime,endtime,leaveday,leavetype,reason,"新创建",nextSn);
        return ResultUtil.success();
    }
    @GetMapping("empShowLeaver/{id}")
    @ResponseBody
    public Result empShowLeaver(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        leaveShowDTO leaveShowDTO = leaveService.empShowLeaver(id);
        return  ResultUtil.success(leaveShowDTO);
    }

    @PostMapping("empUpdLeaver/{starttime}/{endtime}/{leaveday}/{leavetype}/{reason}/{id}")
    @ResponseBody
    public Result empUpdLeaver(@PathVariable("starttime") String starttime,@PathVariable("endtime") String endtime,@PathVariable("leaveday")
            Integer leaveday,@PathVariable("leavetype") String leavetype,@PathVariable("reason") String reason,@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        leaveService.UpdateLeaver(starttime, endtime, leaveday, leavetype, reason, id);
        return  ResultUtil.success();
    }

    /**
     * 删除请假单
     * @param id
     * @return
     */
    @GetMapping("empdelLeaver/{id}")
    @ResponseBody
    public Result empdelLeaver(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        leaveService.DeleteLeaver(id);
        return  ResultUtil.success();
    }
    @Autowired
    private com.example.demo.service.department.departmentLeaveService departmentLeaveService=null;
    @GetMapping("findBySn")
    @ResponseBody
    public Result findBySn(HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = departmentLeaveService.deFindLevea(sn);
        return ResultUtil.success(leaveDTOS);
    }

    @GetMapping("deFindLeveaBytime/{createTime}/{endTime}")
    @ResponseBody
    public Result findBySnByTime(@PathVariable("createTime") String createTime,@PathVariable("endTime")String endTime,HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        lodingDTO loding =(lodingDTO) httpSession.getAttribute("loding");
        /*在session中获取当前用户编号*/
        String sn=loding.getEsn();
        List<leaveDTO> leaveDTOS = leaveService.deFindLeveaBytime(sn,createTime,endTime);
        return ResultUtil.success(leaveDTOS);
    }
    /**
     *
     * @param id
     * @param
     * @return
     */
    @PostMapping("updleaver/{id}")
    @ResponseBody
    public Result updleaver(@PathVariable("id") Integer id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        bizLeave bizLeave = leaveService.qeuryBizLeaveById(id);
        int updleaver = 0;
        updleaver = leaveService.updleaver(id, "待审批");
/*
        int updleaver = leaveService.updleaver(id, "待审批");
*/
        if(updleaver>0){
            return  ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }
}
