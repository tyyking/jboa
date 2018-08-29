package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门经理查看除新建外的报销单
 * Created by 朱昌鹏 on 2018/6/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class findAllExpenseDto {
    private int bId;
    private String nexSn;
    private String bTime;
    private String eName;
    private float bAccount;
    private String bStatus;
    private String deName;
    private String poName;
}
