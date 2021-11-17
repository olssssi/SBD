package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Producent {
    @Id
    @GeneratedValue
    private Long idPracownika;
    private String nazwa;
}