package com.example.demo.publics.service.impl;

import com.example.demo.publics.repository.publicRepository;
import com.example.demo.publics.service.publicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zcp on 2018/7/29.
 */
@Service
public class PublicServiceImpl implements publicService {
    @Autowired
    private publicRepository  publicRepository;

    /**
     * 查看员工编号
     * @param dName
     * @return
     */
    @Override
    public String findEmpSn(String dName,String PNanem,String name) {
        return publicRepository.findEmpSn(dName,PNanem,name);
    }
}
