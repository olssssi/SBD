package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Zamowienie {
    @Id
    @GeneratedValue
    private Long idZamowienia;
    @ManyToOne
    private Klient klient;
    @ManyToOne
    private Pracownik pracownik;
    private StanZamowienia stanZamowienia;
}