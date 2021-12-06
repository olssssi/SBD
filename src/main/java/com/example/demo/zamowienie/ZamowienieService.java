package com.example.demo.zamowienie;

import com.example.demo.exceptions.ZamowienieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZamowienieService {
    private final ZamowienieRepository zamowienieRepository;

    @Autowired
    public ZamowienieService(ZamowienieRepository zamowienieRepository) {
        this.zamowienieRepository = zamowienieRepository;
    }

    public Zamowienie findById(Long id) throws ZamowienieNotFoundException {
        return zamowienieRepository.findById(id)
                .orElseThrow(ZamowienieNotFoundException::new);
    }

    public List<Zamowienie> findAll() {
        return zamowienieRepository.findAll();
    }

    public void save(Zamowienie zamowienie) {
        zamowienieRepository.save(zamowienie);
    }

    public void update(Long id, Zamowienie zamowienie) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToUpdate = findById(id);
        zamowienieToUpdate.setStanZamowienia(zamowienie.getStanZamowienia());
        zamowienieToUpdate.setKlient(zamowienie.getKlient());
        zamowienieToUpdate.setPracownik(zamowienie.getPracownik());

        zamowienieRepository.save(zamowienieToUpdate);
    }

    public void delete(Zamowienie zamowienie) {
        zamowienieRepository.delete(zamowienie);
    }

}