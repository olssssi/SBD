package com.example.demo.towar;

import com.example.demo.kategoria.Kategoria;
import com.example.demo.producent.Producent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TowarRepository extends JpaRepository<Towar, Long> {
    List<Towar> findByProducent(Producent producent);
    List<Towar> findByKategoria(Kategoria kategoria);
}