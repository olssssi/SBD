package com.example.demo.towar;

import com.example.demo.kategoria.Kategoria;
import com.example.demo.pozycja.Pozycja;
import com.example.demo.producent.Producent;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Towar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_towaru")
    private Long idTowaru;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producent_id")
    private Producent producent;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kategoria_id")
    private Kategoria kategoria;
    private String nazwa;
    private Float cenaNetto;
    private Float cenaBrutto;
    private int ilosc;
    @OneToMany(mappedBy = "towar", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Pozycja> pozycje;

    public Towar() {
        this.pozycje = new HashSet<>();
    }

    public Towar(String nazwa, Producent producent, Kategoria kategoria, Float cenaNetto, int ilosc) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.kategoria = kategoria;
        this.cenaNetto = cenaNetto;
        this.ilosc = ilosc;
        Float podatek = this.cenaNetto*this.kategoria.getStawkaVat()/100;
        this.cenaBrutto = this.cenaNetto+podatek;
        this.pozycje = new HashSet<>();
    }

    public Long getIdTowaru() {
        return idTowaru;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Float getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(Float cena) {
        this.cenaNetto = cena;
        Float podatek = this.cenaNetto*this.kategoria.getStawkaVat()/100;
        this.cenaBrutto = this.cenaNetto+podatek;
    }

    public Float getCenaBrutto() {
        return cenaBrutto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}

