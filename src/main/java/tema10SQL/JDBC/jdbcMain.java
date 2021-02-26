package tema10SQL.JDBC;

import tema10SQL.JDBC.DAO.DepartmentDAO;
import tema10SQL.JDBC.DAO.DepartmentDAOImplementation;
import tema10SQL.JDBC.DAO.EmployeeDAO;
import tema10SQL.JDBC.DAO.EmployeeDAOImplementation;
import tema10SQL.JDBC.model.Department;
import tema10SQL.JDBC.model.Employee;

import java.time.LocalDate;

public class jdbcMain {

/*

Utilizand schema  hr din fisierul atasat , creati doua clase
DAO(DataAccessObject)/Repository: EmployeeDAOImpl si DepartmentDAOImpl care sa implementeze interfetele:
EmployeeDAO si DepartmentDAO cu cele 4 operatii CRUD (create, read, update, delete),
utilizand si parametri de filtrare, la alegere ( in general, stergerea si updatarea se recomanda sa se faca dupa ID,
la select se pot utiliza orice parametrii de filtrare sunt necesari).

PS: Aveti mana libera sa le faceti si cu JPA, dar cu JDBC este obligatoriu(asta va fi punctat)
Am atasat si varianta in care am modificat numele sa nu mai fie cu majuscule
*/

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
        DepartmentDAO departmentDAO = new DepartmentDAOImplementation();
        employeeDAO.findAll().forEach(System.out::println);

        System.out.println("___________________________");

        departmentDAO.findAll().forEach(System.out::println);

        System.out.println("___________________________");

        employeeDAO.findEmployeeByNameContaining("%K%");
        System.out.println("___________________________");

        Employee employee = Employee.builder()
                .job("job")
                .name("name")
                .employeeManager(2222)
                .employeeNo(123)
                .hireDate(LocalDate.now())
                .build();

        employeeDAO.insertEmployee(employee);

        Employee employee1 = Employee.builder()
                .job("MASON")
                .name("BILL GATES")
                .employeeNo(employee.getEmployeeNo())
                .hireDate(LocalDate.now())
                .build();

        System.out.println("___________________________");

        employeeDAO.updateEmployee(employee1);

        employeeDAO.findEmployeeByNameContaining("%BILL%");

        System.out.println("___________________________");

        employeeDAO.delete(employee.getEmployeeNo());

        Department department = Department.builder()
                .departmentCity("BRASOV")
                .departmentId(50)
                .departmentName("OPERATIONS")
                .build();

        departmentDAO.insertDepartment(department);

        departmentDAO.findDepartment(50);

//        new EmployeeDAOImplementation().findEmployeeNumber();
    }


}

