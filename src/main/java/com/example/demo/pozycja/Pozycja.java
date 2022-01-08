package com.example.demo.pozycja;

import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.towar.Towar;

import javax.persistence.*;

@Entity
@Table
public class Pozycja {
    @Id
    @GeneratedValue
    @Column(name = "nr_pozycji")
    private Long nrPozycji;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zamowienie_id")
    private Zamowienie zamowienie;
    private int ilosc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "towar_id")
    private Towar towar;

    @PreRemove
    public void preRemove(){
        if(zamowienie!=null){
            zamowienie.decreaseKwota(ilosc*towar.getCenaBrutto(), ilosc*towar.getCenaNetto());
        }
    }

    public Pozycja(int ilosc, Towar towar) {
        this.zamowienie = null;
        this.ilosc = ilosc;
        this.towar = towar;
    }

    public Pozycja() {
    }

    public Long getNrPozycji() {
        return nrPozycji;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        zamowienie.increaseKwota(ilosc*towar.getCenaBrutto(), ilosc*towar.getCenaNetto());
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