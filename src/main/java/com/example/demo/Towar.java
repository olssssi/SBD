package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Towar {
    @Id
    @GeneratedValue
    private Long idTowaru;
    private Long idProducenta;
    private Long idKategorii;
    @ManyToOne
    private Cena cena;
    private int ilosc;
}

