package com.example.demo.towar;

import com.example.demo.kategoria.Kategoria;
import com.example.demo.cena.Cena;
import com.example.demo.producent.Producent;

import javax.persistence.*;

@Entity
@Table
public class Towar {
    @Id
    @GeneratedValue
    @Column(name = "id_towaru")
    private Long idTowaru;
    @ManyToOne
    private Producent producent;
    @ManyToOne
    private Kategoria kategoria;
    @ManyToOne
    private Cena cena;
    private int ilosc;

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

