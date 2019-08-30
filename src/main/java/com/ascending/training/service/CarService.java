package com.ascending.training.service;

import com.ascending.training.domain.Car;
import com.ascending.training.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private CarService carService;

    @Transactional(readOnly = true)
    public Optional<Car> fingBy(Car c) {
        return carRepository.findByIdWithImages(c.getId());
    }

    @Transactional(readOnly = true)
    public List<Car> findAllWithImages() {
        return carRepository.findAllWithImages();
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        logger.info("total number of array is:" + carRepository.findAll().size());
        List<Car> cars = carRepository.findAll();
        cars.add(new Car());
        return cars;
    }

    public Optional<Car> findByBrand(String brand) {
        Optional<Car> car = carRepository.findByBrand(brand);
        return car;
    }

    public Optional<Car> findByModel(String brand, String model) {
        Optional<Car> car = carRepository.findByModel(brand, model);
        return car;
    }

    public Optional<Car> findByPrice(int price) {
        Optional<Car> car = carRepository.findByPrice(price);
        return car;
    }
}
