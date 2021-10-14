package com.example.loginregister.model;

import javax.persistence.*;

@Entity
@Table
public class Organization {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer Id;
    @Column(nullable=false, length = 64)
    private String org_name;

}
