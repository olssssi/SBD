package com.example.demo;

import javax.persistence.*;

@Entity
@Table
public class Stanowisko {
    @Id
    @GeneratedValue
    @Column(name = "id_stanowiska")
    private Long idStanowiska;
    private String nazwa;
}
