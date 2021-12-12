package com.example.demo.towar;

import com.example.demo.kategoria.Kategoria;
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
    private Float cenaNetto;
//    private Float cenaBrutto;
    private int ilosc;

    public Towar(Producent producent, Kategoria kategoria, Float cenaNetto, int ilosc) {
        this.producent = producent;
        this.kategoria = kategoria;
        this.cenaNetto = cenaNetto;
        this.ilosc = ilosc;
//        Float podatek = this.cenaNetto*this.kategoria.getStawkaVat();
//        this.cenaBrutto = this.cenaNetto+podatek;
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
//        Float podatek = this.cenaNetto*this.kategoria.getStawkaVat();
//        this.cenaBrutto = this.cenaNetto+podatek;
    }
}

