package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Zamowienie {
    @Id
    @GeneratedValue
    @Column(name = "id_zamowienia")
    private Long idZamowienia;
    @ManyToOne
    private Klient klient;
    @ManyToOne
    private Pracownik pracownik;
    private StanZamowienia stanZamowienia;
}