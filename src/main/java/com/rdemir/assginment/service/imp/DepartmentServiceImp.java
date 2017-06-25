package com.rdemir.assginment.service.imp;

import com.rdemir.assginment.entity.Department;
import com.rdemir.assginment.repository.DepartmentRepository;
import com.rdemir.assginment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) {
        return departmentRepository.findOne(departmentId);
    }


    @Override
    public boolean saveDepartment(Department department) {
        if (department!=null){
            departmentRepository.save(department);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        Department department1=departmentRepository.findOne(department.getId());
        if (department1!=null){
            department1.setName(department.getName());
            department1.setDescription(department.getDescription());
            department1.setEmployees(department.getEmployees());
            departmentRepository.save(department1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(Long departmentId) {
        Department department=departmentRepository.findOne(departmentId);
        if (department!=null){
            departmentRepository.delete(departmentId);
        }
        return false;
    }
}
