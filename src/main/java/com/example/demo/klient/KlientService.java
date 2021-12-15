package com.example.demo.klient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlientService{

    @Autowired
    private KlientRepository klientRepository;

    public void save(Klient klient){
        klientRepository.save(klient);
    }

    public void update(Long id, Klient klient) throws KlientNotFoundException {
        Klient klientToUpdate = findById(id);
        klientToUpdate.setImie(klient.getImie());
        klientToUpdate.setNazwisko(klient.getNazwisko());
        klientToUpdate.setTelefon(klient.getTelefon());
        klientToUpdate.setEmail(klient.getEmail());
        klientToUpdate.setNazwaFirmy(klient.getNazwaFirmy());
        klientToUpdate.setNIP(klient.getNIP());
        klientToUpdate.setUlica(klient.getUlica());
        klientToUpdate.setNrLokalu(klient.getNrLokalu());
        klientToUpdate.setMiejscowosc(klient.getMiejscowosc());
        klientToUpdate.setKodPocztowy(klient.getKodPocztowy());
        klientToUpdate.setKraj(klient.getKraj());

        klientRepository.save(klientToUpdate);
    }

    public Klient findById(Long id) throws KlientNotFoundException {
        return klientRepository.findById(id)
                .orElseThrow(KlientNotFoundException::new);
    }

    public List<Klient> findAll(){
        return klientRepository.findAll();
    }

    public void delete(Klient klient){
        klientRepository.delete(klient);
    }
}
