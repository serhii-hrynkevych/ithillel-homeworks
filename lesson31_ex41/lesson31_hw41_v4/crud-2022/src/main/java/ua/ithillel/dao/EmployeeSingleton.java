package ua.ithillel.dao;

public class EmployeeSingleton {
    private static EmployeeSingleton instance;
    private final EmployeeDao employeeDao = new EmployeeDatabaseDao();

    public static synchronized EmployeeSingleton getInstance() {
        if (instance == null) {
            instance = new EmployeeSingleton();
        }
        return instance;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
