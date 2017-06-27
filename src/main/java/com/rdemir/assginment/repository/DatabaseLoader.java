package com.rdemir.assginment.repository;

import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.entity.Employee;
import com.rdemir.assginment.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public void run(String... strings) throws Exception {

        departmentRepository.save(new Department(1L, "Engineering", "This is engineering description"));

        departmentRepository.save(new Department(2L, "Design", "This is design description"));

        departmentRepository.save(new Department(3L, "engineering&design", "This is engineering&design description"));

        repository.save(new Employee(1L, "ramazan", "demir", 5200, 1L));

        meetingRepository.save(new Meeting(1L,"Revision","Revision Meeting Description", Arrays.asList(departmentRepository.getOne(1L),departmentRepository.getOne(2L))));

//        repository.save(new Employee(2L,"ramazan","demir",2200,2L));
//
//        repository.save(new Employee(3L,"ramazan","demir",3200,3L));
    }
}
