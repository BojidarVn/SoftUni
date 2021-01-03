package com.example.gameShop.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {


    private Long id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true,updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
