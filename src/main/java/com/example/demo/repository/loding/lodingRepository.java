package com.example.demo.repository.loding;

import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.sysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zcp on 2018/7/28.
 */
@Mapper
public interface lodingRepository {
    /**
     * 登录
     * @param sn
     * @param password
     * @param ename
     * @return
     */
    @Select({"SELECT sys_employee.`sn` esn,\n" +
            "sys_employee.`NAME` ename,\n" +
            "sys_employee.`STATUS` estatus,\n" +
            "sys_position.`name_cn` pname,\n" +
            "sys_department.`NAME` dname FROM \n" +
            "sys_employee,sys_position,sys_department \n" +
            "WHERE sys_employee.`posiyion_id`=sys_position.`id` \n" +
            "AND sys_employee.`department_id`\n" +
            "=sys_department.`id` AND sn=#{sn} AND \n" +
            "sys_employee.`PASSWORD`=#{password} and \n" +
            "sys_department.`NAME`=#{ename}AND\n" +
            "sys_employee.`STATUS`='在职'"})
    lodingDTO loding(@Param("sn") String sn,@Param("password") String password,@Param("ename") String ename);

    /***
     * 查看部门
     * @return
     */
    @Select({"SELECT * FROM sys_department"})
    List<sysDepartment> findDepartment();

    /**
     * 查看员工编号
     * @param dName
     * @return
     */
    @Select({"SELECT sn FROM sys_employee,sys_department,sys_position WHERE sys_employee.`department_id`=sys_department.`id` \n" +
            "AND sys_employee.`posiyion_id`= sys_position.`id`AND sys_department.`NAME`=#{dName} AND sys_position.`name_cn`='部门经理'"})
    String findEmpSn(@Param("dName") String dName);
}
