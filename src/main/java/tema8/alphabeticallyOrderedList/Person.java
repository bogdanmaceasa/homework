package tema8.alphabeticallyOrderedList;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
