package com.ascending.training.repository;

import com.ascending.training.repository.UserRepository;
import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.Car;
import com.ascending.training.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void deleteByIdTest() {
        User expecteduser = new User();
        expecteduser.setFirst_name("fei");
        expecteduser.setLast_name("yan");
        userRepository.save(expecteduser);
        userRepository.deleteById(expecteduser.getId());
        Optional<User> testUser = userRepository.findById(expecteduser.getId());
        assertNull(testUser);
    }
}
