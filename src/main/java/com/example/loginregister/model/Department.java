package com.example.loginregister.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
       @Id
       @Enumerated(EnumType.STRING)
        private DepartmentCategory category;

    @ManyToOne
    @JoinColumn(name = "fk_organization")
    private Organization organization;

    @OneToMany
    @JoinColumn(name="fk_department")
    private List<Employee> Employees= new ArrayList<Employee>();

}
