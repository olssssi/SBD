package com.example.demo.towar;

import com.example.demo.exceptions.TowarNotFoundException;
import com.example.demo.kategoria.Kategoria;
import com.example.demo.producent.Producent;
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

    public List<Towar> findByProducent(Producent producent){
        return towarRepository.findByProducent(producent);
    }

    public List<Towar> findByKategoria(Kategoria kategoria){
        return towarRepository.findByKategoria(kategoria);
    }

    public List<Towar> findAll() {
        return towarRepository.findAll();
    }

    public void save(Towar towar) {
        towarRepository.save(towar);
    }

    public void update(Long id, Towar towar) throws TowarNotFoundException {
        Towar towarToUpdate = findById(id);
        towarToUpdate.setNazwa(towar.getNazwa());
        towarToUpdate.setCenaNetto(towar.getCenaNetto());
        towarToUpdate.setIlosc(towar.getIlosc());
        towarToUpdate.setKategoria(towar.getKategoria());
        towarToUpdate.setProducent(towar.getProducent());

        towarRepository.save(towarToUpdate);
    }

    public void delete(Towar towar) {
        towarRepository.delete(towar);
    }

}