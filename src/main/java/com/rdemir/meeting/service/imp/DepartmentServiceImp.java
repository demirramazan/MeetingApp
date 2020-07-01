package com.rdemir.meeting.service.imp;

import com.rdemir.meeting.entity.Department;
import com.rdemir.meeting.repository.DepartmentRepository;
import com.rdemir.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService {

    public final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) {
        return  departmentRepository.findById(departmentId).orElse(null);
    }


    @Override
    public boolean saveDepartment(Department department) {
        if (department != null) {
            departmentRepository.save(department);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        Department department1 = (Department) departmentRepository.findById(department.getId()).orElse(null);
        if (department1 != null) {
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
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null) {
            departmentRepository.delete(department);
        }
        return false;
    }
}
