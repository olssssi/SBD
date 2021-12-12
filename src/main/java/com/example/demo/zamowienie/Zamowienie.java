package com.example.demo.zamowienie;

import com.example.demo.klient.Klient;
import com.example.demo.pozycja.Pozycja;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.stanZamowienia.StanZamowienia;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Zamowienie {
    @Id
    @GeneratedValue
    @Column(name = "id_zamowienia")
    private Long idZamowienia;
    @ManyToOne
    private Klient klient;
    @ManyToOne
    private Pracownik pracownik;
    private StanZamowienia stanZamowienia;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "zamowienie")
    private Set<Pozycja> pozycje;

    public Zamowienie(Klient klient, Pracownik pracownik) {
        this.klient = klient;
        this.pracownik = pracownik;
        this.stanZamowienia = StanZamowienia.DO_REALIZACJI;
        this.pozycje=null;
    }

    public Zamowienie() {
    }

//    public void addPozycja(Pozycja pozycja){
//        pozycje.add(pozycja);
//    }

    public Set<Pozycja> getPozycje() {
        return pozycje;
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
}