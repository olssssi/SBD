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
    private Float stawkaVat;

    public Kategoria(String nazwa,
                     Float stawkaVat) {
        this.nazwa = nazwa;
        this.stawkaVat = stawkaVat;
    }

    public Kategoria() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getStawkaVat() {
        return stawkaVat;
    }

    public void setStawkaVat(Float stawkaVat) {
        this.stawkaVat = stawkaVat;
    }
}