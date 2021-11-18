package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Cena {
    @Id
    @GeneratedValue
    @Column(name = "id_ceny")
    private Long id;
    @Column
    private Float cena;
    @Column
    private Float stawkaVat;
}
