package com.example.demo.stanowisko;

import com.example.demo.pracownik.Pracownik;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Stanowisko {
    @Id
    @GeneratedValue
    @Column(name = "id_stanowiska")
    private Long idStanowiska;
    private String nazwa;
    @OneToMany(mappedBy = "stanowisko")
    private Set<Pracownik> pracownicy;

    @PreRemove
    public void preRemove(){
        pracownicy.forEach(pracownik -> pracownik.setStanowisko(null));
    }

    public Stanowisko() {
        this.pracownicy = new HashSet<>();
    }

    public Long getIdStanowiska() {
        return idStanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Stanowisko(String nazwa) {
        this.nazwa = nazwa;
    }
}
