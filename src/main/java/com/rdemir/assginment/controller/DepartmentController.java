package com.rdemir.assginment.controller;

import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    @Qualifier("departmentServiceImp")
    public DepartmentService departmentServiceImp;

    @RequestMapping(value = "/departments",method = RequestMethod.GET)
    public List<Department> getDepartments(){
        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public Department getDepartment(@PathVariable Long id){
        return departmentServiceImp.getDepartment(id);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
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
