package com.example.demo.cena;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenaRepository extends JpaRepository<Cena, Long> {
}
