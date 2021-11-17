package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Pracownik {
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    private String telefon;
    @ManyToOne
    private Stanowisko stanowisko;
}
