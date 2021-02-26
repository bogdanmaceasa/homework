package tema10SQL.JDBC.DAO;

import lombok.extern.log4j.Log4j;
import tema10SQL.JDBC.model.Department;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class DepartmentDAOImplementation implements DepartmentDAO{

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        String sqlStatement = "select * from department";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            connection.setAutoCommit(false);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department department = Department.builder()
                        .departmentId(resultSet.getInt("id"))
                        .departmentName(resultSet.getString("name"))
                        .departmentCity(resultSet.getString("city"))
                        .build();
                departmentList.add(department);
            }

//            try {
//                connection.commit();
//            } catch (SQLException e){
//                connection.rollback();
//            }
        } catch (SQLException ex) {

            log.error(ex);
        }

        return departmentList;
    }

    @Override
    public void insertDepartment(Department department) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "insert into department values\n" +
                    "(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setString(3, department.getDepartmentCity());

            //executeUpdate used for actions with null return ( insert / update / delete )
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public Department findDepartment(int id) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "select id,name,city from department d where d.id like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, id);

            //executeQuery used for actions with return values such as Selects
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Department.builder()
                        .departmentId(resultSet.getInt("id"))
                        .departmentName(resultSet.getString("name"))
                        .departmentCity(resultSet.getString("city"))
                        .build());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }

    public Department findDepartmentByName(String string) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "select id,name,city from department d where d.name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, string);

            //executeQuery used for actions with return values such as Selects
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Department.builder()
                        .departmentId(resultSet.getInt("id"))
                        .departmentName(resultSet.getString("name"))
                        .departmentCity(resultSet.getString("city"))
                        .build());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }

    @Override
    public void updateDepartmentName(String name, String newName) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "update department d set d.name = ? where d.name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, name);


            //executeUpdate used for actions with null return ( insert / update / delete )
            int alteredRows = preparedStatement.executeUpdate();

            System.out.println(alteredRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public void delete(int no) {
        try (Connection connection = getConnection()) {
            String sqlStatement = "delete from department d where d.name like ?";
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
