package com.example.demo.zamowienie;

import com.example.demo.klient.Klient;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.stanZamowienia.StanZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Long> {
    List<Zamowienie> findByKlient(Klient klient);
    List<Zamowienie> findByPracownik(Pracownik pracownik);
}
