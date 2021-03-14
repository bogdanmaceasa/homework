package tema10SQL.JDBC.DAO;

import tema10SQL.JDBC.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    void insertEmployee(Employee employee);
    Employee findEmployeeByNameContaining(String name);
    Employee updateEmployee(Employee employee);
    void delete(int no);

}
