package tema6;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hobby {

    private String name;
    private int timesPerWeek = 0;
    private List<String> locations = new ArrayList<>();


    public Hobby(String nameOfHobby) {
        this.name = nameOfHobby;
    }




}
