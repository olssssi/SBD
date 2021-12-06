package com.example.demo.cena;

import javax.persistence.*;

@Entity
@Table
public class Cena {
    public Cena(Float cena, Float stawkaVat) {
        this.cena = cena;
        this.stawkaVat = stawkaVat;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_ceny")
    private Long id;
    private Float cena;
    private Float stawkaVat;

    public Cena() {
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Float getStawkaVat() {
        return stawkaVat;
    }

    public void setStawkaVat(Float stawkaVat) {
        this.stawkaVat = stawkaVat;
    }
}
