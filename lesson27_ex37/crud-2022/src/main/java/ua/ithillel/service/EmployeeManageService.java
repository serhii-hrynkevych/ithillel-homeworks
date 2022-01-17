package ua.ithillel.service;

import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeSimpleDao;
import ua.ithillel.dao.EmployeeSingleton;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {

//    private final EmployeeDao employeeDao = new EmployeeSimpleDao();
    private final EmployeeDao employeeDao = EmployeeSingleton.getInstance().getEmployeeDao();
    private final RandomHttpService randomHttpService = new RandomHttpService();

    public Long add(Employee employee) {
        //dosome work
//        int generateNumber = randomHttpService.getNumber(1000, 10000);
//        employee.setSalary(generateNumber);
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
