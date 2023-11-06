package com.example.Employee.Management.System.repositories;

import com.example.Employee.Management.System.entities.Department;
import com.example.Employee.Management.System.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeRepository {
    private final Map<Long, Employee> employeeDatabase = new HashMap<>();
    private Long nextEmployeeId = 1L;
    public void createSampleData() {
    Employee employee1 = new Employee();
        employee1.setFirstName("rohith");
        employee1.setLastName("mishra");
        employee1.setEmail("rohith@example.com");
        employee1.setDepartmentId("dept1");
        employee1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        employee1.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

    Employee employee2 = new Employee();
        employee2.setFirstName("krish");
        employee2.setLastName("sai");
        employee2.setEmail("krish@example.com");
        employee2.setDepartmentId("dept2");
        employee2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        employee2.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

       createEmployee(employee1);
       createEmployee(employee2);
}

    public Employee createEmployee(Employee employee) {
        Long employeeId = nextEmployeeId++;
        employee.setId(employeeId);
        employeeDatabase.put(employeeId, employee);
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        return employeeDatabase.get(id);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeDatabase.values());
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        if (employeeDatabase.containsKey(id)) {
            Employee existingEmployee = employeeDatabase.get(id);
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            employeeDatabase.put(id, existingEmployee);
            return existingEmployee;
        }
        return null;
    }


    public ResponseEntity<String> deleteEmployee(Long id) {
        if (employeeDatabase.containsKey(id)) {
            employeeDatabase.remove(id);
            return new ResponseEntity<>("Employee with ID " + id + " has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

}
