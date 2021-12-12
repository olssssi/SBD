package com.example.demo.pozycja;

import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.towar.Towar;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Pozycja {
    @Id
    @GeneratedValue
    @Column(name = "nr_pozycji")
    private Long nrPozycji;
    @ManyToOne
    @JoinColumn(name = "zamowienie_id")
    @JsonIgnore
    private Zamowienie zamowienie;
    private int ilosc;
    @ManyToOne
    private Towar towar;

    public Pozycja(Zamowienie zamowienie, int ilosc, Towar towar) {
        this.zamowienie = zamowienie;
        this.ilosc = ilosc;
        this.towar = towar;
    }

    public Pozycja() {
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Towar getTowar() {
        return towar;
    }

    public void setTowar(Towar towar) {
        this.towar = towar;
    }
}