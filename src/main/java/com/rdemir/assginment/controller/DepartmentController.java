package com.rdemir.assginment.controller;

import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Department getDepartment(@PathVariable Long departmentId){
        return departmentServiceImp.getDepartment(departmentId);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public List<Department> addDepartment(Department department){
        departmentServiceImp.saveDepartment(department);

        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(name = "/department",method = RequestMethod.PUT)
    public List<Department> updateDepartment(Department department,@PathVariable Long id){
        departmentServiceImp.updateDepartment(department);
        return departmentServiceImp.getDepartments();
    }

    @RequestMapping(name = "/department/{id}",method = RequestMethod.DELETE)
    public List<Department> deleteDepartment(@PathVariable Long id){
        departmentServiceImp.deleteDepartment(id);

        return departmentServiceImp.getDepartments();
    }
}
