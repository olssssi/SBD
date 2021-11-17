package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Kategoria {
    @Id
    @GeneratedValue
    private Long idKategorii;
    private String nazwa;
}