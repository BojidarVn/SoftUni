package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.DTO.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findFirstByUsername(String username);


}
