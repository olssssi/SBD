package com.example.demo.kategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriaRepository extends JpaRepository<Kategoria, Long> {
}
