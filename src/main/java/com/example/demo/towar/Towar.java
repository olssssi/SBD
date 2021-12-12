package com.example.demo.towar;

import com.example.demo.kategoria.Kategoria;
import com.example.demo.cena.Cena;
import com.example.demo.producent.Producent;

import javax.persistence.*;

@Entity
@Table
public class Towar {
    public Towar() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_towaru")
    private Long idTowaru;
    @ManyToOne
    private Producent producent;
    @ManyToOne
    private Kategoria kategoria;
    @OneToOne(mappedBy = "towar", cascade = CascadeType.ALL)
    private Cena cena;
    private int ilosc;

    public Towar(Producent producent, Kategoria kategoria, int ilosc) {
        this.producent = producent;
        this.kategoria = kategoria;
        this.ilosc = ilosc;
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

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}

