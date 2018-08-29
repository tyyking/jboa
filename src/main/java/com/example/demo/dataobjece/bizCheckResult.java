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
public class   bizCheckResult {
    private int id;
    private int claimid;
    private String checktime;
    private String checkersn;
    private String result;
    private String comm;
}
