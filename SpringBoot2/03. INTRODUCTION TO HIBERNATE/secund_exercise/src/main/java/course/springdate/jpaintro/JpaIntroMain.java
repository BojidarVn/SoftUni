package course.springdate.jpaintro;

import course.springdate.jpaintro.entity.Student;
import course.springdate.jpaintro.entity.StudentOld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaIntroMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school_jpa");
        EntityManager em = emf.createEntityManager();
        StudentOld student = new StudentOld("Georg Pavlo");

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student found = em.find(Student.class, 1L);
        System.out.printf("Found student: %s%n", found);
        em.getTransaction().commit();


        em.getTransaction().begin();
        em.createQuery("SELECT s FROM Student as s WHERE s.name LIKE :name")
                .setParameter("name", "%")
                .getResultList().forEach(System.out::println);
        em.getTransaction().commit();

        em.getTransaction().begin();

        //   System.out.printf("Removed entity: %s",removed);

  //     em.detach(found);
  //     found.setName("Atanas Petrov");
  //    StudentOld managedEntity =  em.merge(found);
  //     System.out.printf("Same reference: %b",managedEntity == found);
   //     Student removed = em.find(Student.class, 1L);
   //     System.out.printf("Removed entity: %s", removed);
        em.getTransaction().commit();


        em.close();

    }
}
