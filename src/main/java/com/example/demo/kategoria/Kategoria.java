package com.example.demo.kategoria;

import javax.persistence.*;

@Entity
@Table
public class Kategoria {
    @Id
    @GeneratedValue
    @Column(name = "id_kategorii")
    private Long idKategorii;
    private String nazwa;

    public Kategoria(String nazwa) {
        this.nazwa = nazwa;
    }

    public Kategoria() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}