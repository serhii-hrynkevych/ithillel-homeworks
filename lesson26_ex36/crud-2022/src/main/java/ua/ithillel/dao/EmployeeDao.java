package ua.ithillel.dao;

import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Long appEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployee(Long id);

    List<Employee> findEmployees();

    int size();
}
