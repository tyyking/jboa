package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zcp on 2018/7/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class resultDTO {
    private Integer id;
    private Integer cId;
    private String chesn;
    private String ename;
    private String poName;
    private String result;
    private String comm;
    private String checkTime;
    private String CreateTime;
}
