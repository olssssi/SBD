package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Cena {
    @Id
    @GeneratedValue
    private Long id;
    private Float cena;
    private Float stawkaVat;
}
