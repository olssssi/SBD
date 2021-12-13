package com.example.demo.pozycja;

import com.example.demo.zamowienie.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PozycjaRepository extends JpaRepository<Pozycja, Long> {
    List<Pozycja> findByZamowienie(Zamowienie zamowienie);
}
