package com.example.server.entity;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity
@Table(name = "members")
public class Member {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column(length = 50, nullable = false, unique = true)//똑같이
    private  String email;

    @Column(length = 100, nullable = false)//똑같이
    private  String password;

    @Column(length = 50, nullable = false)
    private String name;

}