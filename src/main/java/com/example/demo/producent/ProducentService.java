package com.example.demo.producent;

import com.example.demo.exceptions.ProducentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducentService {
    private final ProducentRepository producentRepository;

    @Autowired
    public ProducentService(ProducentRepository producentRepository) {
        this.producentRepository = producentRepository;
    }

    public Producent findById(Long id) throws ProducentNotFoundException {
        return producentRepository.findById(id)
                .orElseThrow(ProducentNotFoundException::new);
    }

    public List<Producent> findAll() {
        return producentRepository.findAll();
    }

    public void save(Producent producent) {
        producentRepository.save(producent);
    }

    public void update(Long id, Producent producent) throws ProducentNotFoundException {
        Producent producentToUpdate = findById(id);
        producentToUpdate.setNazwa(producent.getNazwa());

        producentRepository.save(producentToUpdate);
    }

    public void delete(Producent producent) {
        producentRepository.delete(producent);
    }

}