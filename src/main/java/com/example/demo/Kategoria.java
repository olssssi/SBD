package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Kategoria {
    @Id
    @GeneratedValue
    private Long idKategorii;
    @Column
    private String nazwa;
}