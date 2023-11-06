package com.example.Employee.Management.System.services;


import com.example.Employee.Management.System.entities.Department;
import com.example.Employee.Management.System.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DepartmentService {
        private final DepartmentRepository departmentRepository;

  @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
        public List<Department> getAllDepartments() {
           departmentRepository.createSampleData();
        return departmentRepository.getAllDepartments();
    }
    public Department createDepartment(Department department) {
        department.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        department.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return departmentRepository.createDepartment(department);
    }
    public Department getDepartmentById(String id) {
        departmentRepository.createSampleData();
        Department department = departmentRepository.getDepartmentById(id);
        return department;
    }

    public Department updateDepartment(String id, Department departmentDetails) {
        departmentRepository.createSampleData();
        Department department = departmentRepository.updateDepartment(id,departmentDetails);
         return department;
    }

    public void deleteDepartment(String id) {
        departmentRepository.createSampleData();
        departmentRepository.deleteDepartment(id);
    }

}