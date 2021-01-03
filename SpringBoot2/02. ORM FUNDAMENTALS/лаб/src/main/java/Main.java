import entity.User;
import orm.EntityManager;
import orm.annotation.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static orm.Connector.getConnection;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/fsd";
    private static final String USER ="root";
    private static final String PASSWORD = "kit123k@t123";

    public static void main(String[] args) throws SQLException, IllegalAccessException {

        Connection connection= getConnection();


        EntityManager<User> entityManager= new EntityManager<>(connection);

        System.out.println("Connected to database");
        User user=new User();
        //user.setId(2);
        user.setUsername("88888");
        user.setPassword("MyPass34");
        user.setAge(22);
        user.setRegistrationDate(LocalDate.of(2000,11,1));

        entityManager.persist(user);


    }




}
