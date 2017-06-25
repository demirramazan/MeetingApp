package com.rdemir.assginment;

import com.rdemir.assginment.controller.EmployeeController;
import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.entity.Employee;
import com.rdemir.assginment.entity.Meeting;
import com.rdemir.assginment.service.imp.EmployeeServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentmebiApplicationTests {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private EmployeeController employeeController;

    static Employee employee;

    static Department department;

    static Meeting meeting;
//    @Before
//    public void setUp() throws Exception {
//        department=new Department(1L,"software","software department description");
//         employee=new Employee(1L,"ramazan","demir",1500,1L);
//    }

    @Test
    public void test_employee_get() {

        department = new Department(1L, "software", "software department description");
        employee = new Employee(1L, "ramazan", "demir", 1500, 1L);

        assertEquals(1, employeeController.getEmployes().size());
        assertNotNull(employeeController.getEmployee(1L));
        assertEquals("ramazan", employeeController.getEmployee(1L).getName());
        assertNotNull(employee);
        assertEquals("Ismi ramazan olan employee yok", "ramazan", employee.getName());


    }

    @Test
    public void test_employee_add() throws Exception {
        department = new Department(1L, "software", "software department description");
        employee = new Employee(2L, "abuzer", "demir", 1700, 1L);

        employeeServiceImp.saveEmployee(employee);
        assertNotNull(employeeController.getEmployes());

        assertEquals("abuzer", employeeController.getEmployee(2L).getName());
    }
}
