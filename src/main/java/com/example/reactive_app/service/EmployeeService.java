package com.example.reactive_app.service;

import com.example.reactive_app.model.Employee;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    public CompletableFuture<List<Employee>> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee saveEmployee(Employee employee);
}
