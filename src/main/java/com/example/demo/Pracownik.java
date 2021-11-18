package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Pracownik {
    @Id
    @GeneratedValue
    @Column(name = "id_pracownika")
    private Long idPracownika;
    private String imie;
    private String nazwisko;
    private String telefon;
    @ManyToOne
    private Stanowisko stanowisko;
}
