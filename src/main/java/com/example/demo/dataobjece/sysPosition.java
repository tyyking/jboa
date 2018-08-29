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
public class sysPosition {
    private  Integer id;//职称编号
    private  String nameCn;//职称中文名称
    private  String nameEn;//职称英文名
}
