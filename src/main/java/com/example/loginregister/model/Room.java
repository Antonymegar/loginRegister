package com.example.loginregister.model;

import javax.persistence.*;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private String  room_name;
    private String block;
    private Integer capacity;


}
