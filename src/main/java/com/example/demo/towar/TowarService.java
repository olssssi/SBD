package com.example.demo.towar;

import com.example.demo.exceptions.TowarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TowarService {
    private final TowarRepository towarRepository;

    @Autowired
    public TowarService(TowarRepository towarRepository) {
        this.towarRepository = towarRepository;
    }

    public Towar findById(Long id) throws TowarNotFoundException {
        return towarRepository.findById(id)
                .orElseThrow(TowarNotFoundException::new);
    }

    public List<Towar> findAll() {
        return towarRepository.findAll();
    }

    public void save(Towar towar) {
        towarRepository.save(towar);
    }

    public void update(Long id, Towar towar) throws TowarNotFoundException {
        Towar towarToUpdate = findById(id);
        towarToUpdate.setCena(towar.getCena());
        towarToUpdate.setIlosc(towar.getIlosc());
        towarToUpdate.setKategoria(towar.getKategoria());
        towarToUpdate.setProducent(towar.getProducent());

        towarRepository.save(towarToUpdate);
    }

    public void delete(Towar pracownik) {
        towarRepository.delete(pracownik);
    }

}