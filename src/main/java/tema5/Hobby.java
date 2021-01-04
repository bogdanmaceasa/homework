package tema5;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hobby {

    private String nameOfHobby;
    private int practiceFreq = 0;
    private List<String> addresses = new ArrayList<>();


    public Hobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }
}
