package com.example.demo.faktura;

import com.example.demo.stanZamowienia.StanZamowienia;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import com.example.demo.zamowienie.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Service
public class FakturaService {
    private final FakturaRepository fakturaRepository;
    private final ZamowienieService zamowienieService;

    @Autowired
    public FakturaService(FakturaRepository fakturaRepository,
                          ZamowienieService zamowienieService) {
        this.fakturaRepository = fakturaRepository;
        this.zamowienieService = zamowienieService;
    }

    public Faktura findById(Long id) throws FakturaNotFoundException {
        return fakturaRepository.findById(id)
                .orElseThrow(FakturaNotFoundException::new);
    }

    public Set<Zamowienie> getZamowienia(Faktura faktura){
        return faktura.collectZamowienia();
    }

    //TODO: walidacja czy przed tym stan jest = zrealizowane
    public void registerAsPaid(Faktura faktura) throws ZamowienieNotFoundException {
        for (Zamowienie zamowienie:faktura.collectZamowienia()) {
            zamowienie.setStanZamowienia(StanZamowienia.OPLACONE);
            zamowienieService.update(zamowienie.getIdZamowienia(), zamowienie);
        }
        faktura.setDataRealizacji(OffsetDateTime.now());
        fakturaRepository.save(faktura);
    }

    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }

    public Faktura save(Faktura cena) {
        return fakturaRepository.save(cena);
    }

    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

}