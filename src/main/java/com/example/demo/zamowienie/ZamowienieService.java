package com.example.demo.zamowienie;

import com.example.demo.faktura.Faktura;
import com.example.demo.faktura.FakturaRepository;
import com.example.demo.klient.Klient;
import com.example.demo.pozycja.Pozycja;
import com.example.demo.pozycja.PozycjaRepository;
import com.example.demo.pracownik.Pracownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZamowienieService {
    private final ZamowienieRepository zamowienieRepository;
    private final FakturaRepository fakturaRepository;
    private final PozycjaRepository pozycjaRepository;

    @Autowired
    public ZamowienieService(ZamowienieRepository zamowienieRepository,
                             FakturaRepository fakturaRepository,
                             PozycjaRepository pozycjaRepository) {
        this.zamowienieRepository = zamowienieRepository;
        this.fakturaRepository = fakturaRepository;
        this.pozycjaRepository = pozycjaRepository;
    }

    public Zamowienie findById(Long id) throws ZamowienieNotFoundException {
        return zamowienieRepository.findById(id)
                .orElseThrow(ZamowienieNotFoundException::new);
    }

    public List<Zamowienie> findAll() {
        return zamowienieRepository.findAll();
    }
    public List<Zamowienie> findByKlient(Klient klient) {
        return zamowienieRepository.findByKlient(klient);
    }
    public List<Zamowienie> findByPracownik(Pracownik pracownik) {
        return zamowienieRepository.findByPracownik(pracownik);
    }

    public Zamowienie save(Zamowienie zamowienie) {
        zamowienieRepository.save(zamowienie);
        return zamowienie;
    }

    public void update(Long id, Zamowienie zamowienie) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToUpdate = findById(id);
        zamowienieToUpdate.setStanZamowienia(zamowienie.getStanZamowienia());
        zamowienieToUpdate.setKlient(zamowienie.getKlient());
        zamowienieToUpdate.setPracownik(zamowienie.getPracownik());

        zamowienieRepository.save(zamowienieToUpdate);
    }

    public void assignFaktura(Long id, Faktura faktura) throws ZamowienieNotFoundException {
        Zamowienie zamowienieToAssign = findById(id);
        zamowienieToAssign.setFaktura(faktura);

        fakturaRepository.save(faktura);
        zamowienieRepository.save(zamowienieToAssign);

    }

    public void delete(Zamowienie zamowienie) {
//        for (Pozycja pozycja : zamowienie.collectPozycje()) {
//            pozycjaRepository.delete(pozycja);
//        }
        zamowienieRepository.delete(zamowienie);
    }

    public void calcSum(){
        for (Zamowienie zamowienie: zamowienieRepository.findAll()) {
            float brutto = 0;
            float netto = 0;
            for (Pozycja pozycja: pozycjaRepository.findByZamowienie(zamowienie)) {
                brutto = brutto + pozycja.getIlosc() * pozycja.getTowar().getCenaBrutto();
                netto = netto + pozycja.getIlosc() * pozycja.getTowar().getCenaNetto();
            }
            zamowienie.setKwotaBrutto(brutto);
            zamowienie.setKwotaNetto(netto);
        }
    }

}