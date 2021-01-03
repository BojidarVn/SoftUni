package com.blq.springdatademo;

import com.blq.springdatademo.Repositoty.StudentRepository;
import com.blq.springdatademo.entity.Student;
import com.blq.springdatademo.servises.base.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {

    @Autowired
    private StudentServices studentServices;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Blq blq");
//        Student st=new Student();
//        studentRepository.findAll()
//                .forEach(System.out::println);
studentServices.getAll()
        .forEach(System.out::println);


    }
}
