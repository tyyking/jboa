package com.example.demo.repository.personnel;

import com.example.demo.DTO.personnel;
import com.example.demo.dataobjece.sysDepartment;
import com.example.demo.dataobjece.sysEmployee;
import com.example.demo.dataobjece.sysPosition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 24431 on 2018/8/7.
 */
@Mapper
public interface personnelRepository {
    @Select({"            \n" +
            "          SELECT `sys_employee`.`sn`,sys_employee.`NAME` AS `name`,sys_employee.`STATUS` `status`,`sys_position`.`name_cn` AS nameCn,`sys_department`.`NAME` AS deName FROM `sys_department`,`sys_employee`,`sys_position`\n" +
            "          WHERE `sys_employee`.`posiyion_id`=`sys_position`.`id`" +
            " AND `sys_employee`.`department_id`=`sys_department`.`id` ORDER " +
            "BY  sys_employee.`createTime` desc"})
List<personnel> qeruyAllPersonnel();

    @Select({"            \n" +
            "          SELECT count(`sys_employee`.`sn`) FROM `sys_employee`\n" +
            "          WHERE   `sys_employee`.`sn`=#{sn} "})
    Integer queryPersonnelBySn(personnel personnel);

    @Insert({"INSERT INTO `sys_employee`(sn,posiyion_id,department_id,`NAME`,`PASSWORD`,`STATUS`)      VALUES(#{sn},#{positionId},#{departmentId},#{name},#{passWord},'在职');\n"})
    int addPersonnel(sysEmployee sysEmployee);

    @Select({"select id,name_cn as nameCn from sys_position"})
    List<sysPosition> qeuryAllSysPosition();
    @Select({"select * from sys_department"})
    List<sysDepartment> qeuryAllSysDepartment();
}
