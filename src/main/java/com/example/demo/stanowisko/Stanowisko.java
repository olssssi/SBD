package com.example.demo.stanowisko;

import javax.persistence.*;

@Entity
@Table
public class Stanowisko {
    @Id
    @GeneratedValue
    @Column(name = "id_stanowiska")
    private Long idStanowiska;
    private String nazwa;

    public Stanowisko() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Stanowisko(String nazwa) {
        this.nazwa = nazwa;
    }
}
