package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeSingleton;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {

//    private final EmployeeDao employeeDao = new EmployeeSimpleDao();
    private final EmployeeDao employeeDao = EmployeeSingleton.getInstance().getEmployeeDao();
    private final RandomHttpService randomHttpService = new RandomHttpService();

    public Long add(Employee employee) throws BusinessException {
        //dosome work
//        int generateNumber = randomHttpService.getNumber(1000, 10000);
//        employee.setSalary(generateNumber);
        Long id;
        try {
            id = employeeDao.addEmployee(employee);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
        return id;
    }

    public void update(Employee employee) throws BusinessException {
        try {
            employeeDao.updateEmployee(employee);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) throws BusinessException {
        try {
            employeeDao.deleteEmployee(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public Employee get(Long id) throws BusinessException {
        try {
            return employeeDao.getEmployee(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public List<Employee> findAll() throws BusinessException {
        try {
            return employeeDao.findEmployees();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public int size() throws BusinessException {
        try {
            return employeeDao.size();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void clear() throws BusinessException {
        try {
            employeeDao.clear();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }
}
