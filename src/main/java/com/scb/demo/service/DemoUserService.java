package com.scb.demo.service;

import com.scb.demo.model.DemoUserEntity;
import com.scb.demo.repository.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoUserService {

    @Autowired
    private DemoUserRepository demoUserRepository;

    public String save(DemoUserEntity demoUserEntity){
        return demoUserRepository.save(demoUserEntity).getId();
    }

    public Optional<DemoUserEntity> findUserById(String id){
        return demoUserRepository.findById(Long.valueOf(id));
    }

}
