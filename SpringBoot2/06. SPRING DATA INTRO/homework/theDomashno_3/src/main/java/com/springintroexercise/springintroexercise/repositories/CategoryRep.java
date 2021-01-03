package com.springintroexercise.springintroexercise.repositories;

import com.springintroexercise.springintroexercise.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRep extends JpaRepository<Category, Integer> {


}
