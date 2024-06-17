package com.example.reactive_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "__employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name" , length = 50, nullable = false)
    private String name;

    @Column(name = "user_role" , length = 50, nullable = false)
    private String role;

    @Column(name = "contact_number" , length = 50)
    private String contactNumber;


    @Column(name = "hire_date" , length = 50, nullable = true)
    private Date hireDate;

}
