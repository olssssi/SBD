package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Kategoria {
    @Id
    @GeneratedValue
    @Column(name = "id_kategorii")
    private Long idKategorii;
    private String nazwa;
}