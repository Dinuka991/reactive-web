package com.example.reactive_app.repository;

import com.example.reactive_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findByNameAndContactNumber(String name, String contactNumber);
    Optional<List<Employee>> findByName(String name);
    Optional<List<Employee>> findByRoleAndContactNumber(String role , String contactNumber);
    Optional<List<Employee>> findByRoleOrContactNumber(String role , String contactNumber);

}
