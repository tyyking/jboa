package com.example.demo.dataobjece;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 朱昌鹏 on 2018/6/3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class bizClaimVoucher {
    private Integer bId;
    private  String  nexSn; //分配者编号
    private  String  eName;   //报销者编号
    private  String bTime;   //创建时间
    private  String  EVENT;       //作用
    private  Float bAccount;  //总金额
    private  String  bStatus;       //报销单状态
    private  String  eTime;    //修改时间
}
