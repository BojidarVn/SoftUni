package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByUsername(String username);


    @Query("SELECT u FROM User AS u ORDER BY COUNT(u.post) DESC, u.id ")
    Set<User> findAllUsersWithTheirPosts();


}
