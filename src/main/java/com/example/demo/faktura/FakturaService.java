package com.example.demo.faktura;

import com.example.demo.exceptions.FakturaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakturaService {
    private final FakturaRepository fakturaRepository;

    @Autowired
    public FakturaService(FakturaRepository fakturaRepository) {
        this.fakturaRepository = fakturaRepository;
    }

    public Faktura findById(Long id) throws FakturaNotFoundException {
        return fakturaRepository.findById(id)
                .orElseThrow(FakturaNotFoundException::new);
    }

    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }

    public void save(Faktura cena) {
        fakturaRepository.save(cena);
    }

    public void update(Long id, Faktura faktura) throws FakturaNotFoundException {
        Faktura fakturaToUpdate = findById(id);
        fakturaToUpdate.setZamowienie(faktura.getZamowienie());

        fakturaRepository.save(fakturaToUpdate);
    }

    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

}