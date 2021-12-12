package com.example.demo.rabat;
import com.example.demo.exceptions.RabatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabatService {
    private final RabatRepository rabatRepository;

    @Autowired
    public RabatService(RabatRepository rabatRepository) {
        this.rabatRepository = rabatRepository;
    }

    public Rabat findById(Long id) throws RabatNotFoundException {
        return rabatRepository.findById(id)
                .orElseThrow(RabatNotFoundException::new);
    }

    public List<Rabat> findAll() {
        return rabatRepository.findAll();
    }

    public void save(Rabat rabat) {
        this.rabatRepository.save(rabat);
    }

    public void update(Long id, Rabat rabat) throws RabatNotFoundException {
        Rabat rabatToUpdate = findById(id);
        rabatToUpdate.setNazwa(rabat.getNazwa());
        rabatToUpdate.setProcentRabatu(rabat.getProcentRabatu());

        this.rabatRepository.save(rabatToUpdate);
    }

    public void delete(Rabat rabat) {
        this.rabatRepository.delete(rabat);
    }

}