package com.ascending.training.service;

import com.ascending.training.domain.User;
import com.ascending.training.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private UserService userService;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        logger.info("total number of array is:" + userRepository.findAll().size());
        List<User> users = userRepository.findAll();
        users.add(new User());
        return users;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }

//    public Optional<User> findByEmailOrUsername(String email, String username) {
//        Optional<User> user = userRepository.findByEmailOrUsername(email,username);
//        return user;
//
//    }

}
