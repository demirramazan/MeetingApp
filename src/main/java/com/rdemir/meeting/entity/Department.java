package com.rdemir.meeting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "DEPARTMENT_NAME", nullable = true)
    private String name;


    @Column(name = "DEPARTMENT_DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Department(Long id,String name, String description) {
        super();
        this.id=id;
        this.description=description;
        this.name = name;
    }
}
