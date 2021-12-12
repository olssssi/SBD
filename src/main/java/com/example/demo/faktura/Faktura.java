package com.example.demo.faktura;

import com.example.demo.zamowienie.Zamowienie;

import javax.persistence.*;

@Entity
@Table
public class Faktura {
    @Id
    @GeneratedValue
    @Column(name = "id_faktury")
    private Long idFaktury;
    @ManyToOne
    private Zamowienie zamowienie;

    //TODO: trzeba dodać maksymalną datę realizacji zamówienia
    //TODO: trzeba dodać rzeczywista datę realizacji zamówienia
    //TODO: jeżeli jest już po maksymalnej dacie -> zamówienie automatycznie przechodzi w stan anulowany

    public Faktura(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Faktura() {
    }

    public Long getIdFaktury() {
        return idFaktury;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
}