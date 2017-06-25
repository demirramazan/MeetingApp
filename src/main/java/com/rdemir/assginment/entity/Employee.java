package com.rdemir.assginment.entity;

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

//
//    public Employee() {
//
//    }
//
//
//    public Employee(Long id,String name, String surname, int salary,Long departmentId) {
//        this.id=id;
//        this.name = name;
//        this.surname = surname;
//        this.salary = salary;
//        this.departmentId=departmentId;
//    }
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
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//
//        Employee employee = (Employee) o;
//
//        if (salary != employee.salary) return false;
//        if (!id.equals(employee.id)) return false;
//        if (!name.equals(employee.name)) return false;
//        return surname.equals(employee.surname);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + name.hashCode();
//        result = 31 * result + surname.hashCode();
//        result = 31 * result + salary;
//        return result;
//    }
}
