package com.example.demo.zamowienie;

import com.example.demo.faktura.Faktura;
import com.example.demo.klient.Klient;
import com.example.demo.pozycja.Pozycja;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.stanZamowienia.StanZamowienia;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Zamowienie {
    @Id
    @GeneratedValue
    @Column(name = "id_zamowienia")
    private Long idZamowienia;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "klient_id")
    private Klient klient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;
    private StanZamowienia stanZamowienia;
    @OneToMany(mappedBy = "zamowienie", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Pozycja> pozycje = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faktura_id")
    private Faktura faktura;

    //TODO: jezeli zamowienie jest puste, to trzeba je usunac
    public Zamowienie(Klient klient, Pracownik pracownik) {
        this.klient = klient;
        this.pracownik = pracownik;
        this.stanZamowienia = StanZamowienia.DO_REALIZACJI;
    }

    public Zamowienie() {
        this.stanZamowienia = StanZamowienia.DO_REALIZACJI;
    }

    public Long getIdZamowienia() {
        return idZamowienia;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public StanZamowienia getStanZamowienia() {
        return stanZamowienia;
    }

    public void setStanZamowienia(StanZamowienia stanZamowienia) {
        this.stanZamowienia = stanZamowienia;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}