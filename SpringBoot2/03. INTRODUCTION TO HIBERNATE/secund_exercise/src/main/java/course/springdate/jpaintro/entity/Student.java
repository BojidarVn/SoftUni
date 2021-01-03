package course.springdate.jpaintro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column( name = "registration_Date")
    private Date registrationDate= new Date();


}
