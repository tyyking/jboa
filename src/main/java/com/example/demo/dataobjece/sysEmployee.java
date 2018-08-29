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
public class sysEmployee {
    private  String  sn ;//员工编号
    private  Integer positionId;//员工职称
    private    Integer departmentId;//员工所属部
    private    String name;//员工名字
    private    String passWord;//密码
    private      String  status;//员工状态
}
