package com.ascending.training.repository;

import com.ascending.training.domain.Image;
import com.ascending.training.repository.UserRepository;
import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.Car;
import com.ascending.training.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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
    @Autowired
    private CarRepository carRepository;
    public User expecteduser;
    public Car expectedcar;
    @PersistenceContext
    public EntityManager em;

    @Before
    public void setup(){
        expecteduser = new User();
        expecteduser.setUsername("feiyan");
        expecteduser.setFirst_name("fei");
        expecteduser.setLast_name("yan");
        expecteduser.setEmail("test@gmail.com");
        expecteduser.setWechat("wxtest123");
        expectedcar = new Car();
        expectedcar.setBrand("toyota");
        expectedcar.setModel("camry");
        expectedcar.setColor("red");
        expectedcar.setMiles(20000);
        expectedcar.setYear(2015);
    }

    @After
    public void tearDown(){

    }

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

    @Test
    @Transactional
    public void findAllWithCarsTest() {
        userRepository.save(expecteduser);
        expectedcar.setUser(expecteduser);
        carRepository.save(expectedcar);
        List<User> users = userRepository.findAllWithCars();
        em.flush();
        em.refresh(expectedcar);
        assertEquals(1,users.size());
        User  user = users.get(0);
        assertEquals(1,user.getCars().size());

    }

    @Test
    @Transactional
    public void findByIdWithCarsTest() {
        userRepository.save(expecteduser);
        expectedcar.setUser(expecteduser);
        carRepository.save(expectedcar);
        Optional<User> testUser = userRepository.findByIdWithCars(expecteduser.getId());
        em.flush();
        em.refresh(expecteduser);
        assertNotNull(testUser);
        assertEquals(expecteduser.getId(),testUser.get().getId());

    }

}
