package com.example.demo.rabat;

import javax.persistence.*;

@Entity
@Table
public class Rabat {
    @Id
    @GeneratedValue
    @Column(name = "id_rabatu")
    private Long idRabatu;
    private String nazwa;
    private Float procentRabatu;

    public Rabat(String nazwa,
                 Float procentRabatu) {
        this.nazwa = nazwa;
        this.procentRabatu = procentRabatu;
    }

    public Rabat() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getProcentRabatu() {
        return procentRabatu;
    }

    public void setProcentRabatu(Float procentRabatu) {
        this.procentRabatu = procentRabatu;
    }
}