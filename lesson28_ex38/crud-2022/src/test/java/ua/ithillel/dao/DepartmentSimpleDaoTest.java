package ua.ithillel.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentSimpleDaoTest {

    DepartmentManageService testDms = new DepartmentManageService();

    @BeforeEach
    void setUp() throws BusinessException {
        Department testDmp1 = new Department("Test Department 1");
        testDms.add(testDmp1);
        Department testDmp2 = new Department("Test Department 2");
        testDms.add(testDmp2);
        Department testDmp3 = new Department("Test Department 3");
        testDms.add(testDmp3);
    }

    @Test
    void testAppDepartment() throws BusinessException {
        Department testNewDepartment = new Department("Test Department add new");
        assertEquals(3L, testDms.add(testNewDepartment));
    }

    @Test
    void testUpdateDepartment() throws BusinessException {
        Department testUpdateDmp = new Department(2L,"Test Department 3 after update");
        testDms.update(testUpdateDmp);
        Department result = testDms.get(2L);
        assertEquals(testUpdateDmp, result);
    }

    @Test
    void testUpdateDepartmentName() throws BusinessException {
        String updateValue = "Test Department 3 after update name";
        Department testUpdateDmp = new Department(2L,updateValue);
        testDms.update(testUpdateDmp);
        String result = testDms.get(2L).getName();
        assertEquals(updateValue, result);
    }

    @Test
    void testDeleteDepartment() throws BusinessException {
        testDms.delete(1L);
        assertEquals(2, testDms.size());
    }

    @Test
    void testDeleteDepartment2() throws BusinessException {
        testDms.delete(1L);
        assertNull(testDms.get(1L));
    }

    @Test
    void testGetDepartment() throws BusinessException {
        Department testDmpGet = new Department(2L, "Test Department 3");
        assertEquals(testDmpGet, testDms.get(2L));
    }

    @Test
    void testFindDepartments() throws BusinessException {
        assertNotNull(testDms.findAll());
    }
}