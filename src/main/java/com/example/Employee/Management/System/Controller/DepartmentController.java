package com.example.Employee.Management.System.Controller;


import com.example.Employee.Management.System.entities.Department;
import com.example.Employee.Management.System.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable String id) {
        Department department = departmentService.getDepartmentById(id);

        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            String errorMessage = "Department with ID " + id + " not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return updatedDepartment != null ? ResponseEntity.ok(updatedDepartment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Department with ID " + id + " deleted successfully", HttpStatus.OK);

    }
}

