package ua.ithillel.service;

import ua.ithillel.dao.DepartmentDao;
import ua.ithillel.dao.DepartmentSimpleDao;
import ua.ithillel.dao.DepartmentSingleton;
import ua.ithillel.model.Department;

import java.util.List;

public class DepartmentManageService {
    //private final DepartmentDao departmentDao = new DepartmentSimpleDao();
    private final DepartmentDao departmentDao = DepartmentSingleton.getInstance().getDepartmentDao();

    public Long add(Department department) {
        //dosome work

        Long id = departmentDao.appDepartment(department);
        return id;
    }

    public void update(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void delete(Long id) {
        departmentDao.deleteDepartment(id);
    }

    public Department get(Long id) {
        return departmentDao.getDepartment(id);
    }

    public List<Department> findAll() {
        return departmentDao.findDepartments();
    }

    public int size() {
        return departmentDao.size();
    }
}
