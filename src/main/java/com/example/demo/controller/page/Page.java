package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zcp on 2018/7/22.
 */
@Controller
@RequestMapping("/page")
public class Page {
    /**
     * 财务查看报销单列表
     * @return
     */
    @GetMapping("pageshow")
    public ModelAndView pageshow(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        return new ModelAndView("finance/financeDepartmentList");
    }

    /**
     * 总经理查看报销单列表
     * @return
     */
    @GetMapping("generpageshow")
    public ModelAndView pageshowone(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        return new ModelAndView("generalManager/generalManagerDepartmentList");

    }
    /*财务跳转单审批页*/
    @GetMapping("selectApproves/{id}")
    public ModelAndView selectApprove(@PathVariable("id") Integer id, Map<String,Object> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return new ModelAndView("finance/financebursementFrom",map);
    }
    /*总经理跳转单审批页*/
    @GetMapping("selectgenerApproves/{id}")
    public ModelAndView selectgenerApproves(@PathVariable("id") Integer id, Map<String,Object> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return new ModelAndView("generalManager/generaManagerapprovebursementFrom",map);
    }
    /*部门经理查看请假单*/
    @GetMapping("seleDeLeavess")
    public ModelAndView seleDeLeaves(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("department/departmentleaveform/findDepartmentleaveList");
    }
    /*部门经理查看请假单详情*/
    @GetMapping("seleDeLeave/{id}")
    public ModelAndView seleDeLeave(@PathVariable("id") Integer id, Map<String,Object> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return  new ModelAndView("department/departmentleaveform/findDeparmentleaveShow",map);
    }
    /*部门经理查看报销单*/
    @GetMapping("seleDevouchers")
    public ModelAndView seleDevouchers(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("department/departmentbursementform/findDepartmentList");
    }
    @GetMapping("addPersonnel")
    public ModelAndView addPersonnel(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("Personnel/addPersonnel");
    }
    @GetMapping("checkTheStaff")
    public ModelAndView checkTheStaff(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("personnel/checkTheStaff");
    }
    /*部门经理查看请报销单详情*/
    @GetMapping("seleDevouch/{id}")
    public ModelAndView seleDevoucher(@PathVariable("id") Integer id, Map<String,Object> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return  new ModelAndView("department/departmentbursementform/approvebursementFrom",map);
    }
    /*添加请假单*/
    @GetMapping("addLeaver")
    public ModelAndView seleDevoucher(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("employee/Employeeleaveform/AddEmployeeleave");
    }
    /*员工查看请假单*/
    @GetMapping("selectLeavers")
    public ModelAndView selectLeaver(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("employee/Employeeleaveform/findEmployeeleaveList");
    }
    /*员工查看请假单详情*/
    @GetMapping("leaveShows/{id}")
    public ModelAndView leaveShow(@PathVariable("id") Integer id,Map<String,Integer> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return  new ModelAndView("employee/Employeeleaveform/findEmployeeleaveShow",map);
    }

    /**
     * 查看报销单列表
     * @return
     */
    @GetMapping("accountShowList")
    public ModelAndView accountShowList(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("employee/expensereimbursementform/findExpenseList");
    }
    /**
     * 查看报销单详情
     * @return
     */
    @GetMapping("accountShows/{id}")
    public ModelAndView accountShow(@PathVariable("id") Integer id,Map<String,Integer> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return  new ModelAndView("employee/expensereimbursementform/findExpenseShow",map);
    }
    /**
     * 修改报销单详情
     * @return
     */
    @GetMapping("updaccountShows/{id}")
    public ModelAndView updaccountShows(@PathVariable("id") Integer id,Map<String,Integer> map,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        map.put("id",id);
        return  new ModelAndView("employee/expensereimbursementform/findExpenseUpd",map);
    }
    @GetMapping("loding")
    public  ModelAndView showLoding(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("loding");
    }

    /**
     * 添加报销单
     * @return
     */
    @GetMapping("addExen")
    public  ModelAndView addExen(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return  new ModelAndView("employee/expensereimbursementform/addExpense");
    }
}
