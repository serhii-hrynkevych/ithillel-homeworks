package ua.ithillel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentWithChief extends Department {
    private final String nameChief;

    public DepartmentWithChief(Long id, String name, String nameChief) {
        super(id, name);
        this.nameChief = nameChief;
    }

    @Override
    public String toString() {
        return "Департамент: " + super.getName() + ", начальник отдела: " + nameChief + ", ID отдела: " + super.getId();
    }
}
