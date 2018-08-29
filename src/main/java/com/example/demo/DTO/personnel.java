package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 24431 on 2018/8/7.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class personnel {
    private String sn;
    private String name;
    private String status;
    private String nameCn;
    private String deName;
}
