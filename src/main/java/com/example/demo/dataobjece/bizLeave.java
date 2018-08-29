package com.example.demo.dataobjece;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 朱昌鹏 on 2018/6/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class bizLeave {
    private  Integer id;
    private String employee_Sn;  //员工编号
    private  String starttime;   //开始日期
    private  String endtime;    //结束日期
    private  Integer  leaveday;  //请假天数
    private String reason;       //请假原因
    private  String  status;      // 请假状态
    private  String  leavetype;   //请假类型
    private  String nextDealSn;    //上级领导编号
    private  String  approve_Opinion;  //领导意见
    private  String createtime;     //创建时间
    private  String modifytime;       //修改时间
    private String employeename;//员工姓名
    private String sysPositionNameCn;//员工职位
    private String sysDepartmentName;//部门名
    private String naxtName;//领导姓名
}
