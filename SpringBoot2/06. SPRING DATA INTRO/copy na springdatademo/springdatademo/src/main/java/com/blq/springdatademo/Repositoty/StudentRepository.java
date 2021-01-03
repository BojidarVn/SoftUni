package com.blq.springdatademo.Repositoty;

import com.blq.springdatademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
