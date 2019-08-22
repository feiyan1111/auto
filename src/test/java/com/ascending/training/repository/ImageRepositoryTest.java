package com.ascending.training.repository;

import com.ascending.training.repository.ImageRepository;
import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.Image;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class ImageRepositoryTest {
    @Autowired
    private ImageRepository imageRepository;
    public Image expectedimage;
    @Before
    public void setup(){
        expectedimage = new Image();
        expectedimage.setTitle("toyota");
        expectedimage.setUrl("url123");
    }

    @After
    public void tearDown(){

    }

    @Test
    @Transactional
    public void existByIdTest() {
        imageRepository.save(expectedimage);
        boolean existed = imageRepository.existsById(expectedimage.getId());
        assertTrue(existed);
    }

    @Test
    @Transactional
    public void countTest() {
        imageRepository.save(expectedimage);
        long testCar = imageRepository.count();
        assertEquals(1,testCar);
    }

}
