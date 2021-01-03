import net.bytebuddy.build.Plugin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final String GRINGOTTS_PU="gringotts3";
    private static final String SELES_PU="seles";
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory(GRINGOTTS_PU);

        EntityManager entityManager=emf.createEntityManager();

        Engine engine= new Engine (entityManager);

        engine.run();

    }
}
