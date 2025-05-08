package com.scb.demo.service;

import com.scb.demo.model.DemoUserCreatedResponse;
import com.scb.demo.model.DemoUserEntity;
import com.scb.demo.repository.DemoUserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DemoUserServiceTest {

    @Mock
    private DemoUserRepository demoUserRepository;

    @InjectMocks
    private DemoUserService demoUserService;

    @Test
    public void testDemoUserServiceSave() throws Exception {
        DemoUserEntity demoUserEntity = new DemoUserEntity();
        demoUserEntity.setId("123");
        when(demoUserRepository.save(any(DemoUserEntity.class))).thenReturn(demoUserEntity);

        demoUserService.save(demoUserEntity);
        Assertions.assertEquals(demoUserRepository.save(demoUserEntity).getId(), "123");
    }

    @Test
    public void testDemoUserServiceTestFindById() throws Exception {
        DemoUserEntity demoUserEntity = new DemoUserEntity();
        demoUserEntity.setId("123");
        when(demoUserRepository.findById(anyLong())).thenReturn(Optional.of(demoUserEntity));

        Assertions.assertEquals(demoUserRepository.findById(Long.valueOf("123")).get().getId(), demoUserEntity.getId());
    }
}
