package softuni.productshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.productshop.domain.entities.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
