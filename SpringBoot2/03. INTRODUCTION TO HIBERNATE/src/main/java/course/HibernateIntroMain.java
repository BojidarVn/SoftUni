package course;

import course.springdata.hibernate.entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class HibernateIntroMain {
    public static void main(String[] args) {
// create hibernate config
        Configuration cfg = new Configuration();
        cfg.configure();

// Create sessionFactory

        SessionFactory sf = cfg.buildSessionFactory();

        // Create Session
        Session session = sf.openSession();
        Student student = new Student("Blq kov");
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        // Read entity by id
        session.beginTransaction();
        session.setHibernateFlushMode(FlushMode.MANUAL);
        Student result = session.get(Student.class, 1L, LockMode.READ);
      //  Optional<Student> result = session.byId(Student.class).loadOptional(10L);
        session.getTransaction().commit();
     //   System.out.printf("Student %s", result.orElseGet(() ->null  ));
       // System.out.printf("Student %s", result.orElseGet(() ->new Student("Anonimous")));
        System.out.printf("Student with ID: %d -> %s", result.getId(), result);


// List all students
  //    session.beginTransaction();
  //    session.createQuery("FROM Student", Student.class)
  //    .setFirstResult(5)
  //    .setMaxResults(8)
  //    .stream().forEach(System.out::println);
  //    session.getTransaction().commit();

// pozacionni i imenovani parametri
  //  session.createQuery("FROM Student WHERE name = ?1", String.class)
  //  .setParameter(0,"Koki Chochkov")
  //  .stream().forEach(System.out::println);


 // Type-safe critetia quieries

        CriteriaBuilder cb=session.getCriteriaBuilder() ;
        CriteriaQuery<Student> query=cb.createQuery(Student.class);
        Root<Student> Student_ = query.from(Student.class);
        query.select(Student_).where(cb.like(Student_.get("name"), "K%"));
        session.createQuery(query).getResultStream()
                .forEach(System.out::println);




        // Close Session
        session.close();







    }

}
