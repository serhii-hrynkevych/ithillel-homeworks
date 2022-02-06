package ua.ithillel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class EmployeeWithDepartment extends Employee {
    private final String department;
    private final String nameChief;

    public EmployeeWithDepartment(Long id, String name, int salary, Long departmentId, Long chiefId, String department, String chief) {
        super(id, departmentId, chiefId, name, salary);
        this.department = department;
        this.nameChief = chief;
    }
}
