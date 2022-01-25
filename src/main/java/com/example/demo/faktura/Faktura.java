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
//    private OffsetDateTime maxDataRealizacji;
    private OffsetDateTime dataRealizacji;
    private float kwotaNetto;
    private float kwotaBrutto;
    private Boolean czyWszystkieZamowieniaZrealizowane = false;

//    @PreRemove
//    private void preRemove(){
//        zamowienia.forEach(zamowienie -> zamowienie.setFaktura(null));
//    }

    public Faktura() {
        this.zamowienia = new HashSet<>();
//        this.maxDataRealizacji = OffsetDateTime.now().plusDays(14);
        this.dataRealizacji = null;
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

    public Boolean getCzyWszystkieZamowieniaZrealizowane() {
        return czyWszystkieZamowieniaZrealizowane;
    }

    public void setCzyWszystkieZamowieniaZrealizowane(Boolean czyWszystkieZamowieniaOplacone) {
        this.czyWszystkieZamowieniaZrealizowane = czyWszystkieZamowieniaOplacone;
    }

    public void increaseKwota(float cenaBrutto, float cenaNetto){
        this.kwotaBrutto = kwotaBrutto + cenaBrutto;
        this.kwotaNetto = kwotaNetto + cenaNetto;
    }

    public void decreaseKwota(float cenaBrutto, float cenaNetto){
        this.kwotaBrutto = kwotaBrutto - cenaBrutto;
        this.kwotaNetto = kwotaNetto - cenaNetto;
    }

    public void setKwotaNetto(float kwotaNetto) {
        this.kwotaNetto = kwotaNetto;
    }

    public void setKwotaBrutto(float kwotaBrutto) {
        this.kwotaBrutto = kwotaBrutto;
    }

    public Set<Zamowienie> collectZamowienia(){
        return this.zamowienia;
    }

//    public OffsetDateTime getMaxDataRealizacji() {
//        return maxDataRealizacji;
//    }

    public OffsetDateTime getDataRealizacji() {
        return dataRealizacji;
    }

    public void setDataRealizacji(OffsetDateTime dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }
}