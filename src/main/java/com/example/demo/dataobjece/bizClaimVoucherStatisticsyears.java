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
public class bizClaimVoucherStatisticsyears {
    private  Integer id;
    private  Float totalCount;  //总金额
    private  Integer year;       //年份
    private  String modifyTime;  //修改时间
    private  Integer departmentId;  //部门编号
}
