package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Pozycja {
    @Id
    @GeneratedValue
    private Long nrPozycji;

    //private Zamowienie zamowienie;
    private int ilosc;
    @ManyToOne
    private Towar towar;
}