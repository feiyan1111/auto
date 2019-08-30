package com.ascending.training.service;

import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.Car;
import com.ascending.training.domain.User;
import javassist.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest{
    @Autowired
    private UserService userService;
    public User expecteduser;

    @Before
    public void setup() {
        expecteduser = new User();
        expecteduser.setUsername("feiyan");
        expecteduser.setFirst_name("fei");
        expecteduser.setLast_name("yan");
        expecteduser.setEmail("test@gmail.com");
        expecteduser.setWechat("wxtest123");
    }

    @After
    public void tearDown(){

    }

    @Test
    @Transactional
    public void findByEmailTest() {
        userService.save(expecteduser);
        Optional<User> testUser = userService.findByEmail(expecteduser.getEmail());
        assertNotNull(testUser);
        String email = expecteduser.getEmail();
        String expectedEmail = testUser.get().getEmail();
        assertEquals(email,expectedEmail);
    }
}
