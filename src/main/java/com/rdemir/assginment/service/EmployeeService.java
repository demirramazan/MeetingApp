package com.rdemir.assginment.service;

import com.rdemir.assginment.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployes();

    public Employee getEmployee(Long id);

    public boolean saveEmployee(Employee employee);

    public boolean updateEmploye(Employee employee);

    public boolean deleteEmploye(Long empId);

}
