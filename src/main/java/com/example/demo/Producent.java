package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Producent {
    @Id
    @GeneratedValue
    private Long idPracownika;
    @Column
    private String nazwa;
}