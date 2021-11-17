package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Faktura {
    @Id
    @GeneratedValue
    private Long idFaktury;

    @ManyToOne
    private Zamowienie zamowienia;
}