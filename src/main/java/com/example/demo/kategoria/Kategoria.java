package com.example.demo.kategoria;

import com.example.demo.towar.Towar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Kategoria {
    @Id
    @GeneratedValue
    @Column(name = "id_kategorii")
    private Long idKategorii;
    private String nazwa;
    private Float stawkaVat;
    @OneToMany(mappedBy = "kategoria", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Towar> towary;

    public Kategoria(String nazwa,
                     Float stawkaVat) {
        this.nazwa = nazwa;
        this.stawkaVat = stawkaVat;
        this.towary = new HashSet<>();
    }

    public Kategoria() {
        this.towary = new HashSet<>();
    }

    public Long getIdKategorii() {
        return idKategorii;
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