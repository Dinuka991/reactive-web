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

    public Employee updateEmployee(Long id, Employee employee);

    public void deleteEmployee(Long id);

    public Optional<List<Employee>> getEmployeeByName(String name);

    public List<Employee> getEmployeeByRole(String role);

    public List<Employee> getEmployeeByContactNumber(String contactNumber);

    public List<Employee> getEmployeeByHireDate(Date hireDate);

    public List<Employee> getEmployeeByHireDateBetween(Date hireDate1, Date hireDate2);

    public List<Employee> getEmployeeByHireDateBefore(Date hireDate);

    public List<Employee> getEmployeeByHireDateAfter(Date hireDate);

    public List<Employee> getEmployeeByHireDateIsNull();

    public List<Employee> getEmployeeByHireDateIsNotNull();

    public List<Employee> getEmployeeByHireDateOrderByHireDateAsc(Date hireDate);

    public List<Employee> getEmployeeByHireDateOrderByHireDateDesc(Date hireDate);

    public List<Employee> getEmployeeByHireDateOrderByHireDateAsc();

    public List<Employee> getEmployeeByHireDateOrderByHireDateDesc();

    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameDesc(Date hireDate, String name);

    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameAsc(Date hireDate, String name);

    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAsc(Date hireDate, String name);

    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDesc(Date hireDate, String name);

    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAscAndRoleDesc(Date hireDate, String name, String role);

    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDescAndRoleAsc(Date hireDate, String name, String role);

    public List<Employee> getEmployeeByHireDateOrderByHireDateAscAndNameAscAndRoleAsc(Date hireDate, String name, String role);

    public List<Employee> getEmployeeByHireDateOrderByHireDateDescAndNameDescAndRoleDesc(Date hireDate, String name, String role);
}
