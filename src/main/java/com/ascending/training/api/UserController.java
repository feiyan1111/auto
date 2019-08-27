package com.ascending.training.api;

import com.ascending.training.domain.User;
import com.ascending.training.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@ResponseBody
@RequestMapping(value = {"/api/users","/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;
    //http://localhost:8080/api/users GET
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User signUpUser(@RequestBody User user) {
//        User user = new User();
        userRepository.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public User getUserById(@PathVariable("Id") Long Id){
        Optional<User> opt = userRepository.findById(Id);
        return opt.get();
    }

}
