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
public class sysDictionary {
    private  Integer id;//编号
    private  String name;//类型
    private  String item;//状态
    private  String value;//值
}
