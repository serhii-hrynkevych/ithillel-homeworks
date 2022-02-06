package ua.ithillel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class DepartmentWithChief extends Department {
    private final String nameChief;

    public DepartmentWithChief(Long id, String name, String nameChief) {
        super(id, name);
        this.nameChief = nameChief;
    }
}
