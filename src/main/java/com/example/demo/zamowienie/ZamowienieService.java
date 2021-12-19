package com.example.demo.zamowienie;

import com.example.demo.faktura.Faktura;
import com.example.demo.klient.Klient;
import com.example.demo.pracownik.Pracownik;
import com.example.demo.stanZamowienia.StanZamowienia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZamowienieService {
    private final ZamowienieRepository zamowienieRepository;

    @Autowired
    public ZamowienieService(ZamowienieRepository zamowienieRepository) {
        this.zamowienieRepository = zamowienieRepository;
    }

    public Zamowienie findById(Long id) throws ZamowienieNotFoundException {
        return zamowienieRepository.findById(id)
                .orElseThrow(ZamowienieNotFoundException::new);
    }

    public List<Zamowienie> findAll() {
        return zamowienieRepository.findAll();
    }
    public List<Zamowienie> findByKlient(Klient klient) {
        return zamowienieRepository.findByKlient(klient);
    }
    public List<Zamowienie> findByPracownik(Pracownik pracownik) {
        return zamowienieRepository.findByPracownik(pracownik);
    }

    public void save(Zamowienie zamowienie) {
        zamowienieRepository.save(zamowienie);
    }

    public void updateStan(Long id, StanZamowienia stanZamowienia) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToUpdate = findById(id);
        zamowienieToUpdate.setStanZamowienia(stanZamowienia);

        zamowienieRepository.save(zamowienieToUpdate);
    }

    public void assignFaktura(Long id, Faktura faktura) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToAssign = findById(id);
        zamowienieToAssign.setFaktura(faktura);

        zamowienieRepository.save(zamowienieToAssign);
    }

    public void delete(Zamowienie zamowienie) {
        zamowienieRepository.delete(zamowienie);
    }

}