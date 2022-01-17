package ua.ithillel.dao;

import ua.ithillel.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentSimpleDao implements DepartmentDao{
    private final List<Department> departmentList = new ArrayList<>();
    private long positionId = 0;

    @Override
    public Long appDepartment(Department department) {
        Long newId = positionId;
        positionId++;
        department.setId(newId);
        departmentList.add(department);
        return newId;
    }

//    private Long generateId() {
//        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
//        while (Objects.nonNull(getDepartment(id))) {
//            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
//        }
//        return id;
//    }

    @Override
    public void updateDepartment(Department department) {
        Long id = department.getId();
        Department value = getDepartment(id);
        if (value != null) {
            value.setName(department.getName());
        } else {
            System.out.println("Not found department");
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        Department value = getDepartment(id);
        if (value != null) {
            departmentList.remove(value);
        } else {
            System.out.println("Not found department");
        }
    }

    @Override
    public Department getDepartment(Long id) {
        for (Department value : departmentList) {
            Long depId = value.getId();
            if (depId.equals(id)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Department> findDepartments() {
        return departmentList;
    }

    @Override
    public int size() {
        return departmentList.size();
    }
}
