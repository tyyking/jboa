package com.example.demo.service.personnel;

import com.example.demo.DTO.personnel;
import com.example.demo.dataobjece.sysDepartment;
import com.example.demo.dataobjece.sysEmployee;
import com.example.demo.dataobjece.sysPosition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 24431 on 2018/8/7.
 */
public interface personnelService {
     List<personnel> qeruyAllPersonnel();

    Integer queryPersonnelBySn(personnel personnel);

    int addPersonnel(sysEmployee sysEmployee);

    List<sysPosition> qeuryAllSysPosition();
    List<sysDepartment> qeuryAllSysDepartment();
}
