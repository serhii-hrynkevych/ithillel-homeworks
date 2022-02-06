package ua.ithillel.dao;

public class DepartmentSingleton {
    private static DepartmentSingleton instance;
    private final DepartmentDao departmentDao = new DepartmentDatabaseDao();

    public static synchronized DepartmentSingleton getInstance() {
        if (instance == null) {
            instance = new DepartmentSingleton();
        }
        return instance;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }
}
