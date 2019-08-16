package com.ascending.training.domain;


import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="cars_id_seq")
    @SequenceGenerator(name="cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private int year;
    @Column(name = "color")
    private String color;
    @Column(name = "miles")
    private int miles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car",cascade = CascadeType.ALL)
    private List<Image> images;

}
