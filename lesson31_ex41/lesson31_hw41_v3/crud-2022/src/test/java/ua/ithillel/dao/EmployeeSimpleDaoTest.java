package ua.ithillel.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSimpleDaoTest {

    private final EmployeeManageService testEms = new EmployeeManageService();

    @BeforeEach
    void setUp() throws BusinessException {
        Employee testEmp1 = new Employee(1L, null, "Test Employee 1", 100);
        Long emp1Id = testEms.add(testEmp1);
        Employee testEmp2 = new Employee(1L, emp1Id, "Test Employee 2", 200);
        testEms.add(testEmp2);
        Employee testEmp3 = new Employee(1L, emp1Id, "Test Employee 3", 300);
        testEms.add(testEmp3);
    }

    @Test
    void testAppEmployee() throws BusinessException {
        Employee testNewEmployee = new Employee(2L, null, "Test employee new", 400);
        assertEquals(3L, testEms.add(testNewEmployee));
    }

    @Test
    void testUpdateEmployee() throws BusinessException {
        Employee testUpdateEmp = new Employee(2L, 5L, 1L, "Test Employee after update", 340);
        testEms.update(testUpdateEmp);
        Employee result = testEms.get(2L);
        assertEquals(testUpdateEmp, result);
    }

    @Test
    void testUpdateEmployeeDepartmentId() throws BusinessException {
        Long updateValue = 5L;
        Employee testUpdateEmp = new Employee(2L, updateValue, 1L, "Test Employee", 300);
        testEms.update(testUpdateEmp);
        Long result = testEms.get(2L).getDepartmentId();
        assertEquals(updateValue, result);
    }

    @Test
    void testUpdateEmployeeChiefId() throws BusinessException {
        Long updateValue = 4L;
        Employee testUpdateEmp = new Employee(2L, 1L, updateValue, "Test Employee", 300);
        testEms.update(testUpdateEmp);
        Long result = testEms.get(2L).getChiefId();
        assertEquals(updateValue, result);
    }

    @Test
    void testUpdateEmployeeName() throws BusinessException {
        String updateValue = "Test Employee 3 after update";
        Employee testUpdateEmp = new Employee(2L, 1L, 1L, updateValue, 300);
        testEms.update(testUpdateEmp);
        String result = testEms.get(2L).getName();
        assertEquals(updateValue, result);
    }

    @Test
    void testUpdateEmployeeSalary() throws BusinessException {
        int updateValue = 320;
        Employee testUpdateEmp = new Employee(2L, 1L, 1L, "Test Employee", updateValue);
        testEms.update(testUpdateEmp);
        int result = testEms.get(2L).getSalary();
        assertEquals(updateValue, result);
    }

    @Test
    void testDeleteEmployee() throws BusinessException {
        testEms.delete(1L);
        assertEquals(2, testEms.size());
    }

    @Test
    void testDeleteEmployee2() throws BusinessException {
        testEms.delete(1L);
        assertNull(testEms.get(1L));
    }

    @Test
    void testGetEmployee() throws BusinessException {
        Employee testEmpGet = new Employee(0L,1L, null, "Test Employee 1", 100);
        assertEquals(testEmpGet, testEms.get(0L));
    }

    @Test
    void testFindEmployees() throws BusinessException {
        assertNotNull(testEms.findAll());
    }
}