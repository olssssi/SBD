package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "pracownik")
public class Pracownik {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "telefon")
    private String telefon;
    @ManyToOne
    private Stanowisko stanowisko;


    public Pracownik(Long id, String imie, String nazwisko, String telefon) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public Pracownik() {

    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
