package com.example.demo.kategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriaService {
    private final KategoriaRepository kategoriaRepository;

    @Autowired
    public KategoriaService(KategoriaRepository kategoriaRepository) {
        this.kategoriaRepository = kategoriaRepository;
    }

    public Kategoria findById(Long id) throws KategoriaNotFoundException {
        return kategoriaRepository.findById(id)
                .orElseThrow(KategoriaNotFoundException::new);
    }

    public List<Kategoria> findAll() {
        return kategoriaRepository.findAll();
    }

    public void save(Kategoria kategoria) {
        kategoriaRepository.save(kategoria);
    }

    public void update(Long id, Kategoria kategoria) throws KategoriaNotFoundException {
        Kategoria kategoriaToUpdate = findById(id);
        kategoriaToUpdate.setNazwa(kategoria.getNazwa());

        kategoriaRepository.save(kategoriaToUpdate);
    }

    public void delete(Kategoria kategoria) {
        kategoriaRepository.delete(kategoria);
    }

}