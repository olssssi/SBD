package com.example.demo.producent;

import com.example.demo.klient.Klient;
import com.example.demo.towar.Towar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Producent {
    @Id
    @GeneratedValue
    @Column(name = "id_producenta")
    private Long idProducenta;
    private String nazwa;
    @OneToMany(mappedBy = "producent", cascade = CascadeType.ALL)
    private Set<Towar> towary;

    public Producent(String nazwa) {
        this.nazwa = nazwa;
        this.towary = new HashSet<>();
    }

    public Producent() {
        this.towary = new HashSet<>();
    }

    public Long getIdProducenta() {
        return idProducenta;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Set<Towar> getTowary() {
        return towary;
    }

    public void setTowary(Set<Towar> towary) {
        this.towary = towary;
    }
}