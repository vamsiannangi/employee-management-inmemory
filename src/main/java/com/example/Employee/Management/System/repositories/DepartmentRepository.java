package com.example.Employee.Management.System.repositories;

import com.example.Employee.Management.System.entities.Department;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentRepository {
    private final Map<String, Department> departmentDatabase = new HashMap<>();

    public void createSampleData() {
        Department department1 = new Department();
        department1.setDepartmentId("dept1");
        department1.setDepartmentName("HR");
        department1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        department1.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        Department department2 = new Department();
        department2.setDepartmentId("dept2");
        department2.setDepartmentName("IT");
        department2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        department2.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        createDepartment(department1);
        createDepartment(department2);
    }

        public Department createDepartment(Department department) {
        departmentDatabase.put(department.getDepartmentId(), department);
        return department;
    }

    public Department getDepartmentById(String id) {
        return departmentDatabase.get(id);
    }

    public List<Department> getAllDepartments() {
        return new ArrayList<>(departmentDatabase.values());
    }
    public Department updateDepartment(String id, Department updatedDepartment) {
        if (departmentDatabase.containsKey(id)) {
            Department existingDepartment = departmentDatabase.get(id);
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
            existingDepartment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            departmentDatabase.put(id, existingDepartment);
            return existingDepartment;
        }
        return null;
    }


    public boolean deleteDepartment(String id) {
        return departmentDatabase.remove(id) != null;
    }
}
