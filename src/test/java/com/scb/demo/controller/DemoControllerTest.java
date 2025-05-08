package com.scb.demo.controller;

import com.scb.demo.model.DemoUserEntity;
import com.scb.demo.service.DemoUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

    @Mock
    private DemoUserService demoUserService;

    @InjectMocks
    private DemoController demoController;

    @Test
    public void testDemoControllerFindById() throws Exception {

        DemoUserEntity demoUserEntity = new DemoUserEntity();
        when(demoUserService.findUserById(anyString())).thenReturn(Optional.of(demoUserEntity));
        Assertions.assertEquals(demoController.getUserdetailById("123").getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void testDemoControllerSave() throws Exception {

        DemoUserEntity demoUserEntity = new DemoUserEntity();
        when(demoUserService.save(any(DemoUserEntity.class))).thenReturn("123");
        Assertions.assertEquals(demoController.createUser(demoUserEntity).getStatusCode(), HttpStatus.CREATED);

    }
}
