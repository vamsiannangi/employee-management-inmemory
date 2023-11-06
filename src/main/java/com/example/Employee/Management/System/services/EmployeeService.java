package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.entities.Employee;
import com.example.Employee.Management.System.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
   public List<Employee> getAllEmployees() {
      employeeRepository.createSampleData();
       return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        employeeRepository.createSampleData();
        return employeeRepository.getEmployeeById(id);
    }

    public Employee createEmployee(Employee employee) {
        employeeRepository.createSampleData();
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employeeRepository.createSampleData();
        return employeeRepository.updateEmployee(id,employee);
    }

    public ResponseEntity<String> deleteEmployee(Long id) {
        employeeRepository.createSampleData();
        return employeeRepository.deleteEmployee(id);
    }

}