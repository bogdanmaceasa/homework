package work11MVC.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import work11MVC.model.DTO.RestaurantDTO;
import work11MVC.model.Entity.RestaurantsEntity;
import work11MVC.repository.MVCRestaurantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final MVCRestaurantRepository mvcRestaurantRepository;

    public List<RestaurantsEntity> getAllRestaurants() {
        return mvcRestaurantRepository.findAll();
    }

    public RestaurantsEntity getRestaurantById(Integer id) {
        return mvcRestaurantRepository.findById(id).get();
    }

    public RestaurantsEntity updateRestaurant(RestaurantDTO request) {
        RestaurantsEntity restaurantsEntity = mvcRestaurantRepository.findById(request.getId()).get();

        restaurantsEntity.setName(request.getName());
        restaurantsEntity.setAddress(request.getAddress());
        restaurantsEntity.setSpeciality(request.getSpeciality());

        return mvcRestaurantRepository.save(restaurantsEntity);
    }


    public RestaurantsEntity createRestaurant(RestaurantDTO request) {
        RestaurantsEntity restaurant = RestaurantsEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .speciality(request.getSpeciality())
                .details(request.getDetails())
                .build();

        return mvcRestaurantRepository.save(restaurant);
    }

    public void deleteRestaurantById(Integer id) {
        mvcRestaurantRepository.deleteById(id);
    }

}
