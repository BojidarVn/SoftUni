package com.example.demo.domaint.repositories;

import com.example.demo.domaint.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
