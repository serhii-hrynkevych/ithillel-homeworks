package ua.ithillel;

import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;

import java.util.List;

public class EmployeeDatabaseMain {

    public static void main(String[] args) {
        EmployeeManageService ems = new EmployeeManageService();
//        List<Employee> employees = ems.findAll();
//        System.out.println(employees);

//        Employee e = new Employee(1L, null, "1111Назаров Максим Давидович", 35000);
//        System.out.println(ems.add(e));

//        System.out.println(ems.get(18L));

//        ems.delete(33L);

//        Employee updateEmpl = new Employee(34L, 1L, null, "3322Назаров Максим Давидович", 35400);
//        ems.update(updateEmpl);

//        System.out.println(ems.size());

        DepartmentManageService dms = new DepartmentManageService();

//        List<Department> departments = dms.findAll();
//        System.out.println(departments);

        Department d = new Department("новый3");
        System.out.println(dms.add(d));

//        System.out.println(dms.size());

//        System.out.println(dms.get(5L));

//        dms.delete(7L);

//        Department updateDep1 = new Department(8L, "new");
//        dms.update(updateDep1);
    }
}