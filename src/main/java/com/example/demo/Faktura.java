package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Faktura {
    @Id
    @GeneratedValue
    @Column(name = "id_faktury")
    private Long idFaktury;
    @ManyToOne
    private Zamowienie zamowienie;
}