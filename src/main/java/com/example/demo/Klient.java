package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Klient {
    @Id
    @GeneratedValue
    @Column(name = "id_klienta")
    private Long idKlienta;
    private String imie;
    private String nazwisko;
    private String telefon;
}
