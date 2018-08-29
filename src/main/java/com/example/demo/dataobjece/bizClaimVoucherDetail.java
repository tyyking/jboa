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
public class bizClaimVoucherDetail {
    private  Integer id;
    private  Integer mainId; //报销单编号
    private  String item;   // 项
    private  Double account;  // 价格
    private  String des;     // 说明
}
