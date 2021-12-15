package com.example.demo.stanowisko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanowiskoService {
    private final StanowiskoRepository stanowiskoRepository;

    @Autowired
    public StanowiskoService(StanowiskoRepository stanowiskoRepository) {
        this.stanowiskoRepository = stanowiskoRepository;
    }

    public Stanowisko findById(Long id) throws StanowiskoNotFoundException {
        return stanowiskoRepository.findById(id)
                .orElseThrow(StanowiskoNotFoundException::new);
    }

    public List<Stanowisko> findAll() {
        return stanowiskoRepository.findAll();
    }

    public void save(Stanowisko stanowisko) {
        stanowiskoRepository.save(stanowisko);
    }

    public void update(Long id, Stanowisko stanowisko) throws StanowiskoNotFoundException {
        Stanowisko stanowiskoToUpdate = findById(id);
        stanowiskoToUpdate.setNazwa(stanowisko.getNazwa());

        stanowiskoRepository.save(stanowiskoToUpdate);
    }

    public void delete(Stanowisko stanowisko) {
        stanowiskoRepository.delete(stanowisko);
    }

}
