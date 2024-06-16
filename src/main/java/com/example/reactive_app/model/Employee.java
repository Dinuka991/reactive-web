package com.example.reactive_app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "__employee")
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
