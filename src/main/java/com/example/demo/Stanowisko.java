package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Stanowisko {
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
}
