package com.rdemir.assginment.controller;

import com.rdemir.assginment.entity.Employee;
import com.rdemir.assginment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImp")
    public EmployeeService employeeServiceImp;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployes() {
        return employeeServiceImp.getEmployes();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeServiceImp.getEmployee(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Employee> saveEmployee(@RequestBody Employee employee) {
        employeeServiceImp.saveEmployee(employee);

        return employeeServiceImp.getEmployes();
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.PUT)
    public List<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employeeServiceImp.updateEmploye(employee);
        return employeeServiceImp.getEmployes();
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public List<Employee> deleteEmployee(@PathVariable Long id){
        employeeServiceImp.deleteEmploye(id);

        return employeeServiceImp.getEmployes();
    }
}
