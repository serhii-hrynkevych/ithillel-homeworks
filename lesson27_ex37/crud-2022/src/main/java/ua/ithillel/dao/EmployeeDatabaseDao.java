package ua.ithillel.dao;
import ua.ithillel.dbconnect.DatabaseConnectionSingleton;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeDatabaseDao implements EmployeeDao {
    @Override
    public Long appEmployee(Employee employee) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        Long employeeId = null;
        try {
            String sql = "INSERT INTO employee (name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql, new String[]{"id", "name"});
            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            int i = pstm.executeUpdate();
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                employeeId = gk.getLong("id");
                System.out.println("------------ " + gk.getString("name"));
            }
            return employeeId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try {
            String sql = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = " + employee.getId();
            PreparedStatement pstm = con.prepareStatement(sql, new String[]{"id"});
            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            int result = pstm.executeUpdate();
            messageOperation(result, employee.getId(), "updated");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {
            String sql = "DELETE FROM employee WHERE id = " + id;
            int result = stmt.executeUpdate(sql);
            messageOperation(result, id, "deleted");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        Employee employee = null;
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM employee WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long chief_id = rs.getLong("chief_id");
                if (rs.wasNull()) {
                    chief_id = null;
                }
                employee = new Employee(
                        rs.getLong("id"),
                        rs.getLong("department_id"),
                        chief_id,
                        rs.getString("name"),
                        rs.getInt("salary")
                );
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployees() {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long chief_id = rs.getLong("chief_id");
                if (rs.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(
                        rs.getLong("id"),
                        rs.getLong("department_id"),
                        chief_id,
                        rs.getString("name"),
                        rs.getInt("salary")
                );
                employeeList.add(employee);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public int size() {
        int size = 0;
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT count(*) FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            size = rs.getInt(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    private void messageOperation(int result, Long id, String operation) {
        if (result == 1) {
            System.out.println("Employee ID " + id + " " + operation);
        } else if (result == 0) {
            System.out.println("Not found employee ID - " + id);
        } else {
            System.out.println("Error(");
        }
    }
}