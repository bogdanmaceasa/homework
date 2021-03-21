package tema10SQL.JDBC.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@Builder
@Data
public class Employee {
    @Id
    @Column(name = "id")
    private int employeeNo;

    private final String name;

    private final String job;

    @Column(name = "mgr")
    private final int employeeManager;

    private final LocalDate hireDate;

    @Column(name = "salary")
    private int employeeSalary;

    @Column(name = "comm")
    private int employeeComm;

    @Column(name = "department_id")
    private int employeeDepartmentNo;
}

