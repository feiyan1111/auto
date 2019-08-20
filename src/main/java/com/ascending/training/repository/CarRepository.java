package com.ascending.training.repository;

import com.ascending.training.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();

    @Query("Select c From Car c LEFT JOIN FETCH c.images")
    List<Car> findAllWithImages();

    @Query("Select c FROM Car c LEFT JOIN FETCH c.images where c.id = ?1")
    Optional<Car> findByIdWithImages(Long Id);

}