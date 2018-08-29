package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zcp on 2018/7/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class lodingDTO implements Serializable {
    private static final long serialVersionUID = -8366929034564774130L;
    private String esn;
    private String ename;
    private String estatus;
    private String pname;
    private String dname;
}
