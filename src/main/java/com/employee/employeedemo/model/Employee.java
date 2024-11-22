package com.employee.employeedemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    private long userId;
    @Column(name = "user_name",nullable = false)
    private String userName;
}
