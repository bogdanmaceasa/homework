package tema10SQL.JDBC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;


@AllArgsConstructor
@Builder
@Data
public class Department {

    @Id
    @Column(name = "id")
    private int departmentId;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "city")
    private String departmentCity;

}
