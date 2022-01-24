package ua.ithillel.dao;

import ua.ithillel.dbconnect.DbConnectionFactory;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.ithillel.util.AppConstant.*;

public class DepartmentDatabaseDao implements DepartmentDao{
    private static final String INSERT = "INSERT INTO department (name) VALUES (?)";
    private static final String UPDATE = "UPDATE department SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM department WHERE id = ?";
    private static final String SELECT_ONE = "SELECT * FROM department WHERE id = ?";
    private static final String SELECT = "SELECT * FROM department";
    private static final String SIZE = "SELECT count(*) FROM department";
    private static final String CLEAR = "DELETE FROM department";

    @Override
    public Long addDepartment(Department department) throws DaoException {
        Long departmentId = null;
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(INSERT, new String[]{ID, NAME})
        ){
            pstm.setString(1, department.getName());
            int count = pstm.executeUpdate();
            System.out.println(count + " rows inserted");
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                departmentId = gk.getLong(ID);
                System.out.println("------------ " + gk.getString(NAME));
            }
            return departmentId;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateDepartment(Department department) throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(UPDATE)
        ) {
            pstm.setString(1, department.getName());
            pstm.setLong(2, department.getId());
            int count = pstm.executeUpdate();
            System.out.println(count + " rows updated");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteDepartment(Long id) throws DaoException {
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
    public Department getDepartment(Long id) throws DaoException {
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(SELECT_ONE)
        ) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Department(
                        rs.getLong(ID),
                        rs.getString(NAME)
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public List<Department> findDepartments() throws DaoException {
        List<Department> departmentList = new ArrayList<>();
        try (
                Connection con = DbConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Department department = new Department(
                        rs.getLong(ID),
                        rs.getString(NAME)
                );
                departmentList.add(department);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return departmentList;
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
