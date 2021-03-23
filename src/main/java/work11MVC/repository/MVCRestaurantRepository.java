package work11MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work11MVC.model.Entity.RestaurantsEntity;

@Repository
public interface MVCRestaurantRepository extends JpaRepository<RestaurantsEntity, Integer> {


}
