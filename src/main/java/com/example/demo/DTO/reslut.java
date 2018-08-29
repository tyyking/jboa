package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 24431 on 2018/8/10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class reslut {
private Integer id;
private Integer claimId;
private String  checkerSn;
private String  result;
private String  comm;
private String  name;
private String  nameCn;
private String createTime;
}
