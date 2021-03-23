package work10SQL.JDBC.DAO;

import work10SQL.JDBC.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    void insertEmployee(Employee employee);

    Employee findEmployeeByNameContaining(String name);

    Employee updateEmployee(Employee employee);

    void delete(int no);

}
