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

    @Query("Select c FROM Car c where c.brand = ?1")
    Optional<Car> findByBrand(String brand);

    @Query("Select c FROM Car c where c.brand = ?1 and c.model = ?2")
    Optional<Car> findByModel(String brand, String model);

    @Query("Select c FROM Car c where c.price = ?1")
    Optional<Car> findByPrice(int price);
}