package com.example.demo.domaint.repositories;

import com.example.demo.domaint.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {



}
