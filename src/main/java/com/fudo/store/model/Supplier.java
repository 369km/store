package com.fudo.store.model;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "weichat")
    private String weichat;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
}
