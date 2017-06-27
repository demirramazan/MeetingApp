package com.rdemir.assginment.controller;

import com.rdemir.assginment.annotation.JsonRestController;
import com.rdemir.assginment.entity.Employee;
import com.rdemir.assginment.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@JsonRestController
@RequestMapping("/employee")
@Api(value = "Employee Rest Services")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImp")
    public EmployeeService employeeServiceImp;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)

    @ApiOperation("Get employees")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Employee.class)})
    public List<Employee> getEmployes() {
        return employeeServiceImp.getEmployes();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeServiceImp.getEmployee(id);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
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
