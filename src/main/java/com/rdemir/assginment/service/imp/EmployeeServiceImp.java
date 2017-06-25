package com.rdemir.assginment.service.imp;

import com.rdemir.assginment.entity.Employee;
import com.rdemir.assginment.repository.EmployeeRepository;
import com.rdemir.assginment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getEmployes() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return repository.findOne(id);
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        if (employee!=null){
            repository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmploye(Employee employee) {
        Employee employee1=repository.findOne(employee.getId());
        if (employee1!=null){
            employee1.setName(employee.getName());
            employee1.setSurname(employee.getSurname());
            employee1.setSalary(employee.getSalary());
            repository.save(employee1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmploye(Long empId) {
        repository.delete(empId);
        return false;
    }
}
