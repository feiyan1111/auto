package com.ascending.training.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;

    public Long getId(){
        return this.id;
    }

}
