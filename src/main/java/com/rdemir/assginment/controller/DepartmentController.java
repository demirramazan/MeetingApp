package com.rdemir.assginment.controller;

import com.rdemir.assginment.annotation.JsonRestController;
import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.service.DepartmentService;
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
@Api(value = "Department Rest Services")
public class DepartmentController {

    @Autowired
    @Qualifier("departmentServiceImp")
    public DepartmentService departmentServiceImp;

    @RequestMapping(value = "/departments",method = RequestMethod.GET)
    @ApiOperation("Get all departments")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = Department.class)})
    public List<Department> getDepartments(){
        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)

    @ApiOperation("with departmentId get one department")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = Department.class)})
    public Department getDepartment(@PathVariable Long id){
        return departmentServiceImp.getDepartment(id);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ApiOperation("add department")
    public List<Department> addDepartment(@RequestBody Department department){
        departmentServiceImp.saveDepartment(department);

        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(path = "/department",method = RequestMethod.PUT)
    public List<Department> updateDepartment(@RequestBody Department department){
        departmentServiceImp.updateDepartment(department);
        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(path = "/department/{id}",method = RequestMethod.DELETE)
    public List<Department> deleteDepartment(@PathVariable Long id){
        departmentServiceImp.deleteDepartment(id);

        return departmentServiceImp.getDepartments();
    }
}
