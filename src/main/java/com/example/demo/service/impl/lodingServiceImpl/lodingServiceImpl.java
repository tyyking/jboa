package com.example.demo.service.impl.lodingServiceImpl;

import com.example.demo.DTO.lodingDTO;
import com.example.demo.dataobjece.sysDepartment;
import com.example.demo.repository.loding.lodingRepository;
import com.example.demo.service.loding.lodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcp on 2018/7/28.
 */
@Service
public class lodingServiceImpl implements lodingService {
    @Autowired
    private lodingRepository lodingRepository;
    @Override
    public lodingDTO loding(String sn, String password, String ename) {
        return lodingRepository.loding(sn,password,ename);
    }

    @Override
    public List<sysDepartment> findDepartment() {
        return lodingRepository.findDepartment();
    }
}
