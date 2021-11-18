package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Cena {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Float cena;
    @Column
    private Float stawkaVat;
}
