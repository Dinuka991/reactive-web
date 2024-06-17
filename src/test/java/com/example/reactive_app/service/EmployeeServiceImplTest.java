package com.example.reactive_app.service;


import com.example.reactive_app.model.Employee;
import com.example.reactive_app.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void getEmployeeByIdTest() {
        when(employeeRepository.findById(1L)).thenReturn(createEmployeeStub());

        Employee testEmp = employeeService.getEmployeeById(1L);

        assertEquals("John Doe", testEmp.getName());
        assertEquals("Software Engineer", testEmp.getRole());
    }

    private Optional<Employee> createEmployeeStub() {
        String dateTimeString = "2024-06-15T00:00:00.000+00:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        // Convert OffsetDateTime to Instant
        Instant instant = offsetDateTime.toInstant();

        // Convert Instant to java.util.Date
        Date date = Date.from(instant);

        Employee employee = Employee.builder()
                .id(1L)
                .name("John Doe")
                .role("Software Engineer")
                .contactNumber("1234567890")
                .hireDate(date)
                .build();

        return Optional.of(employee);
    }
}
