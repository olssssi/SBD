package com.example.demo.cena;

import com.example.demo.exceptions.CenaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenaService {
    private final CenaRepository cenaRepository;

    @Autowired
    public CenaService(CenaRepository cenaRepository) {
        this.cenaRepository = cenaRepository;
    }

    public Cena findById(Long id) throws CenaNotFoundException {
        return cenaRepository.findById(id)
                .orElseThrow(CenaNotFoundException::new);
    }

    public List<Cena> findAll() {
        return cenaRepository.findAll();
    }

    public void save(Cena cena) {
        cenaRepository.save(cena);
    }

    public void update(Long id, Cena cena) throws CenaNotFoundException {
        Cena cenaToUpdate = findById(id);
        cenaToUpdate.setCena(cena.getCena());
        cenaToUpdate.setStawkaVat(cena.getStawkaVat());

        cenaRepository.save(cenaToUpdate);
    }

    public void delete(Cena cena) {
        cenaRepository.delete(cena);
    }

}