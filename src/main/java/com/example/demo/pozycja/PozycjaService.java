package com.example.demo.pozycja;

import com.example.demo.faktura.Faktura;
import com.example.demo.zamowienie.ZamowienieNotFoundException;
import com.example.demo.zamowienie.Zamowienie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PozycjaService {
    private final PozycjaRepository pozycjaRepository;

    @Autowired
    public PozycjaService(PozycjaRepository pozycjaRepository) {
        this.pozycjaRepository = pozycjaRepository;
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

        pozycjaRepository.save(pozycjaToAssign);
    }

    public void delete(Pozycja pozycja) {
        pozycjaRepository.delete(pozycja);
    }

}
