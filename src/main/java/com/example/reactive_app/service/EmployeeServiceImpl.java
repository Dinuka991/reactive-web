package com.example.reactive_app.service;

import com.example.reactive_app.model.Employee;
import com.example.reactive_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Async
    public CompletableFuture<List<Employee>> getAllEmployees() {
        return CompletableFuture.completedFuture(employeeRepository.findAll());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
         employeeRepository.deleteById(id);
    }



    @Override
    public Optional<List<Employee>> getEmployeeByName(String name) {
        return  employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByRole(String role) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByContactNumber(String contactNumber) {
        return List.of();
    }


    @Override
    public List<Employee> getEmployeeByHireDate(Date hireDate) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateBetween(Date hireDate1, Date hireDate2) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateBefore(Date hireDate) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateAfter(Date hireDate) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateIsNull() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateIsNotNull() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAsc(Date hireDate) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDesc(Date hireDate) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAsc() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDesc() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameDesc(Date hireDate, String name) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameAsc(Date hireDate, String name) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAsc(Date hireDate, String name) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDesc(Date hireDate, String name) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAscAndRoleDesc(Date hireDate, String name, String role) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDescAndRoleAsc(Date hireDate, String name, String role) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAscAndRoleAsc(Date hireDate, String name, String role) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDescAndRoleDesc(Date hireDate, String name, String role) {
        return List.of();
    }
}
