package com.example.demo.controller.loding;

import com.example.demo.DTO.lodingDTO;
import com.example.demo.controller.page.Page;
import com.example.demo.dataobjece.Result;
import com.example.demo.service.loding.lodingService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcp on 2018/7/28.
 */
@Controller
@RequestMapping("lodings")
public class lodingController {
    @Autowired
    private lodingService lodingService;
    @GetMapping("loding/{sn}/{password}/{ename}")
    @ResponseBody
    public Result loding(@PathVariable("sn") String sn,@PathVariable("password") String password,@PathVariable("ename") String ename, HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> map =new HashMap<>();
        lodingDTO loding = lodingService.loding(sn, password, ename);
        if(loding!=null){
            map.put("Pname",loding.getPname());
            httpSession.setAttribute("pname",loding.getPname());
            httpSession.setAttribute("loding",loding);
            httpSession.setAttribute("ename",loding.getEname());
            httpSession.setAttribute("dname",loding.getDname());
            map.put("bool",true);
        }else {
            map.put("bool",false);
        }

        return ResultUtil.success(map);
    }
    @GetMapping("lodingOut")
    public ModelAndView lodingOut(HttpSession httpSession,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        httpSession.invalidate();
        return new ModelAndView("loding");
    }
    @GetMapping("showDepanrtment")
    @ResponseBody
public Result showDepanrtMent(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return ResultUtil.success(lodingService.findDepartment());
}
}
