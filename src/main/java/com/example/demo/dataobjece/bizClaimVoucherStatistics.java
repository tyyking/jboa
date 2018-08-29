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
public class bizClaimVoucherStatistics {
    private  Integer id;
    private  Float totalTime;  //总金额
    private  Integer year;      //年份
    private Integer month;//份
    private  String modifyTime;  //修改时间
    private  Integer departmentId; //部门编号
}
