package com.rdemir.assginment.service;

import com.rdemir.assginment.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getDepartments();

    public Department getDepartment(Long departmentId);

    public boolean saveDepartment(Department department);

    public boolean updateDepartment(Department department);

    public boolean deleteDepartment(Long departmentId);
}
