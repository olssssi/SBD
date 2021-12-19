package com.example.demo.pracownik;

import com.example.demo.stanowisko.Stanowisko;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Pracownik {
    @Id
    @GeneratedValue
    @Column(name = "id_pracownika")
    private Long idPracownika;
    private String imie;
    private String nazwisko;
    private String telefon;
    @ManyToOne
    @JoinColumn(name = "stanowisko_id")
    @JsonIgnore
    private Stanowisko stanowisko;

    public Pracownik(String imie, String nazwisko, String telefon, Stanowisko stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.stanowisko = stanowisko;
    }

    public Pracownik() {
    }

    public Long getIdPracownika() {
        return idPracownika;
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

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }
}
