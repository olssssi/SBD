package com.example.demo.pracownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PracownikService {
    private final PracownikRepository pracownikRepository;

    @Autowired
    public PracownikService(PracownikRepository pracownikRepository) {
        this.pracownikRepository = pracownikRepository;
    }

    public Pracownik findById(Long id) throws PracownikNotFoundException {
        return pracownikRepository.findById(id)
                .orElseThrow(PracownikNotFoundException::new);
    }

    public List<Pracownik> findAll() {
        return pracownikRepository.findAll();
    }

    public void save(Pracownik pracownik) {
        pracownikRepository.save(pracownik);
    }

    public void update(Long id, Pracownik pracownik) throws PracownikNotFoundException {
        Pracownik pracownikToUpdate = findById(id);
        pracownikToUpdate.setImie(pracownik.getImie());
        pracownikToUpdate.setNazwisko(pracownik.getNazwisko());
        pracownikToUpdate.setTelefon(pracownik.getTelefon());
        pracownikToUpdate.setStanowisko(pracownik.getStanowisko());

        pracownikRepository.save(pracownikToUpdate);
    }

    public void delete(Pracownik pracownik) {
        pracownikRepository.delete(pracownik);
    }

}
