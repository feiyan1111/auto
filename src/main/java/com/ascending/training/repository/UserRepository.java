package com.ascending.training.repository;

import com.ascending.training.domain.Car;
import com.ascending.training.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query("Select u From User u LEFT JOIN FETCH u.cars")
    List<User> findAllWithCars();

    @Query("Select u FROM User u LEFT JOIN FETCH u.cars where u.id = ?1")
    Optional<User> findByIdWithCars(Long Id);
}
