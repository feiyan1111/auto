package com.ascending.training.service;

import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.User;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest{
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findByEmailTest() throws CreateModelException, NotFoundException {
        User exceptedResult = new User();
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setPassword("password");
        expectedResult.setConfirmPassword("password");
        userService.save(expectedResult);
        assertEquals(expectedResult.getId(),actualResult.getId());
    }
}
