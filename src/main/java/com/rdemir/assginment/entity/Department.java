package com.rdemir.assginment.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
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

    public Department(){}

    public Department(Long id,String name, String description) {
        super();
        this.id=id;
        this.description=description;
        this.name = name;
    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Department)) return false;
//
//        Department that = (Department) o;
//
//        if (!id.equals(that.id)) return false;
//        if (!name.equals(that.name)) return false;
//        return employees.equals(that.employees);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + name.hashCode();
//        result = 31 * result + employees.hashCode();
//        return result;
//    }
}
