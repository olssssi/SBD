package com.example.demo;

import com.example.demo.klient.Klient;
import com.example.demo.pracownik.Pracownik;

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