package softuni.cardelar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardelar.domain.entities.Car;

import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Set<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
