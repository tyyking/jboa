package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zcp on 2018/7/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class leaveShowDTO {
    private String esn;
    private String eName;
    private String deName;
    private String starttime;
    private String endtime;
    private Integer leaveday;
    private String leavetype;
    private String reason;
    private String status;
    private String apperveOpinion;

}
