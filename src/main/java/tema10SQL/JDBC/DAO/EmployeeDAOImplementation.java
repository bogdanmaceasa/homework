package tema10SQL.JDBC.DAO;

import lombok.extern.log4j.Log4j;
import tema10SQL.JDBC.model.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sqlStatement = "select * from employee";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            connection.setAutoCommit(false);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = Employee.builder()
                        .employeeNo(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .job(resultSet.getString("job"))
                        .employeeManager(resultSet.getInt("mgr"))
                        .hireDate(LocalDate.parse(resultSet.getString("hiredate")))
                        .employeeSalary(resultSet.getInt("salary"))
                        .employeeComm(resultSet.getInt("comm"))
                        .employeeDepartmentNo(resultSet.getInt("department_id"))
                        .build();
                employees.add(employee);
            }
        } catch (SQLException ex) {
            log.error(ex);
        }

        return employees;
    }


    @Override
    public void insertEmployee(Employee employee) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "insert into employee values\n" +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, employee.getEmployeeNo());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setInt(4, employee.getEmployeeManager());
            preparedStatement.setDate(5, Date.valueOf(employee.getHireDate()));
            preparedStatement.setInt(6, employee.getEmployeeSalary());
            preparedStatement.setInt(7, employee.getEmployeeComm());
            preparedStatement.setInt(8, employee.getEmployeeDepartmentNo());

            //executeUpdate used for actions with null return ( insert / update / delete )
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public Employee findEmployeeByNameContaining(String name) {

        try (Connection connection = getConnection()) {
            String sql = "select id, name, job, hiredate, salary, comm from employee e WHERE e.name LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Employee.builder()
                        .employeeNo(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .job(resultSet.getString("job"))
                        .hireDate(LocalDate.parse(resultSet.getString("hiredate")))
                        .employeeSalary(resultSet.getInt("salary"))
                        .employeeComm(resultSet.getInt("comm"))
                        .build());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try (Connection connection = getConnection()) {
            //"update department d set d.name = ? where d.name like ?"
            String sqlStatement = "update employee d set d.name=?, d.job=?, d.mgr=?, d.hiredate=?, d.salary=?, d.comm=?, d.department_id=? where d.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(8, employee.getEmployeeNo());
            preparedStatement.setString(2, employee.getJob());
            preparedStatement.setInt(3, employee.getEmployeeManager());
            preparedStatement.setDate(4, Date.valueOf(employee.getHireDate()));
            preparedStatement.setInt(5, employee.getEmployeeSalary());
            preparedStatement.setInt(6, employee.getEmployeeComm());
            preparedStatement.setInt(7, employee.getEmployeeDepartmentNo());

            //executeUpdate used for actions with null return ( insert / update / delete )
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " rows updated");

        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }

    @Override
    public void delete(int no) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "delete from employee d where d.id like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, no);

            //executeUpdate used for actions with null return ( insert / update / delete )
            int alteredRows = preparedStatement.executeUpdate();
            System.out.println(alteredRows);

        } catch (SQLException ex) {
            log.error(ex);
        }

    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hr",
                    "admin",
                    "password");

        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
}
