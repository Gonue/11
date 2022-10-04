package com.example.server.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column
    private  int memberId;

    @Column
    private  int itemId;

}
