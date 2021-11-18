package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Pozycja {
    @Id
    @GeneratedValue
    @Column(name = "nr_pozycji")
    private Long nrPozycji;
    @ManyToOne
    private Zamowienie zamowienie;
    private int ilosc;
    @ManyToOne
    private Towar towar;
}