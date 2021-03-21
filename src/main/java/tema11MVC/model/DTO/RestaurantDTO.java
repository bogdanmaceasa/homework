package tema11MVC.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantDTO {

    private int id;

    private String name;

    private String address;

    private String speciality;

    private String details;

}
