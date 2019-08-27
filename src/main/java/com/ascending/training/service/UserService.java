package com.ascending.training.service;

import com.ascending.training.domain.User;
import com.ascending.training.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        logger.info("total number of array is:" + userRepository.findAll().size());
        return userRepository.findAll();
    }
}
