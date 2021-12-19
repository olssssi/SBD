package com.example.demo.klient;

import com.example.demo.rabat.Rabat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
public class Klient {
    @Id
    @GeneratedValue
    @Column(name = "id_klienta")
    private Long idKlienta;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;
    private String nazwaFirmy;
    private String NIP;
    private String ulica;
    private String nrLokalu;
    private String miejscowosc;
    private String kodPocztowy;
    private String kraj;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rabat_id")
    @JsonIgnore
    private Rabat rabat;

    public Klient(String imie,
                  String nazwisko,
                  String telefon,
                  String email,
                  String nazwaFirmy,
                  String NIP,
                  String ulica,
                  String nrLokalu,
                  String miejscowosc,
                  String kodPocztowy,
                  String kraj) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.nazwaFirmy = nazwaFirmy;
        this.NIP = NIP;
        this.ulica = ulica;
        this.nrLokalu = nrLokalu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.kraj = kraj;
        this.rabat = null;
    }

//    public Klient(String imie,
//                  String nazwisko,
//                  String telefon,
//                  String email,
//                  String nazwaFirmy,
//                  String NIP,
//                  String ulica,
//                  String nrLokalu,
//                  String miejscowosc,
//                  String kodPocztowy,
//                  String kraj,
//                  Rabat rabat) {
//        this.imie = imie;
//        this.nazwisko = nazwisko;
//        this.telefon = telefon;
//        this.email = email;
//        this.nazwaFirmy = nazwaFirmy;
//        this.NIP = NIP;
//        this.ulica = ulica;
//        this.nrLokalu = nrLokalu;
//        this.miejscowosc = miejscowosc;
//        this.kodPocztowy = kodPocztowy;
//        this.kraj = kraj;
//        this.rabat = rabat;
//    }

    public Klient() {
    }

    public Long getIdKlienta() {
        return idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Rabat getRabat() {
        return rabat;
    }

    public void setRabat(Rabat rabat) {
        this.rabat = rabat;
    }
}
