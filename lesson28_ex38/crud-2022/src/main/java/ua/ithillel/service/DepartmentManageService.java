package ua.ithillel.service;

import ua.ithillel.dao.DepartmentDao;
import ua.ithillel.dao.DepartmentSingleton;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;

import java.util.List;

public class DepartmentManageService {
    //private final DepartmentDao departmentDao = new DepartmentSimpleDao();
    private final DepartmentDao departmentDao = DepartmentSingleton.getInstance().getDepartmentDao();

    public Long add(Department department) throws BusinessException {
        //dosome work

        Long id = null;
        try {
            id = departmentDao.addDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
        return id;
    }

    public void update(Department department) throws BusinessException {
        try {
            departmentDao.updateDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) throws BusinessException {
        try {
            departmentDao.deleteDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public Department get(Long id) throws BusinessException {
        try {
            return departmentDao.getDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public List<Department> findAll() throws BusinessException {
        try {
            return departmentDao.findDepartments();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public int size() throws BusinessException {
        try {
            return departmentDao.size();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void clear() throws BusinessException {
        try {
            departmentDao.clear();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }
}
