package com.example.demo.pozycja;

import com.example.demo.faktura.Faktura;
import com.example.demo.faktura.FakturaRepository;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import com.example.demo.zamowienie.Zamowienie;
import com.example.demo.zamowienie.ZamowienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PozycjaService {
    private final PozycjaRepository pozycjaRepository;
    private final ZamowienieRepository zamowienieRepository;
    private final FakturaRepository fakturaRepository;

    @Autowired
    public PozycjaService(PozycjaRepository pozycjaRepository,
                          ZamowienieRepository zamowienieRepository,
                          FakturaRepository fakturaRepository) {
        this.pozycjaRepository = pozycjaRepository;
        this.zamowienieRepository = zamowienieRepository;
        this.fakturaRepository = fakturaRepository;
    }

    public Pozycja findById(Long id) throws PozycjaNotFoundException {
        return pozycjaRepository.findById(id)
                .orElseThrow(PozycjaNotFoundException::new);
    }

    public List<Pozycja> findByZamowienie(Zamowienie zamowienie) throws ZamowienieNotFoundException {
        return pozycjaRepository.findByZamowienie(zamowienie);
    }

    public List<Pozycja> findAll() {
        return pozycjaRepository.findAll();
    }

    public Pozycja save(Pozycja pozycja) {
        return pozycjaRepository.save(pozycja);
    }

    public void update(Long id, Pozycja pozycja) throws PozycjaNotFoundException {
        Pozycja pozycjaToUpdate = findById(id);
        pozycjaToUpdate.setIlosc(pozycja.getIlosc());
        pozycjaToUpdate.setTowar(pozycja.getTowar());
        pozycjaToUpdate.setIlosc(pozycja.getIlosc());

        pozycjaRepository.save(pozycjaToUpdate);
    }

    public void assignZamowienie(Long id, Zamowienie zamowienie) throws PozycjaNotFoundException {
        Pozycja pozycjaToAssign = findById(id);
        pozycjaToAssign.setZamowienie(zamowienie);

        Faktura faktura = zamowienie.getFaktura();
        if(faktura!=null){
            fakturaRepository.save(faktura);
        }
        zamowienieRepository.save(zamowienie);
        pozycjaRepository.save(pozycjaToAssign);
    }

    public void delete(Pozycja pozycja) {
        pozycjaRepository.delete(pozycja);
    }

}
