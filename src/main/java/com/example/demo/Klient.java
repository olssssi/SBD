package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Klient {
    @Id
    @GeneratedValue
    private Long idKlienta;
}
