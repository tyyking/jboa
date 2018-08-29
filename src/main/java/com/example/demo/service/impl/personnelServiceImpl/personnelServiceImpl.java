package com.example.demo.service.impl.personnelServiceImpl;

import com.example.demo.DTO.personnel;
import com.example.demo.dataobjece.sysDepartment;
import com.example.demo.dataobjece.sysEmployee;
import com.example.demo.dataobjece.sysPosition;
import com.example.demo.repository.personnel.personnelRepository;
import com.example.demo.service.personnel.personnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 24431 on 2018/8/7.
 */
@Service
public class personnelServiceImpl implements personnelService {
    @Autowired
    private personnelRepository personnelRepository;

    @Override
    public List<com.example.demo.DTO.personnel> qeruyAllPersonnel() {
        return personnelRepository.qeruyAllPersonnel();
    }

    @Override
    public Integer queryPersonnelBySn(personnel personnel) {
        return personnelRepository.queryPersonnelBySn(personnel);
    }

    @Override
    public int addPersonnel(sysEmployee sysEmployee) {
        return personnelRepository.addPersonnel(sysEmployee);
    }

    @Override
    public List<sysPosition> qeuryAllSysPosition() {
        return personnelRepository.qeuryAllSysPosition();
    }

    @Override
    public List<sysDepartment> qeuryAllSysDepartment() {
        return personnelRepository.qeuryAllSysDepartment();
    }
}
