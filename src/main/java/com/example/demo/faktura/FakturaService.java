package com.example.demo.faktura;

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

    public Faktura save(Faktura cena) {
        return fakturaRepository.save(cena);
    }

    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

}