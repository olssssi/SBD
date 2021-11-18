package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Producent {
    @Id
    @GeneratedValue
    @Column(name = "id_producenta")
    private Long idProducenta;
    @Column
    private String nazwa;
}