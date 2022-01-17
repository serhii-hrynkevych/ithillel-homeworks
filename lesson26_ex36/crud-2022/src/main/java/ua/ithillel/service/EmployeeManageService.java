package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeSimpleDao;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {

    private final EmployeeDao employeeDao = new EmployeeSimpleDao();

    public Long add(Employee employee) {
        //dosome work

        Long id = employeeDao.appEmployee(employee);
        return id;
    }

    public void update(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void delete(Long id) {
        employeeDao.deleteEmployee(id);
    }

    public Employee get(Long id) {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> findAll() {
        return employeeDao.findEmployees();
    }

    public int size() {
        return employeeDao.size();
    }
}
