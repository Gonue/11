package com.example.server.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "chet")
public class Chet {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column(length = 50, nullable = false, unique = true)//똑같이
    private  String name;

    @Column(length = 2000, nullable = false)//똑같이
    private  String send_mes;

    @Column(length = 2000, nullable = false)
    private String get_mes;

    @Column(length = 50, nullable = true)
    private String phone;

    @Column(length = 1, nullable = false)
    private String active_yn;


}
