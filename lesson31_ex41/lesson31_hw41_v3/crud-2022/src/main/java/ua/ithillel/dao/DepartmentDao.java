package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;

import java.util.List;

public interface DepartmentDao {
    Long addDepartment(Department department) throws DaoException;

    void updateDepartment(Department department) throws DaoException;

    void deleteDepartment(Long id) throws DaoException;

    Department getDepartment(Long id) throws DaoException;

    List<Department> findDepartments() throws DaoException;

    int size() throws DaoException;

    void clear() throws DaoException;
}
