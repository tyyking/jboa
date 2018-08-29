package com.example.demo.publics.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zcp on 2018/7/29.
 */
@Mapper
public interface publicRepository {
    /**
     * 查看员工编号
     * @param dName
     * @return
     */
    @Select({"SELECT sn FROM sys_employee,sys_department,sys_position WHERE sys_employee.`department_id`=sys_department.`id` \n" +
            "AND sys_employee.`posiyion_id`= sys_position.`id`AND sys_department.`NAME`=#{dName} AND sys_position.`name_cn`=#{PNanem} AND sys_employee.`NAME`=#{name}"})
    String findEmpSn(@Param("dName") String dName,@Param("PNanem") String PNanem,@Param("name") String name);
}
