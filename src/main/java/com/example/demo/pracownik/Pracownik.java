package com.example.demo.pracownik;

import com.example.demo.stanowisko.Stanowisko;
import com.example.demo.zamowienie.Zamowienie;

import javax.persistence.*;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stanowisko_id")
    private Stanowisko stanowisko;
    @OneToMany(mappedBy = "pracownik")
    private Set<Zamowienie> zamowienia;

    @PreRemove
    public void preRemove(){
        zamowienia.forEach(zamowienie -> zamowienie.setPracownik(null));
    }

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

    public String convert(){
        return this.idPracownika+" "+this.imie+" "+this.nazwisko;
    }
}
