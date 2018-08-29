package com.example.demo.controller.personnel;

import com.example.demo.DTO.personnel;
import com.example.demo.dataobjece.Result;
import com.example.demo.dataobjece.sysDepartment;
import com.example.demo.dataobjece.sysEmployee;
import com.example.demo.dataobjece.sysPosition;
import com.example.demo.service.personnel.personnelService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 24431 on 2018/8/7.
 */
@Controller
@RequestMapping("personnel")
public class personnelController {
    @Autowired
    private personnelService service;


    @GetMapping("qeruyAllPersonnel")
    @ResponseBody
    public Result qeruyAllPersonnel(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<personnel> personnels = service.qeruyAllPersonnel();
        return ResultUtil.success(personnels,5);
    }

    @GetMapping("queryPersonnelBySn")
    @ResponseBody
    public Result queryPersonnelBySn(@Valid personnel personnel,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return ResultUtil.success(service.queryPersonnelBySn(personnel),5);
    }
    @PostMapping("addPersonnel")
    @ResponseBody
    public Result addPersonnel(@Valid sysEmployee sysEmployee,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return ResultUtil.success(service.addPersonnel(sysEmployee),5);
    }
    @GetMapping("qeuryAllSysDepartmentAnd")
    @ResponseBody
    public Result qeuryAllSysDepartment(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String,Object> map=new HashMap<>();
        map.put("sysDepartment",service.qeuryAllSysDepartment());
        map.put("sysPosition",service.qeuryAllSysPosition());
        return ResultUtil.success(map,5);
    }

}
