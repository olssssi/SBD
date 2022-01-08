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
    @OneToMany(mappedBy = "faktura")
    private Set<Zamowienie> zamowienia;
    private OffsetDateTime maxDataRealizacji;
    private OffsetDateTime dataRealizacji;
    private float kwotaNetto;
    private float kwotaBrutto;

    @PreRemove
    public void preRemove(){
        zamowienia.forEach(zamowienie -> zamowienie.setFaktura(null));
    }

    //TODO: trzeba dodać maksymalną datę realizacji zamówienia
    //TODO: trzeba dodać rzeczywista datę realizacji zamówienia
    //TODO: jeżeli jest już po maksymalnej dacie -> zamówienie automatycznie przechodzi w stan anulowany

    public Faktura() {
        this.zamowienia = new HashSet<>();
    }

    public Long getIdFaktury() {
        return idFaktury;
    }

    public float getKwotaNetto() {
        return kwotaNetto;
    }

    public float getKwotaBrutto() {
        return kwotaBrutto;
    }

    public void increaseKwota(float cenaBrutto, float cenaNetto){
        this.kwotaBrutto = kwotaBrutto + cenaBrutto;
        this.kwotaNetto = kwotaNetto + cenaNetto;
    }

    public void decreaseKwota(float cenaBrutto, float cenaNetto){
        this.kwotaBrutto = kwotaBrutto - cenaBrutto;
        this.kwotaNetto = kwotaNetto - cenaNetto;
    }

}