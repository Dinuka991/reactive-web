package com.example.reactive_app.service;

import com.example.reactive_app.exception.CustomDataAccessException;
import com.example.reactive_app.exception.UserNotFoundException;
import com.example.reactive_app.model.Employee;
import com.example.reactive_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Async
    public CompletableFuture<List<Employee>> getAllEmployees() {
        return CompletableFuture.supplyAsync(() -> employeeRepository.findAll());
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new CustomDataAccessException("Error saving employee", e);
        }
    }
}
