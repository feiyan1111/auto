package com.ascending.training.api;

import com.ascending.training.domain.Car;
import com.ascending.training.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/cars","/api/car"},produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getCarList() {
        logger.debug("list cars");
        return carRepository.findAll();
    }
}
