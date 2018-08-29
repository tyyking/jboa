package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**查询请假单
 * Created by zcp on 2018/7/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class leaveDTO {
    private Integer id;
    private  String CreateTime;
    private  String modifytime;
    private  String approveOpinion;
    private String  status;
    private String emsn;
    private String eName;
    private Integer leaveday;
}
