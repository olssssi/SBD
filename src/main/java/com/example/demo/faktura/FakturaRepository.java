package com.example.demo.faktura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Long> {
}