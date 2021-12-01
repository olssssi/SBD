package com.example.demo.klient;

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

    public Long getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Long idKlienta) {
        this.idKlienta = idKlienta;
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
}
