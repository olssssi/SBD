package com.example.demo.rabat;

import com.example.demo.klient.Klient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Rabat {
    @Id
    @GeneratedValue
    @Column(name = "id_rabatu")
    private Long idRabatu;
    private String nazwa;
    private Float procentRabatu;
    @OneToMany(mappedBy = "rabat")
    private Set<Klient> klienci;

    @PreRemove
    public void preRemove(){
        klienci.forEach(klient -> klient.setRabat(null));
    }

    public Rabat(String nazwa,
                 Float procentRabatu) {
        this.nazwa = nazwa;
        this.procentRabatu = procentRabatu;
        this.klienci = new HashSet<>();
    }

    public Rabat() {
        this.klienci = new HashSet<>();
    }

    public Long getIdRabatu() {
        return idRabatu;
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