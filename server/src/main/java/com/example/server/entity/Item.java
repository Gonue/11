package com.example.server.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "items")
public class Item {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column(length = 50, nullable = false)//똑같이
    private  String name;

    @Column(length = 200)//똑같이
    private  String img_Path;

    @Column //똑같이
    private  int price;

    @Column //똑같이
    private  int discount_Per;

    @Column(length = 50)
    private String write;



}
