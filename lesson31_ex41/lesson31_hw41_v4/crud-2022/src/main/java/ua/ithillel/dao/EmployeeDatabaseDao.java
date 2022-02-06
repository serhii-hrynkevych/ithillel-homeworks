package ua.ithillel.dao;

import ua.ithillel.dbconnect.DbConnectionFactory;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {
    private static final String INSERT = "INSERT INTO employee (name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private static final String SELECT = "SELECT * FROM employee";
    private static final String SIZE = "SELECT count(*) FROM employee";
    private static final String CLEAR = "DELETE FROM employee";

    @Override
    public Long addEmployee(Employee employee) throws DaoException {
        Long employeeId = null;
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(INSERT, new String[]{ID, NAME})
        ) {
            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            int count = pstm.executeUpdate();
            System.out.println(count + " rows inserted");
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                employeeId = gk.getLong(ID);
                System.out.println("------------ " + gk.getString(NAME));
            }
            return employeeId;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(UPDATE)
        ){
            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            pstm.setLong(5, employee.getId());
            int count = pstm.executeUpdate();
            System.out.println(count + " rows updated");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteEmployee(Long id) throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(DELETE)
        ) {
            pstm.setLong(1, id);
            int count = pstm.executeUpdate();
            System.out.println(count + " rows deleted");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Employee getEmployee(Long id) throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(SELECT_ONE)
        ) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Long chief_id = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chief_id = null;
                }
                return new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chief_id,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public List<Employee> findEmployees() throws DaoException {

        List<Employee> employeeList = new ArrayList<>();
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Long chief_id = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chief_id,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employeeList;
    }

    @Override
    public int size() throws DaoException {
        int size = 0;
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SIZE);
            rs.next();
            size = rs.getInt(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return size;
    }

    @Override
    public void clear() throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ){
            stmt.execute(CLEAR);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}