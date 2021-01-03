package com.blq.springdatademo.servises;

import com.blq.springdatademo.Repositoty.StudentRepository;
import com.blq.springdatademo.entity.Student;
import com.blq.springdatademo.servises.base.StudentServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServicesImpl implements StudentServices {

    private final StudentRepository studentRepository;

    public StudentServicesImpl(StudentRepository studentRepository){
       this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByNamePatter(String name) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getName().contains(name))
                .collect(Collectors.toList());

    }
}
