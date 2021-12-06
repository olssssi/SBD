package com.example.demo.producent;

import javax.persistence.*;

@Entity
@Table
public class Producent {
    @Id
    @GeneratedValue
    @Column(name = "id_producenta")
    private Long idProducenta;
    private String nazwa;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}