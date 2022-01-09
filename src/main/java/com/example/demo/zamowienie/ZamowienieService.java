package com.example.demo.zamowienie;

import com.example.demo.faktura.Faktura;
import com.example.demo.faktura.FakturaRepository;
import com.example.demo.klient.Klient;
import com.example.demo.pracownik.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZamowienieService {
    private final ZamowienieRepository zamowienieRepository;
    private final FakturaRepository fakturaRepository;

    @Autowired
    public ZamowienieService(ZamowienieRepository zamowienieRepository,
                             FakturaRepository fakturaRepository) {
        this.zamowienieRepository = zamowienieRepository;
        this.fakturaRepository = fakturaRepository;
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

    public Zamowienie save(Zamowienie zamowienie) {
        zamowienieRepository.save(zamowienie);
        return zamowienie;
    }

    public void update(Long id, Zamowienie zamowienie) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToUpdate = findById(id);
        zamowienieToUpdate.setStanZamowienia(zamowienie.getStanZamowienia());
        zamowienieToUpdate.setKlient(zamowienie.getKlient());
        zamowienieToUpdate.setPracownik(zamowienie.getPracownik());

        zamowienieRepository.save(zamowienieToUpdate);
    }

    public void assignFaktura(Long id, Faktura faktura) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToAssign = findById(id);
        zamowienieToAssign.setFaktura(faktura);

        zamowienieRepository.save(zamowienieToAssign);
        fakturaRepository.save(faktura);

    }

    public void delete(Zamowienie zamowienie) {
        zamowienieRepository.delete(zamowienie);
    }

}