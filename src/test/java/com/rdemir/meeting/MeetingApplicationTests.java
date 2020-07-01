package com.rdemir.meeting;

import com.rdemir.meeting.controller.EmployeeController;
import com.rdemir.meeting.entity.Department;
import com.rdemir.meeting.entity.Employee;
import com.rdemir.meeting.entity.Meeting;
import com.rdemir.meeting.service.imp.EmployeeServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingApplicationTests {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private EmployeeController employeeController;

    @Mock
    Employee employee;

    @Mock
    Department department;

    @Mock
    Meeting meeting;
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
