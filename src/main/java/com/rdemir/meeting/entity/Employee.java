package com.rdemir.meeting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "EMPLOYEE_NAME", nullable = false)
    private String name;

    @Column(name = "EMPLOYEE_SURNAME", nullable = false)
    private String surname;

    @Column(name = "EMPLOYEE_SALARY")
    private int salary;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;


}
