package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSimpleDao implements EmployeeDao{
    private final List<Employee> employeeList = new ArrayList<>();
    private long positionId = 0;

    @Override
    public Long addEmployee(Employee employee) {
        Long newId = positionId;
        positionId++;
        employee.setId(newId);
        employeeList.add(employee);
        return newId;
    }

//    private Long generateId() {
//        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
//        while (Objects.nonNull(getEmployee(id))) {
//            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
//        }
//        return (long) employeeList.size();
//    }

    @Override
    public void updateEmployee(Employee employee) {
        Long id = employee.getId();
        Employee value = getEmployee(id);
        if (value != null) {
            value.setDepartmentId(employee.getDepartmentId());
            value.setChiefId(employee.getChiefId());
            value.setName(employee.getName());
            value.setSalary(employee.getSalary());
        } else {
            System.out.println("Not found employee");
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee value = getEmployee(id);
        if (value != null) {
            employeeList.remove(value);
        } else {
            System.out.println("Not found employee");
        }
    }

    @Override
    public Employee getEmployee(Long id) {
        for (Employee value : employeeList) {
            Long emplId = value.getId();
            if (emplId.equals(id)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }

    @Override
    public int size() {
        return employeeList.size();
    }

    @Override
    public void clear() throws DaoException {
    }
}
