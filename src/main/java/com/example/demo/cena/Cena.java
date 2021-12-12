package com.example.demo.cena;

import com.example.demo.towar.Towar;

import javax.persistence.*;

@Entity
@Table
public class Cena {
    @Id
//    @GeneratedValue
//    @Column(name = "id_ceny")
    @Column(name = "id_towaru")
    private Long id;
    private Float cena;
    private Float stawkaVat;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "towar_id", referencedColumnName = "id_towaru")
    @OneToOne
    @MapsId
    @JoinColumn(name="id_towaru")
    private Towar towar;

    public Cena(Float cena, Float stawkaVat, Towar towar) {
        this.cena = cena;
        this.stawkaVat = stawkaVat;
        this.towar = towar;
    }

    public Cena() {
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Float getStawkaVat() {
        return stawkaVat;
    }

    public void setStawkaVat(Float stawkaVat) {
        this.stawkaVat = stawkaVat;
    }
}
