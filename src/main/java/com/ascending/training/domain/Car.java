package com.ascending.training.domain;


import javax.persistence.*;

import java.util.List;
import java.util.Optional;

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
    @Column(name = "price")
    private int price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car",cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getYear(){
        return brand;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getMiles(){
        return miles;
    }
    public void setMiles(int miles){
        this.miles = miles;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
