package com.ascending.training.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="images_id_seq")
    @SequenceGenerator(name="images_id_seq", sequenceName = "images_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

}
