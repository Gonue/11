package com.example.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column
    private  int memberId;

    @Column (length = 50, nullable = false)
    private  String name;

    @Column (length = 50, nullable = false)
    private  String address;

    @Column (length = 10, nullable = false)
    private  String payment;

    @Column (length = 16)
    private  String cardNumber;

    @Column (length = 500, nullable = false)
    private  String items;
}
