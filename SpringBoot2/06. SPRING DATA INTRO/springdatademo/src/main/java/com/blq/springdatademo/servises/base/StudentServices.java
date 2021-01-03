package com.blq.springdatademo.servises.base;

import com.blq.springdatademo.entity.Student;

import java.util.List;

public interface StudentServices {

    List<Student> getAll();

    List<Student> findByNamePatter(String name);
}
