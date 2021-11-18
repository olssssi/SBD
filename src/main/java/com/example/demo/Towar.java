package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Towar {
    @Id
    @GeneratedValue
    @Column(name = "id_towaru")
    private Long idTowaru;
    @ManyToOne
    private Producent producent;
    @ManyToOne
    private Kategoria kategoria;
    @ManyToOne
    private Cena cena;
    private int ilosc;
}

