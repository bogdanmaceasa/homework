package tema11MVC.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tema11MVC.model.DTO.RestaurantDTO;
import tema11MVC.model.Entity.RestaurantsEntity;
import tema11MVC.service.RestaurantService;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/showRestaurants"})
    public String showRestaurantPage(Model model) {

        List<RestaurantsEntity> restaurantsEntityList = restaurantService.getAllRestaurants();

        model.addAttribute("restaurantList", restaurantsEntityList);
        RestaurantDTO attributeValue = new RestaurantDTO();
        model.addAttribute("restaurantToAdd", attributeValue);
        Object restaurantFromHTML = model.getAttribute("restaurantFromHTML");
        return "restaurants";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String showAddPage(ModelMap model) {

        RestaurantDTO attributeValue = new RestaurantDTO();
        model.addAttribute("restaurantToAdd", attributeValue);
        return "addRestaurant";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "restaurantToAdd") RestaurantDTO request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "addRestaurant";
        }
        restaurantService.createRestaurant(request);
        return showRestaurantPage(model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-all")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "restaurantToAdd") List<RestaurantDTO> requestList,
                      Model model) {

        requestList.forEach(request -> restaurantService.createRestaurant(request));

        return showRestaurantPage(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{restaurantId}/edit")
    public String showEditPage(@PathVariable(name = "restaurantId") String id,
                               ModelMap model) {

        RestaurantsEntity restaurant = restaurantService.getRestaurantById(Integer.parseInt(id));
        model.addAttribute("restaurantToEdit", restaurant);

        return "editRestaurant";
    }

    @PostMapping("/{restaurantId}/edit")
    public String editRestaurant(@PathVariable int restaurantId,
                                 @ModelAttribute(name = "restaurantToEdit") RestaurantDTO request,
                                 BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "editRestaurant";
        }

        request.setId(restaurantId);
        restaurantService.updateRestaurant(request);

        return showRestaurantPage(model);
    }

    @PostMapping("/{restaurantId}/delete")
    public String deleteRestaurant(@PathVariable int restaurantId,
                                   Model model) {

        restaurantService.deleteRestaurantById(restaurantId);

        return showRestaurantPage(model);
    }
}
