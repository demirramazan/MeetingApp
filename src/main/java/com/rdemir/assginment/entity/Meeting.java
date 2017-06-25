package com.rdemir.assginment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Meeting implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID",unique = true,nullable = false)
    private Long id;

    @Column(name = "MEETING_NAME",nullable = false)
    private String name;

    @Column(name = "MEETING_DESCRIPTION")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTMENT_MEETING",joinColumns = {@JoinColumn(name = "MEETING_ID")},inverseJoinColumns = {@JoinColumn(name = "DEPARTMENT_ID")})
    private List<Department> departments;
}
