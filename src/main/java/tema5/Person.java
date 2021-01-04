package tema5;

import lombok.*;

import java.util.Objects;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person {

    private String name;
    private int age;

}
