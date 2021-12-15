package com.example.demo.faktura;

import com.example.demo.zamowienie.Zamowienie;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Faktura {
    @Id
    @GeneratedValue
    @Column(name = "id_faktury")
    private Long idFaktury;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faktura")
    private Set<Zamowienie> zamowienia;
    private OffsetDateTime maxDataRealizacji;
    private OffsetDateTime dataRealizacji;

    //TODO: trzeba dodać maksymalną datę realizacji zamówienia
    //TODO: trzeba dodać rzeczywista datę realizacji zamówienia
    //TODO: jeżeli jest już po maksymalnej dacie -> zamówienie automatycznie przechodzi w stan anulowany


//    public Faktura(Set<Zamowienie> zamowienia) {
//        this.zamowienia = zamowienia;
//    }

    public Faktura() {
        this.zamowienia = new HashSet<>();
    }

    public Long getIdFaktury() {
        return idFaktury;
    }

    public Set<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Set<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
}