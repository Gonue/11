package com.example.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "music")
public class Music {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 증가값
    private int id;

    @Column (length = 20)
    private  String name;

    @Column
    private  int memberId;

    @Column (length = 2000, nullable = false)
    private String file;

    @Column (length = 50)
    private  String song_name;

    @Column (length = 500)
    private String items;

}
