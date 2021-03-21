package tema10SQL.JDBC.DAO;

import tema10SQL.JDBC.model.Department;


import java.util.List;

public interface DepartmentDAO {

    List<Department> findAll();

    void insertDepartment(Department department);

    Department findDepartment(int id);

    void updateDepartmentName(String name, String newName);

    void delete(int no);

}
