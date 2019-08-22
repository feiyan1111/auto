package com.ascending.training.repository;

import com.ascending.training.domain.Image;
import com.ascending.training.domain.User;
import com.ascending.training.repository.CarRepository;
import com.ascending.training.repository.ImageRepository;
import com.ascending.training.config.AppConfig;
import com.ascending.training.domain.Car;
import com.google.common.collect.Iterables;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ImageRepository imageRepository;
    public Car expectedcar;
    public Image expectedimage;
    @PersistenceContext
    public EntityManager em;

    @Before
    public void setup(){
        expectedcar = new Car();
        expectedcar.setBrand("toyota");
        expectedcar.setModel("camry");
        expectedcar.setColor("red");
        expectedcar.setMiles(20000);
        expectedcar.setYear(2015);
        expectedimage = new Image();
        expectedimage.setTitle("toyota");
        expectedimage.setUrl("url123");
    }

    @After
    public void tearDown(){

    }

    @Test
    @Transactional
    public void findByIdTest() {
        carRepository.save(expectedcar);
        Optional<Car> testCar = carRepository.findById(expectedcar.getId());
        assertNotNull(testCar);
        assertEquals(expectedcar.getId(),testCar.get().getId());
    }

    @Test
    @Transactional
    public void findAllTest() {
        carRepository.save(expectedcar);
        Iterable<Car> allCar = carRepository.findAll();
        assertEquals(1,Iterables.size(allCar));

    }

    @Test
    @Transactional
    public void deleteByIdTest() {
        carRepository.save(expectedcar);
        Iterable<Car> allCar = carRepository.findAll();
        assertEquals(1,Iterables.size(allCar));
        carRepository.deleteById(expectedcar.getId());
        Optional<Car> testCar = carRepository.findById(expectedcar.getId());
        Iterable<Car> allCar2 = carRepository.findAll();
        assertFalse(testCar.isPresent());
        assertEquals(0,Iterables.size(allCar2));
    }

    @Test
    @Transactional
    public void findAllWithImagesTest() {
        carRepository.save(expectedcar);
        expectedimage.setCar(expectedcar);
        imageRepository.save(expectedimage);
        List<Car> cars = carRepository.findAllWithImages();
        em.flush();
        em.refresh(expectedcar);
        assertEquals(1,cars.size());
        Car  car = cars.get(0);
        assertEquals(1,car.getImages().size());
//        Iterable<Image> allImage = imageRepository.findAll();
//        assertEquals(1,Iterables.size(allImage));

//        carRepository.save(expectedcar);                    //create car instance, set image to this car, save this image, save this car
//        imageRepository.save(expectedimage);
//        Iterable<Car> allCar = carRepository.findAll();
//        Iterable<Image> allImage = imageRepository.findAll();
//        assertEquals(2,Iterables.size());
//        Iterable<Car, Image> allCarWithImage = carRepository.findAllWithImages(Car, Image);
//        assertEquals(2,Iterables.size(allCarWithImage));

    }


}
