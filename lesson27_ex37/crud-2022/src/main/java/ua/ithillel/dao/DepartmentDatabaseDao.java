package ua.ithillel.dao;

import ua.ithillel.dbconnect.DatabaseConnectionSingleton;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDatabaseDao implements DepartmentDao{
    @Override
    public Long appDepartment(Department department) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        Long departmentId = null;
        try {
            String sql = "INSERT INTO department (name) VALUES ('" + department.getName() + "')";
            PreparedStatement pstm = con.prepareStatement(sql, new String[]{"id", "name"});
            int i = pstm.executeUpdate(sql);
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                departmentId = gk.getLong("id");
                System.out.println("------------ " + gk.getString("name"));
            }
            return departmentId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDepartment(Department department) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {
            String sql = "UPDATE department SET name = '" + department.getName() + "' WHERE id = " + department.getId();
            int result = stmt.executeUpdate(sql);
            messageOperation(result, department.getId(), "updated");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {
            String sql = "DELETE FROM department WHERE id = " + id;
            int result = stmt.executeUpdate(sql);
            messageOperation(result, id, "deleted");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department getDepartment(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        Department department = null;
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM department WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                department = new Department(
                        rs.getLong("id"),
                        rs.getString("name")
                );
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> findDepartments() {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        List<Department> departmentList = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT * FROM department";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Department department = new Department(
                        rs.getLong("id"),
                        rs.getString("name")
                );
                departmentList.add(department);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public int size() {
        int size = 0;
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT count(*) FROM department";
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
